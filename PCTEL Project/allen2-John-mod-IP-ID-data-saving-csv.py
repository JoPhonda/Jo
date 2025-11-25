# importing various libraries
import sys
from PyQt5.QtWidgets import QDialog, QApplication, QPushButton, QVBoxLayout, QLabel, QLineEdit, QMainWindow, QGridLayout
from matplotlib.backends.backend_qt5agg import FigureCanvasQTAgg as FigureCanvas
from matplotlib.backends.backend_qt5agg import NavigationToolbar2QT as NavigationToolbar
import matplotlib.pyplot as plt
import random
import pyvisa as visa
from siggenLib import *
import time
from PyQt5.QtCore import QSize   
import math
import numpy as np


# main window
# which inherits QDialog
class Window(QDialog):
    
		# constructor
	def __init__(self, parent=None):
		super(Window, self).__init__(parent)
		
		# a figure instance to plot on
		self.figure = plt.figure()
		
		# this is the Canvas Widget that
		# displays the 'figure'it takes the
		# 'figure' instance as a parameter to __init__
		self.canvas = FigureCanvas(self.figure)
		
		# this is the Navigation widget
		# it takes the Canvas widget and a parent
		self.toolbar = NavigationToolbar(self.canvas, self)
		
		# Just some button connected to 'plot' method
		self.button = QPushButton('Plot')
		self.button2 = QPushButton('save')    
		
		# adding action to the button
		self.button.clicked.connect(self.plot)
		self.button2.clicked.connect(self.save)
		
		# creating a Vertical Box layout
		layout = QVBoxLayout()
		
		grid_layout = QGridLayout()
		self.setLayout(grid_layout)
		
		# adding tool bar to the layout
		grid_layout.addWidget(self.toolbar, 0, 0)
		
		# adding canvas to the layout
		grid_layout.addWidget(self.canvas, 1, 0)
		
		# adding push button to the layout
		#layout.addWidget(self.button)
		
		
		
		# setting layout to the main window
		self.setLayout(layout)
		
		self.setMinimumSize(QSize(1000, 700))
		self.setWindowTitle("RF-CaLT GUI") 
		
		self.nameLabel_1 = QLabel(self)
		self.nameLabel_1.setText('Signal Generator IP Address:')
		self.line_1 = QLineEdit(self)
		
		self.nameLabel_2 = QLabel(self)
		self.nameLabel_2.setText('Power Sensor ID:')
		self.line_2 = QLineEdit(self)
		
		self.nameLabel_3 = QLabel(self)
		self.nameLabel_3.setText('Start Freq (MHZ):')
		self.line_3 = QLineEdit(self)
		
		#self.line_1.move(120, 20)
		#self.line_1.resize(100, 32)
		#self.nameLabel_1.move(20, 20)
		
		self.nameLabel_4 = QLabel(self)
		self.nameLabel_4.setText('Stop Freq (MHZ):')
		self.line_4 = QLineEdit(self)
		
		#self.line_2.move(120, 60)
		#self.line_2.resize(100, 32)
		#self.nameLabel_2.move(20, 60)
		
		self.nameLabel_5 = QLabel(self)
		self.nameLabel_5.setText('Number of Steps:')
		self.line_5 = QLineEdit(self)
		
		#        self.nameLabel_4 = QLabel(self)
		#        self.nameLabel_4.setText('RF Out (dBm):')
		#        self.line_4 = QLineEdit(self)
		
		#self.line_3.move(120, 100)
		#self.line_3.resize(100, 32)
		#self.nameLabel_3.move(20, 100)
		
		grid_layout.addWidget(self.nameLabel_1, 2, 0)
		grid_layout.addWidget(self.line_1, 3, 0)
		grid_layout.addWidget(self.nameLabel_2, 4, 0)
		grid_layout.addWidget(self.line_2, 5, 0)
		grid_layout.addWidget(self.nameLabel_3, 6, 0)
		grid_layout.addWidget(self.line_3, 7, 0)
		grid_layout.addWidget(self.nameLabel_4, 8, 0)
		grid_layout.addWidget(self.line_4, 9, 0)
		grid_layout.addWidget(self.nameLabel_5, 10, 0)
		grid_layout.addWidget(self.line_5, 11, 0)
		grid_layout.addWidget(self.button, 12, 0)
		grid_layout.addWidget(self.button2, 13, 0)        
		 
		
		# action called by the push button
	def plot(self):
		
		self.measurement()
		
		# random data
		
		# clearing old figure
		self.figure.clear()
		
		# create an axisj
		ax = self.figure.add_subplot(111)
		
		# plot data
		ax.plot(self.freqData, self.lossData, '-o')
		ax.grid(color='k', linestyle='--', linewidth=1)
		# refresh canvas
		self.canvas.draw()


	def save(self):                
        
		np.savetxt('cablelossdata.csv', [p for p in zip(self.freqData, self.lossData)], delimiter=',', fmt='%1.2f')
        



	def measurement(self):
    

		print('Start Freq: ' + self.line_3.text())
		startFreq = int(self.line_3.text())
		print(startFreq)
		
		print('Stop Freq: ' + self.line_4.text())
		stopFreq = int(self.line_4.text())
		print(stopFreq)
		
		print('Number of Steps: ' + self.line_5.text())
		stepNum = int(self.line_5.text())
		print(stepNum)
		
		#        print('RF Out (dBm): ' + self.line_4.text())
		#        RFOut = int(self.line_4.text())
		#        print(RFOut)
		
		print('Signal Generator IP Address: ' + self.line_1.text())
		IPAddress = (self.line_1.text())
		print(IPAddress)
		
		print('Power Sensor ID: ' + self.line_2.text())
		PowerSensorID = (self.line_2.text())
		print(PowerSensorID)
		
		
		
		if startFreq < 1:
		    print ("Start Freq too small!")
		elif startFreq > 6000:
		    print ("Start Freq too large!")
		elif stopFreq > 6000:
		    print ("Stop Freq too large!")
		elif stopFreq < 1:
		    print ("Stop Freq too small!")
		elif stepNum < 2:
		    print ("Number of Steps too small!")
		else:

	
	
			self.ipAddress = IPAddress
			self.siggen = claE443x(self.ipAddress)
			        
			self.rm = visa.ResourceManager()
			#self.ipAddress = "172.16.40.104"
			#powerMeterAddress = "USB0::0x0AAD::0x0158::101132::INSTR"
			self.powerMeterAddress = PowerSensorID
			self.sensor = self.rm.open_resource(self.powerMeterAddress)
			self.sensor.write('*RST')
			time.sleep(10)

			frequency = startFreq
			i = 0
			sN = stepNum - 1
			step = ((stopFreq-startFreq)/sN)
			self.lossData = []
			self.freqData = []
			
			while i < stepNum:
				self.siggen.sgOutputPower(0)
				self.siggen.sgOutput(1, 1)
				self.siggen.sgTune(frequency*1e6)
				
				time.sleep(0.05)
				self.sensor.timeout = float('+inf')
				
				self.sensor.write("SENS:FUNC" + "XTIM:POW")
				self.sensor.write("SENS:FREQ 1.0e9")
				self.sensor.write("SENS:TRAC:TIME 20e-3")
				self.sensor.write("TRIG:SOUR IMM")
				#    sensor.write("TRIG:SLOP POS")
				#    sensor.write("TRIG:DTIM 0.001")
				#    sensor.write("TRIG:HYST 0.1")
				#    sensor.write("TRIG:LEV 30e-6")
				self.sensor.write("SENS:TRAC:AVER:COUN 8")
				self.sensor.write("SENS:TRAC:AVER:STAT ON")
				self.sensor.write("CALC:FEED" + "POW:PEAK:TRA")
				self.sensor.write("INIT")
				self.sensor.write("UNIT:POW DBM")
				self.sensor.timeout = float('+inf')
				
				powerValue = self.sensor.query("FETCh?")
				i = i + 1
				print (float(powerValue))
				self.lossData.append(float(powerValue))
				self.freqData.append (frequency)
				frequency = frequency + step
				print (self.lossData)
				print(self.freqData)

# driver code
if __name__ == '__main__':
    
    # creating apyqt5 application
    app = QApplication(sys.argv)

    # creating a window object
    main = Window()
    
    # showing the window
    main.show()

    # loop

    sys.exit(app.exec_())

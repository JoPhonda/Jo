# Echo client program
import socket
import time
#import visa
#import pyvisa as visa

class claE443x:
    host = '172.16.40.194'    # The remote host
    config = ''
    s = socket.socket()

    def __init__(self, ipAddress):
        self.host = ipAddress
        self.sgConnect()

    def __del__(self):
        self.s.close()
        print ('Siggen Disconnected')

    def sgInquiry(self):
        self.s.send(b'*idn?\n')
        data = self.s.recv(1024)
        self.config = repr(data)
        print ('Received', repr(data))

    def sgOutput(self, mod, rfout):
        if mod == 1:
            self.s.send(b':OUTP:MOD ON\n')
        else:
            self.s.send(b':OUTP:MOD OFF\n')
        if rfout == 1:
            self.s.send(b':OUTP ON\n')
        else:
            self.s.send(b':OUTP OFF\n')

    def sgOutputPower(self, power):
        self.s.send((':POW ' + str(power) + 'dbm\n').encode('utf-8'))

    def sgTune(self, freq):
        self.s.send(('freq ' + str(freq) + 'Hz\n').encode('utf-8'))
        #time.sleep(1)

    def sgWcdmaCpichPower(self, power):
        self.s.send((':RAD:WCDM:TGPP:DLIN:CPIC:POW ' + str(power) + 'dB\n').encode(('utf-8')))

    def sgWcdmaPschPower(self, power):
        self.s.send((':RAD:WCDM:TGPP:DLIN:PSCH:POW ' + str(power) + 'dB\n').encode(('utf-8')))

    def sgWcdmaSschPower(self, power):
        self.s.send((':RAD:WCDM:TGPP:DLIN:SSCH:POW ' + str(power) + 'dB\n').encode(('utf-8')))

    def sgWcdmaScramblingCode(self, code):
        self.s.send((':RAD:WCDM:TGPP:DLIN:SCR ' + str(code) + '\n').encode(('utf-8')))

    #def sgWcdmaDelayInChips(self, delay):
    #    self.s.send((':RAD:WCDM:TGPP:DLIN:SDEL ' + str(delay) + '\n').encode(('utf-8')))

    #def sgWcdmaSetDefault(self):
    #    self.switchARB(0)
    #    self.s.send(b':RAD:WCDM:TGPP:ARB ON')
    #    self.s.send(b':RAD: WCDM:TGPP:ARB:LINK:DOWN:SET PPSCH')
    #    self.s.send(b':RAD:WCDM:TGPP:DLIN:AWGN:STAT ON')
    #    self.s.send(b':RAD:WCDM:TGPP:DLIN:AWGN:CN 30')

    def sendSampleClock(self, sampleClock):
        if (sampleClock != 0):
            sendSampleClock = ':RAD:ARB:CLOC:SRATE ' + "%f"%(sampleClock) + ' MHZ;'
        else:
            sendSampleClock = ''
        self.s.send(sendSampleClock.encode('utf-8'))
    
    def sendTriggerSource(self, triggerSourceNum):
        if triggerSourceNum == 0:
            triggerSourceStr = 'KEY'
        elif triggerSourceNum == 2:
            triggerSourceStr = 'BUS'
        else:
            triggerSourceStr = 'EXT'
        sendTriggerSourceStr = ':RAD:ARB:TRIG ' + triggerSourceStr + ';'
        self.s.send(sendTriggerSourceStr.encode('utf-8')) #External
    
        
    def sendTriggerType(self, triggerTypeNum):
        if triggerTypeNum == 1:
            triggerTypeStr = 'SING'
        elif triggerTypeNum == 2:
            triggerTypeStr = 'GATE'
        elif triggerTypeNum == 3:
            triggerTypeStr = 'SADV'
        else:
            triggerTypeStr = 'CONT'
        sendTriggerTypeStr = ':RAD:ARB:TRIG:TYPE ' + triggerTypeStr + ';'
        self.s.send(sendTriggerTypeStr.encode('utf-8')) #External
    
    def sendExtPolarity(self, extPolarityNum):
        if extPolarityNum == 0:
            extPolarityStr = 'POS'
        else:
            extPolarityStr = 'NEG'
        return extPolarityStr
        sendExtPolStr = ':RAD:ARB:TRIG:EXT:SLOP ' + extPolarityStr + ';'
        self.s.send(sendExtPolStr.encode('utf-8')) #External
    
    def createSequence(self, waveformName):
        self.s.send((':RAD:ARB:SEQ "' + waveformName + '_SEQ","ARBI:' + waveformName + '",75,0,0\n').encode('utf-8'))
        self.s.send((':RAD:ARB:WAV "SEQ:' + waveformName + '_SEQ' + '";').encode('utf-8'))
#        self.s.send(':RAD:ARB:CLOC:SRATE 15.360000 MHZ;')
        self.s.send(b':RAD:ARB:RFIL THR;')
        self.s.send(b':RAD:ARB:CLOC:REF INT;')
    def sendStrCmd(self, strCmd):
        self.s.send(strCmd)
        
    def switchARB(self, arbOut):
        if arbOut == 1:
            self.s.send(b':RAD:ARB:STAT ON;')
        else:
            self.s.send(b':RAD:ARB:STAT OFF;')

    def sgDisconnect(self):
        self.s.close()

    def sgConnect(self):
        PORT = 5025  # The same port as used by the server
        self.s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.s.connect((self.host, PORT))
        self.s.send(b'*opc?\n')
        data = self.s.recv(1024)
        if data == b'1\n':
            print ('Siggen Connected Successfully')
        else:
            print ('Siggen Connection failed')
        self.sgInquiry()
        self.sgOutput(0, 1)

class MxgN5183B: #Add MxgN5183B class for HBflex. DX 08/03/2018 
    host = '172.16.40.194'    # The remote host
    s = socket.socket()

    def __init__(self, ipAddress):
        self.host = ipAddress
        self.sgConnect()

    def __del__(self):
        #self.s.close()
        print ('Siggen Disconnected')
        
    def sgReset(self):
        self.s.send('*RST')
        time.sleep(1)
        self.s.send(':FREQ:MODE FIX')

    def sgInquiry(self):
        self.s.send('*idn?\n')
        data = self.s.recv(1024)
        print ('Received', repr(data))

    def sgOutput(self, mod, rfout):
        if mod == 1:
            self.s.send(':OUTP:MOD:STAT ON\n')
        else:
            self.s.send(':OUTP:MOD:STAT OFF\n')
        if rfout == 1:
            self.s.send(':OUTP:STAT ON\n')
        else:
            self.s.send(':OUTP:STAT OFF\n')

    def sgOutputPower(self, power):
        self.s.send(':POW ' + str(power) + 'dbm\n')

    def sgTune(self, freq):
        self.s.send(':FREQ:FIXED ' + str(freq) + 'Hz\n') 
        time.sleep(0.5)

    def sendSampleClock(self, sampleClock):
        if (sampleClock != 0):
            sendSampleClock = ':RAD:ARB:CLOC:SRATE ' + "%f"%(sampleClock) + ' MHZ;'
        else:
            sendSampleClock = ''
        self.s.send(sendSampleClock)
    
    def sendTriggerSource(self, triggerSourceNum):
        if triggerSourceNum == 0:
            triggerSourceStr = 'KEY'
        elif triggerSourceNum == 2:
            triggerSourceStr = 'BUS'
        else:
            triggerSourceStr = 'EXT'
        sendTriggerSourceStr = ':RAD:ARB:TRIG ' + triggerSourceStr + ';'
        self.s.send(sendTriggerSourceStr) #External
    
        
    def sendTriggerType(self, triggerTypeNum):
        if triggerTypeNum == 1:
            triggerTypeStr = 'SING'
        elif triggerTypeNum == 2:
            triggerTypeStr = 'GATE'
        elif triggerTypeNum == 3:
            triggerTypeStr = 'SADV'
        else:
            triggerTypeStr = 'CONT'
        sendTriggerTypeStr = ':RAD:ARB:TRIG:TYPE ' + triggerTypeStr + ';'
        self.s.send(sendTriggerTypeStr) #External
    
    def sendExtPolarity(self, extPolarityNum):
        if extPolarityNum == 0:
            extPolarityStr = 'POS'
        else:
            extPolarityStr = 'NEG'
        return extPolarityStr
        sendExtPolStr = ':RAD:ARB:TRIG:EXT:SLOP ' + extPolarityStr + ';'
        self.s.send(sendExtPolStr) #External
    
    def createSequence(self, waveformName):
        self.s.send(':RAD:ARB:SEQ "' + waveformName + '_SEQ","ARBI:' + waveformName + '",75,0,0\n')
        self.s.send(':RAD:ARB:WAV "SEQ:' + waveformName + '_SEQ' + '";')
#        self.s.send(':RAD:ARB:CLOC:SRATE 15.360000 MHZ;')
        self.s.send(':RAD:ARB:RFIL THR;')
        self.s.send(':RAD:ARB:CLOC:REF INT;')

    def sendStrCmd(self, strCmd):
        self.s.send(strCmd)
        
    def switchARB(self, arbOut):
        if arbOut == 1:
            self.s.send(':RAD:ARB:STAT ON;')
        else:
            self.s.send(':RAD:ARB:STAT OFF;')

    def sgDisconnect(self):
        self.s.close()

    def sgConnect(self):
        PORT = 5025  # The same port as used by the server
        self.s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.s.connect((self.host, PORT))
        self.s.send('*opc?\n')
        data = self.s.recv(1024)
        if data == '1\n':
            print ('Siggen Connected Successfully')
        else:
            print ('Siggen Connection failed')
        self.sgInquiry()
        self.sgOutput(0, 1)
        self.sgReset()
        
class HP83640B: #only has GPIB     
    def __init__(self, ipAddress):
        self.gpibAddress = "GPIB0::%s::INSTR" % ipAddress
        self.rm = visa.ResourceManager()
        self.gpibLink = self.rm.open_resource(self.gpibAddress)
        self.status = "HP83640B %s" % self.gpibAddress
               
        self.sgOutput(0, 1)
        time.sleep(1) 
        self.sgReset()
        time.sleep(2)
      
    def __del__(self):
        self.rm.close()
        print ('Siggen Disconnected')
        
    def sgReset(self):
        self.gpibLink.write('*RST')
        self.gpibLink.write('*WAI')
        self.gpibLink.write(':DISP:STAT ON\n')
        self.gpibLink.write('*WAI')
        self.gpibLink.write(':POW:STAT ON\n')        

    def sgInquiry(self):
        self.gpibLink.write('*idn?\n')
        data = self.gpibLink.read()
        print ('Received', repr(data))

    def sgOutput(self, mod, rfout):
        if mod == 1:
            self.gpibLink.write(':OUTP:MODE ON\n')
        else:
            self.gpibLink.write(':OUTP:MODE OFF\n')
        self.gpibLink.write("*WAI")
        if rfout == 1:
            self.gpibLink.write(':OUTP:STAT ON\n')
        else:
            self.gpibLink.write(':OUTP:STAT OFF\n')
        self.gpibLink.write("*WAI")

    def sgOutputPower(self, power):
        self.gpibLink.write(':POW ' + str(power) + 'dbm\n')

    def sgTune(self, freq):
        self.gpibLink.write(':FREQ:FIXED ' + str(freq) + 'Hz\n') 
        time.sleep(0.5)

    def sendSampleClock(self, sampleClock):
        if (sampleClock != 0):
            sendSampleClock = ':RAD:ARB:CLOC:SRATE ' + "%f"%(sampleClock) + ' MHZ;'
        else:
            sendSampleClock = ''
        self.gpibLink.write(sendSampleClock)
    
    def sendTriggerSource(self, triggerSourceNum):
        if triggerSourceNum == 0:
            triggerSourceStr = 'KEY'
        elif triggerSourceNum == 2:
            triggerSourceStr = 'BUS'
        else:
            triggerSourceStr = 'EXT'
        sendTriggerSourceStr = ':RAD:ARB:TRIG ' + triggerSourceStr + ';'
        self.gpibLink.write(sendTriggerSourceStr) #External
    
        
    def sendTriggerType(self, triggerTypeNum):
        if triggerTypeNum == 1:
            triggerTypeStr = 'SING'
        elif triggerTypeNum == 2:
            triggerTypeStr = 'GATE'
        elif triggerTypeNum == 3:
            triggerTypeStr = 'SADV'
        else:
            triggerTypeStr = 'CONT'
        sendTriggerTypeStr = ':RAD:ARB:TRIG:TYPE ' + triggerTypeStr + ';'
        self.gpibLink.write(sendTriggerTypeStr) #External
    
    def sendExtPolarity(self, extPolarityNum):
        if extPolarityNum == 0:
            extPolarityStr = 'POS'
        else:
            extPolarityStr = 'NEG'
        return extPolarityStr
        sendExtPolStr = ':RAD:ARB:TRIG:EXT:SLOP ' + extPolarityStr + ';'
        self.gpibLink.write(sendExtPolStr) #External
    
    def createSequence(self, waveformName):
        self.gpibLink.write(':RAD:ARB:SEQ "' + waveformName + '_SEQ","ARBI:' + waveformName + '",75,0,0\n')
        self.gpibLink.write(':RAD:ARB:WAV "SEQ:' + waveformName + '_SEQ' + '";')
#        self.s.send(':RAD:ARB:CLOC:SRATE 15.360000 MHZ;')
        self.gpibLink.write(':RAD:ARB:RFIL THR;')
        self.gpibLink.write(':RAD:ARB:CLOC:REF INT;')

    def sendStrCmd(self, strCmd):
        self.gpibLink.write(strCmd)
        
    def switchARB(self, arbOut):
        if arbOut == 1:
            self.gpibLink.write(':RAD:ARB:STAT ON;')
        else:
            self.gpibLink.write(':RAD:ARB:STAT OFF;')

    def sgDisconnect(self):
        self.rm.close()

class HP8360: #only has GPIB     
    def __init__(self, ipAddress):
        self.gpibAddress = "GPIB0::%s::INSTR" % ipAddress
        self.rm = visa.ResourceManager()
        self.gpibLink = self.rm.open_resource(self.gpibAddress)
        self.status = "HP8360 %s" % self.gpibAddress
        
        #self.sgInquiry()
        self.sgReset()
        print ('Siggen is connected') 
      
    def __del__(self):
        self.rm.close()
        print ('Siggen Disconnected')
        
    def sgReset(self):
        self.gpibLink.write('*RST')
        self.gpibLink.write('*WAI')
        self.gpibLink.write(':FREQ:MODE FIX')

    def sgInquiry(self):
        self.gpibLink.write('*idn?\n')
        data = self.gpibLink.read()
        print ('Received', repr(data))

    def sgOutput(self, mod, rfout):
        if mod == 1:
            self.gpibLink.write(':OUTP:STAT ON\n')
        else:
            self.gpibLink.write(':OUTP:STAT OFF\n')
        self.gpibLink.write("*WAI")
        if rfout == 1:
            self.gpibLink.write(':POW:STAT ON\n')
        else:
            self.gpibLink.write(':POW:STAT OFF\n')
        self.gpibLink.write("*WAI")

    def sgOutputPower(self, power):
        self.gpibLink.write(':POW ' + str(power) + 'dbm\n')

    def sgTune(self, freq):
        self.gpibLink.write(':FREQ:FIX ' + str(freq) + 'Hz\n') 
        time.sleep(0.5)

    def sendSampleClock(self, sampleClock):
        if (sampleClock != 0):
            sendSampleClock = ':RAD:ARB:CLOC:SRATE ' + "%f"%(sampleClock) + ' MHZ;'
        else:
            sendSampleClock = ''
        self.gpibLink.write(sendSampleClock)
    
    def sendTriggerSource(self, triggerSourceNum):
        if triggerSourceNum == 0:
            triggerSourceStr = 'KEY'
        elif triggerSourceNum == 2:
            triggerSourceStr = 'BUS'
        else:
            triggerSourceStr = 'EXT'
        sendTriggerSourceStr = ':RAD:ARB:TRIG ' + triggerSourceStr + ';'
        self.gpibLink.write(sendTriggerSourceStr) #External
    
        
    def sendTriggerType(self, triggerTypeNum):
        if triggerTypeNum == 1:
            triggerTypeStr = 'SING'
        elif triggerTypeNum == 2:
            triggerTypeStr = 'GATE'
        elif triggerTypeNum == 3:
            triggerTypeStr = 'SADV'
        else:
            triggerTypeStr = 'CONT'
        sendTriggerTypeStr = ':RAD:ARB:TRIG:TYPE ' + triggerTypeStr + ';'
        self.gpibLink.write(sendTriggerTypeStr) #External
    
    def sendExtPolarity(self, extPolarityNum):
        if extPolarityNum == 0:
            extPolarityStr = 'POS'
        else:
            extPolarityStr = 'NEG'
        return extPolarityStr
        sendExtPolStr = ':RAD:ARB:TRIG:EXT:SLOP ' + extPolarityStr + ';'
        self.gpibLink.write(sendExtPolStr) #External
    
    def createSequence(self, waveformName):
        self.gpibLink.write(':RAD:ARB:SEQ "' + waveformName + '_SEQ","ARBI:' + waveformName + '",75,0,0\n')
        self.gpibLink.write(':RAD:ARB:WAV "SEQ:' + waveformName + '_SEQ' + '";')
#        self.s.send(':RAD:ARB:CLOC:SRATE 15.360000 MHZ;')
        self.gpibLink.write(':RAD:ARB:RFIL THR;')
        self.gpibLink.write(':RAD:ARB:CLOC:REF INT;')

    def sendStrCmd(self, strCmd):
        self.gpibLink.write(strCmd)
        
    def switchARB(self, arbOut):
        if arbOut == 1:
            self.gpibLink.write(':RAD:ARB:STAT ON;')
        else:
            self.gpibLink.write(':RAD:ARB:STAT OFF;')

    def sgDisconnect(self):
        self.rm.close()

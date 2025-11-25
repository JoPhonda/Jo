using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.IO.Ports;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PressurePlate1
{
    public partial class Form1: Form
    {
        int value = 0;
        double sum;
        int steps;
        double avgStep;
        public Stopwatch watch { get; set; }
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            watch = Stopwatch.StartNew();
            port.BaudRate = 9600;
            
        }

        public void loop() { 
            
        }

        private void port_DataReceived(object sender, System.IO.Ports.SerialDataReceivedEventArgs e)
        {
            this.Invoke(new EventHandler(port_DataReceived));

        }
        private void port_DataReceived(object sender, EventArgs e)
        {
            if (watch.ElapsedMilliseconds > 15) {
                watch = Stopwatch.StartNew();
            string dump = port.ReadLine();
            if (value == 0 && Convert.ToInt32(dump) > 0) {
                steps++;
            }
            if (value != Convert.ToInt32(dump)) {
                value = Convert.ToInt32(dump);
                valueTB.Text = valueTB.Text + dump;
                double dump1 = Convert.ToDouble(dump);
                sum += dump1;
                sumTB.Text = ((dump1 / 10) * 5).ToString();
                stepTB.Text = steps.ToString();
                avgStep = sum / Convert.ToDouble(steps);
                avgStepTB.Text = avgStep.ToString();
            }
        }
        }
    }
}

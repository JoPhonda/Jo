namespace PressurePlate1
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.port = new System.IO.Ports.SerialPort(this.components);
            this.folderBrowserDialog1 = new System.Windows.Forms.FolderBrowserDialog();
            this.valueTB = new System.Windows.Forms.RichTextBox();
            this.sumTB = new System.Windows.Forms.RichTextBox();
            this.stepTB = new System.Windows.Forms.RichTextBox();
            this.avgStepTB = new System.Windows.Forms.RichTextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // port
            // 
            this.port.PortName = "COM4";
            this.port.DataReceived += new System.IO.Ports.SerialDataReceivedEventHandler(this.port_DataReceived);
            // 
            // valueTB
            // 
            this.valueTB.Location = new System.Drawing.Point(60, 50);
            this.valueTB.Name = "valueTB";
            this.valueTB.Size = new System.Drawing.Size(262, 61);
            this.valueTB.TabIndex = 0;
            this.valueTB.Text = "";
            // 
            // sumTB
            // 
            this.sumTB.Location = new System.Drawing.Point(60, 147);
            this.sumTB.Name = "sumTB";
            this.sumTB.Size = new System.Drawing.Size(262, 61);
            this.sumTB.TabIndex = 1;
            this.sumTB.Text = "";
            // 
            // stepTB
            // 
            this.stepTB.Location = new System.Drawing.Point(60, 240);
            this.stepTB.Name = "stepTB";
            this.stepTB.Size = new System.Drawing.Size(262, 61);
            this.stepTB.TabIndex = 2;
            this.stepTB.Text = "";
            // 
            // avgStepTB
            // 
            this.avgStepTB.Location = new System.Drawing.Point(60, 333);
            this.avgStepTB.Name = "avgStepTB";
            this.avgStepTB.Size = new System.Drawing.Size(262, 61);
            this.avgStepTB.TabIndex = 3;
            this.avgStepTB.Text = "";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(57, 31);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(144, 16);
            this.label1.TabIndex = 4;
            this.label1.Text = "Value of current energy";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(57, 128);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(93, 16);
            this.label2.TabIndex = 5;
            this.label2.Text = "Sum of energy";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(57, 221);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(132, 16);
            this.label3.TabIndex = 6;
            this.label3.Text = "total number of Steps";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(57, 314);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(164, 16);
            this.label4.TabIndex = 7;
            this.label4.Text = "Average value of one step";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(382, 453);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.avgStepTB);
            this.Controls.Add(this.stepTB);
            this.Controls.Add(this.sumTB);
            this.Controls.Add(this.valueTB);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.IO.Ports.SerialPort port;
        private System.Windows.Forms.FolderBrowserDialog folderBrowserDialog1;
        private System.Windows.Forms.RichTextBox valueTB;
        private System.Windows.Forms.RichTextBox sumTB;
        private System.Windows.Forms.RichTextBox stepTB;
        private System.Windows.Forms.RichTextBox avgStepTB;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
    }
}


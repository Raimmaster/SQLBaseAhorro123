namespace SQLBaseCRUDGenerator
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
            this.label1 = new System.Windows.Forms.Label();
            this.tNombreTabla = new System.Windows.Forms.TextBox();
            this.tNombreCampo = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.cbTipo = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.lbCampos = new System.Windows.Forms.ListBox();
            this.bInsertar = new System.Windows.Forms.Button();
            this.bReset = new System.Windows.Forms.Button();
            this.bGenerar = new System.Windows.Forms.Button();
            this.rtfInsert = new System.Windows.Forms.RichTextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.lUpdate = new System.Windows.Forms.Label();
            this.rtfUpdate = new System.Windows.Forms.RichTextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.rtfDelete = new System.Windows.Forms.RichTextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.rtfRead = new System.Windows.Forms.RichTextBox();
            this.cbPK = new System.Windows.Forms.CheckBox();
            this.button1 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(9, 18);
            this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(77, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Nombre Tabla:";
            // 
            // tNombreTabla
            // 
            this.tNombreTabla.Location = new System.Drawing.Point(117, 18);
            this.tNombreTabla.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.tNombreTabla.Name = "tNombreTabla";
            this.tNombreTabla.Size = new System.Drawing.Size(135, 20);
            this.tNombreTabla.TabIndex = 0;
            // 
            // tNombreCampo
            // 
            this.tNombreCampo.Location = new System.Drawing.Point(117, 50);
            this.tNombreCampo.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.tNombreCampo.Name = "tNombreCampo";
            this.tNombreCampo.Size = new System.Drawing.Size(135, 20);
            this.tNombreCampo.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(9, 50);
            this.label2.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(83, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Nombre Campo:";
            // 
            // cbTipo
            // 
            this.cbTipo.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbTipo.FormattingEnabled = true;
            this.cbTipo.Items.AddRange(new object[] {
            "String",
            "int",
            "double",
            "Date",
            "BOOLEAN"});
            this.cbTipo.Location = new System.Drawing.Point(117, 85);
            this.cbTipo.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.cbTipo.Name = "cbTipo";
            this.cbTipo.Size = new System.Drawing.Size(152, 21);
            this.cbTipo.TabIndex = 2;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(9, 91);
            this.label3.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(31, 13);
            this.label3.TabIndex = 5;
            this.label3.Text = "Tipo:";
            // 
            // lbCampos
            // 
            this.lbCampos.FormattingEnabled = true;
            this.lbCampos.Location = new System.Drawing.Point(11, 158);
            this.lbCampos.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.lbCampos.Name = "lbCampos";
            this.lbCampos.Size = new System.Drawing.Size(133, 212);
            this.lbCampos.TabIndex = 6;
            // 
            // bInsertar
            // 
            this.bInsertar.Location = new System.Drawing.Point(11, 121);
            this.bInsertar.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.bInsertar.Name = "bInsertar";
            this.bInsertar.Size = new System.Drawing.Size(56, 32);
            this.bInsertar.TabIndex = 3;
            this.bInsertar.Text = "Insertar";
            this.bInsertar.UseVisualStyleBackColor = true;
            this.bInsertar.Click += new System.EventHandler(this.bInsertar_Click);
            // 
            // bReset
            // 
            this.bReset.Location = new System.Drawing.Point(87, 396);
            this.bReset.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.bReset.Name = "bReset";
            this.bReset.Size = new System.Drawing.Size(56, 32);
            this.bReset.TabIndex = 5;
            this.bReset.Text = "Reset";
            this.bReset.UseVisualStyleBackColor = true;
            this.bReset.Click += new System.EventHandler(this.bReset_Click);
            // 
            // bGenerar
            // 
            this.bGenerar.Location = new System.Drawing.Point(11, 396);
            this.bGenerar.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.bGenerar.Name = "bGenerar";
            this.bGenerar.Size = new System.Drawing.Size(56, 32);
            this.bGenerar.TabIndex = 4;
            this.bGenerar.Text = "Generar";
            this.bGenerar.UseVisualStyleBackColor = true;
            this.bGenerar.Click += new System.EventHandler(this.bGenerar_Click);
            // 
            // rtfInsert
            // 
            this.rtfInsert.Location = new System.Drawing.Point(167, 157);
            this.rtfInsert.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.rtfInsert.Name = "rtfInsert";
            this.rtfInsert.Size = new System.Drawing.Size(237, 172);
            this.rtfInsert.TabIndex = 10;
            this.rtfInsert.Text = "";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(172, 128);
            this.label4.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(33, 13);
            this.label4.TabIndex = 11;
            this.label4.Text = "Insert";
            // 
            // lUpdate
            // 
            this.lUpdate.AutoSize = true;
            this.lUpdate.Location = new System.Drawing.Point(427, 128);
            this.lUpdate.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lUpdate.Name = "lUpdate";
            this.lUpdate.Size = new System.Drawing.Size(42, 13);
            this.lUpdate.TabIndex = 13;
            this.lUpdate.Text = "Update";
            // 
            // rtfUpdate
            // 
            this.rtfUpdate.Location = new System.Drawing.Point(422, 157);
            this.rtfUpdate.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.rtfUpdate.Name = "rtfUpdate";
            this.rtfUpdate.Size = new System.Drawing.Size(237, 172);
            this.rtfUpdate.TabIndex = 12;
            this.rtfUpdate.Text = "";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(172, 336);
            this.label6.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(38, 13);
            this.label6.TabIndex = 15;
            this.label6.Text = "Delete";
            // 
            // rtfDelete
            // 
            this.rtfDelete.Location = new System.Drawing.Point(167, 364);
            this.rtfDelete.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.rtfDelete.Name = "rtfDelete";
            this.rtfDelete.Size = new System.Drawing.Size(237, 172);
            this.rtfDelete.TabIndex = 14;
            this.rtfDelete.Text = "";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(434, 336);
            this.label5.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(33, 13);
            this.label5.TabIndex = 17;
            this.label5.Text = "Read";
            // 
            // rtfRead
            // 
            this.rtfRead.Location = new System.Drawing.Point(429, 364);
            this.rtfRead.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.rtfRead.Name = "rtfRead";
            this.rtfRead.Size = new System.Drawing.Size(237, 172);
            this.rtfRead.TabIndex = 16;
            this.rtfRead.Text = "";
            // 
            // cbPK
            // 
            this.cbPK.AutoSize = true;
            this.cbPK.Location = new System.Drawing.Point(87, 128);
            this.cbPK.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.cbPK.Name = "cbPK";
            this.cbPK.Size = new System.Drawing.Size(40, 17);
            this.cbPK.TabIndex = 18;
            this.cbPK.Text = "PK";
            this.cbPK.UseVisualStyleBackColor = true;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(11, 457);
            this.button1.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(56, 32);
            this.button1.TabIndex = 19;
            this.button1.Text = "Nombres";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(741, 559);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.cbPK);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.rtfRead);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.rtfDelete);
            this.Controls.Add(this.lUpdate);
            this.Controls.Add(this.rtfUpdate);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.rtfInsert);
            this.Controls.Add(this.bGenerar);
            this.Controls.Add(this.bReset);
            this.Controls.Add(this.bInsertar);
            this.Controls.Add(this.lbCampos);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.cbTipo);
            this.Controls.Add(this.tNombreCampo);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.tNombreTabla);
            this.Controls.Add(this.label1);
            this.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.Name = "Form1";
            this.Text = "CRUD Generator";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox tNombreTabla;
        private System.Windows.Forms.TextBox tNombreCampo;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox cbTipo;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ListBox lbCampos;
        private System.Windows.Forms.Button bInsertar;
        private System.Windows.Forms.Button bReset;
        private System.Windows.Forms.Button bGenerar;
        private System.Windows.Forms.RichTextBox rtfInsert;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label lUpdate;
        private System.Windows.Forms.RichTextBox rtfUpdate;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.RichTextBox rtfDelete;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.RichTextBox rtfRead;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.CheckBox cbPK;
        private System.Windows.Forms.Button button1;
    }
}


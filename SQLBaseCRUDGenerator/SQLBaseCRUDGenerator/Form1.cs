using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SQLBaseCRUDGenerator
{       

    public partial class Form1 : Form
    {

        List<Campo> campos = new List<Campo>();

        public Form1()
        {
            InitializeComponent();         
        }

        private void bInsertar_Click(object sender, EventArgs e)
        {
            campos.Add(new Campo(tNombreCampo.Text, cbTipo.Text, cbPK.Checked));
            
            lbCampos.Items.Add(tNombreCampo.Text);

            lbCampos.Refresh();
            limpiar();
            foreach (Campo valor in campos)
                Console.WriteLine(valor.nombre + ": " + valor.tipo);

            tNombreCampo.Focus();
        }

        private void bReset_Click(object sender, EventArgs e)
        {
            campos.Clear();
            lbCampos.Items.Clear();
            lbCampos.Refresh();
            limpiar();
            tNombreTabla.Clear();
            rtfRead.Clear();
            rtfInsert.Clear();
            rtfDelete.Clear();
            rtfUpdate.Clear();
        }

        private void limpiar()
        {
            tNombreCampo.Clear();
            cbPK.Checked = false;
        }

        private void bGenerar_Click(object sender, EventArgs e)
        {
            rtfInsert.Text = generateProcedure("INSERT");
            rtfUpdate.Text = generateProcedure("UPDATE");
            rtfDelete.Text = generateProcedure("DELETE");
            rtfRead.Text = generateProcedure("SELECT");
        }

        private string generateProcedure(string procedureName)
        {
            string procedure = "";

            string storePart = "";
            string parameterPart = "";
            string localVariablesPart = "Local Variables\n\tSql Handle hSql\n";
            string actionsPart = "Actions\n";
            string sqlCommand = "";

            string storeName = "SP_" + tNombreTabla.Text.Trim() + "_" + procedureName;
            StringBuilder sbParameters = new StringBuilder();
            StringBuilder sbCampos = new StringBuilder();
            StringBuilder sbAlternosParams = new StringBuilder();

            foreach (Campo c in campos)
            {//for parameter section
                if(c.nombre.Contains("FECHA"))
                    continue;

                sbParameters.Append("\t" + c.tipo + ": " + "n_" + c.nombre + "\n");
            }          

            switch (procedureName)
            {
                case "INSERT":
                    for (int i = 0; i < campos.Count; i++)
                    {//for insert into section
                        sbCampos.Append(campos[i].nombre);

                        if (i < campos.Count - 1)
                            sbCampos.Append(",");
                    }
                        
                    for (int i = 0; i < campos.Count; i++)
                    {//for other section

                        if (campos[i].nombre.Contains("FECHA"))
                            continue;

                            sbAlternosParams.Append(":n_" + campos[i].nombre);


                        if (i < campos.Count - 1)
                            sbAlternosParams.Append(",");
                    }

                    sqlCommand = "INSERT INTO " + tNombreTabla.Text +
                        "(" + sbCampos.ToString() + ") VALUES (" +
                        sbAlternosParams.ToString() + ")";
                    break;
                case "UPDATE":
                    for (int i = 1; i < campos.Count; i++)
                    {//for update into section
                        sbCampos.Append(campos[i].nombre + " = :n_" + campos[i].nombre);

                        if (i < campos.Count - 1)
                            sbCampos.Append(", ");
                    }

                    sqlCommand = "UPDATE " + tNombreTabla.Text.Trim() +
                        " SET " + sbCampos.ToString() + " WHERE " +
                        campos[0].nombre + " = :n_" + campos[0].nombre;
                    break;
                case "DELETE":
                    sqlCommand = "DELETE FROM " + tNombreTabla.Text.Trim() +
                        " WHERE " + campos[0].nombre + " = :n_" + campos[0].nombre;
                    break;
                case "SELECT":
                    localVariablesPart += "\tNUMBER nInd\n";
                    sqlCommand = "SELECT " + sbCampos.ToString() + " FROM "
                        + tNombreTabla.Text.Trim() + " WHERE " + campos[0].nombre + " = :n_" + campos[0].nombre;
                    break;
            }

            storePart = "STORE " + storeName + "\nProcedure " + storeName +
                        " STATIC\n";

            parameterPart = "Parameters\n" + sbParameters.ToString();
            actionsPart += "\tOn Procedure Startup\n\t\tCall SqlConnect( hsql )\n" +
                "\tOn Procedure Execute\n\t\tCall SqlPrepare ( hSql, '" + sqlCommand +
                "')\n\t\tCall SqlExecute(hSql)\n\tOn Procedure Close\n\t\tCall SqlDisconnect( hSql );";

            procedure = storePart + parameterPart + localVariablesPart + actionsPart;

            return procedure;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            StringBuilder sb = new StringBuilder();

            foreach(Campo c in campos)
            {
                sb.Append("SP_" + c.nombre + "_INSERT\n");
                sb.Append("SP_" + c.nombre + "_UPDATE\n");
                sb.Append("SP_" + c.nombre + "_DELETE\n");
            }

            rtfInsert.Text = sb.ToString();
        }
    }

    public class Campo
    {
        public string nombre { get; set; }
        public string tipo { get; set; }
        public bool isPK { get; set; }

        public Campo(string nombre, string tipo, bool isPK)
        {
            this.nombre = nombre;
            this.tipo = tipo;
            this.isPK = isPK;
        }
    }
}

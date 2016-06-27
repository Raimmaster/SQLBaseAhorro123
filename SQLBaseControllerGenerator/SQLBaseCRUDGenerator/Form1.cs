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

        private string classConstructor()
        {
            string tabla = tNombreTabla.Text;
            string packageImports = "package Controller;\n" +
                "import Model.*;\n" +
                "import java.sql.*;\n" +
                "import javax.swing.*;\n";

            string className = "C" + tabla;
            string classDeclaration = "public class " + className + "{\n";

            string atributos = "Connection con;\nCallableStatement cstmt\n;" +
                "Statement st;\nResultSet rs;\nString driver;\n";

            string constuctorName = "public " + className + "() {\n";
            string constructorBody = "try{\n" +
                "Class.forName(\"jdbc.gupta.sqlbase.SqlbaseDriver\");" +
                "this.driver = \"jdbc:sqlbase://localhost:2155/AHORRO123\";" +
            "}\n" +
            "catch (Exception e){\n" +
            "    JOptionPane.showMessageDialog(null, e.getMessage());\n" +
        "}\n }\n";

            string modelName = "Model" + tabla;

            //metodo read content
            string metodoRead = "public " + modelName + "get" + tabla + "(" + campos[0].tipo + " " + campos[0].nombre + ") {\n";
            string metodoReadBody = "MEmpleados m = new MEmpleados();" +
                            "try\n" +
                            "{\n" +
                            "   rs = st.executeQuery(\"select * from " + tabla + " where " + campos[0].nombre + "=\" + id);\n" +
                            "    rs.next();";

            foreach (Campo c in campos)
            {//for parameter section
                metodoReadBody += "m." + c.nombre + "= rs.get" + c.tipo + "(\"" + c.nombre + "\");";
            }

            metodoReadBody += "} \n" +
                "catch (Exception e)" +
            "{" +
            "    JOptionPane.showMessageDialog(null, e.getMessage());" +
            "}" +

            "return m; ";

            //text for insert method
            string metodoInsert = "public void insert" + tabla + "(" + modelName + " m){\n"
                + "try {\ncstmt = con.prepareCall(\"{call SP_" + tabla + "_INSERT}\");\n";

            for (int i = 0; i < campos.Count; i++)
            {
                int paramIndex = i + 1;
                metodoInsert += "cstmt.set" + campos[i].tipo
                                    + "(" + paramIndex + ", m." + campos[i].nombre
                                    + ");\n";
            }

            metodoInsert += "cstmt.executeUpdate();\n con.commit();\n";
            metodoInsert += "}\n catch (Exception e) {\nJOptionPane.showMessageDialog(null, e.getMessage());\n}\n";

            //text for update method
            string metodoUpdate = "public void update" + tabla + "(" + modelName + " m){\n"
                + "try {\ncstmt = con.prepareCall(\"{call SP_" + tabla + "_UPDATE}\");\n";

            for (int i = 0; i < campos.Count; i++)
            {
                int paramIndex = i + 1;
                metodoUpdate += "cstmt.set" + campos[i].tipo
                                    + "(" + paramIndex + ", m." + campos[i].nombre
                                    + ");\n";
            }

            metodoUpdate += "cstmt.executeUpdate();\n con.commit();\n";
            metodoUpdate += "}\n catch (Exception e) {\nJOptionPane.showMessageDialog(null, e.getMessage());\n}\n";

            //text for delete method
            string metodoDelete = "public void delete" + tabla + "(" + modelName + " m){\n"
                + "try {\ncstmt = con.prepareCall(\"{call SP_" + tabla + "_DELETE}\");\n";

            metodoDelete += "cstmt.set" + campos[0].tipo
                                + "(" + 1 + ", m." + campos[0].nombre
                                + ");\n";

            metodoDelete += "cstmt.executeUpdate();\n con.commit();\n";
            metodoDelete += "}\n catch (Exception e) {\nJOptionPane.showMessageDialog(null, e.getMessage());\n}\n";

            //text for obtener datos
            string obtenerDatos = " public DefaultListModel obtenerDatos ()\n" +
                "{\n" +
                "DefaultListModel l = new DefaultListModel();\n" +
                "try\n" +
                "{\n" +
                 "   ResultSet rs = st.executeQuery(\"select * from " + tabla + "\");\n" +
                 "           while (rs.next())\n" +
                  "  {\n";

            foreach (Campo c in campos)
            {//for parameter section
                obtenerDatos += "l.addElement(rs.get" + c.tipo + "(\"" + c.nombre + "\");";
            }


            obtenerDatos += "}\n" +
       " }\n" +
       " catch (Exception e)\n" +
    "{\n" +
     "   JOptionPane.showMessageDialog(null, e.getMessage());\n" +
    "}\n" +
    "return l;\n" +
"}\n}";

            string total = packageImports + classDeclaration +
                atributos + constuctorName + constructorBody +
                metodoRead + metodoReadBody + metodoInsert +
                metodoUpdate + metodoDelete + obtenerDatos;

            return total;
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
                if (c.nombre.Contains("FECHA"))
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

            foreach (Campo c in campos)
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

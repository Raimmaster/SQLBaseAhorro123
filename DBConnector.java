package dbconnector;

//import jdbc.gupta.sqlbase.*;
//import jdbc.unify.sqlbase.*;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Raim
 */
public class DBConnector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");
            String driver = "jdbc:sqlbase://localhost:2155/AHORRO123";
            spTest(driver);
            startTransaction(driver);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    private static void spTest(String url){
        try {

            Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");
            //String url = "";
           /* if (args.length > 0
                    && args[0].length() > 0) {

                url = args[0];

            } // ENDIF Get Connection URL */

            Connection con = DriverManager.getConnection(url,
                    "SYSADM", "SYSADM");
            /*

	STRING:  n_Id_Usuario
	STRING:  n_Clave
	STRING:  n_Username
	STRING: n_ID_USU_CREA

            */
            CallableStatement cstmt = con.prepareCall("{call SP_USUARIOS_INSERT}");

            Scanner lea = new Scanner(System.in);

            for(int i = 1; i <= 4; i++){
                System.out.println("Param: " + i);
                cstmt.setString(i, lea.next());
            }

            cstmt.executeUpdate();
            con.commit();

            // Is it there?
            /*Statement s = con.createStatement();

            ResultSet r = s.executeQuery("SELECT *FROM USUARIOS");

            while (r.next()) {
                int i = r.getInt(1);

                String str = r.getString(2);

                System.out.println("C1: " + i + " C2: " + str);

            }*/

            cstmt.close();

            //s.close();

            con.close();

        } catch (Exception ex) {
            System.out.println("\nException in main: " + ex + "\n");

            System.out.println("Unable to access or execute procedure");

        }
    }
    
    public static void startTransaction(String driver) {
        Connection conn = null;
       // Scanner lector = new Scanner(System.in);
        //String bdd = "AHORRO123";
        String user = "SYSADM";
        String password = "SYSADM";
        //String password = "";
        try {
            //driver, database, usuario, pass
            conn = DriverManager.getConnection(driver, user, password);
            //declaración simple con SELECT
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIOS");
            System.out.println(conn.getCatalog());

            while (rs.next()) {
                System.out.println("Id: " + rs.getString(1) + " Usuario: " + rs.getString(2) + " Activo: " 
                    + rs.getString(3) + " Permisos: " + rs.getDate(4));
            }

           /* //con declaración preparada con update
            String strUpdate = "UPDATE USUARIO SET PERMISOS_ESPECIALES = 1 WHERE ACTIVO = ?";
            PreparedStatement p = conn.prepareStatement(strUpdate);
            System.out.printf("%nIntroduzca si estará activo o no (0/1): ");
            int activo = lector.nextInt();
            p.clearParameters();
            p.setInt(1, activo);
            p.executeUpdate();
            
            System.out.println("¿Desea borrar? 0/1: ");
            //probando otra declaración
            if(lector.nextInt() == 1){
                 p.executeUpdate("DELETE FROM USUARIO WHERE ACTIVO = 0");
            }*/
            
            conn.commit();
            rs.close();
            stmt.close();
            conn.close();            
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
        }
    }
}

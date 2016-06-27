package Controller;
import Model.*;
import java.sql.*;
import javax.swing.*;
public class CEmpleadoTelefonos{
Connection con;
CallableStatement cstmt;
Statement st;
ResultSet rs;
String driver;
public CEmpleadoTelefonos() {
try{
Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";}
catch (Exception e){
    JOptionPane.showMessageDialog(null, e.getMessage());
}
 }
public ModelEmpleadoTelefonos getEmpleadoTelefonos(int codEmpleado) {
ModelEmpleadoTelefonos m = new ModelEmpleadoTelefonos();try
{
   rs = st.executeQuery("select * from EmpleadoTelefonos where codEmpleado=" + codEmpleado);
    rs.next();m.codEmpleado= rs.getint("codEmpleado");m.telefono= rs.getString("telefono");m.fechaCreacion= rs.getDate("fechaCreacion");m.fechaActualizacion= rs.getDate("fechaActualizacion");m.usuarioCreador= rs.getString("usuarioCreador");m.usuarioActualizador= rs.getString("usuarioActualizador");} 
catch (Exception e){    JOptionPane.showMessageDialog(null, e.getMessage());}return m; }
public void insertEmpleadoTelefonos(ModelEmpleadoTelefonos m){
try {
cstmt = con.prepareCall("{call SP_EMPLEADOTELEFONOS_INSERT}");
cstmt.setint(1, m.codEmpleado);
cstmt.setString(2, m.telefono);
cstmt.setDate(3, m.fechaCreacion);
cstmt.setDate(4, m.fechaActualizacion);
cstmt.setString(5, m.usuarioCreador);
cstmt.setString(6, m.usuarioActualizador);
cstmt.executeUpdate();
 con.commit();
}
 catch (Exception e) {
JOptionPane.showMessageDialog(null, e.getMessage());
}
}
public void updateEmpleadoTelefonos(ModelEmpleadoTelefonos m){
try {
cstmt = con.prepareCall("{call SP_EMPLEADOTELEFONOS_UPDATE}");
cstmt.setint(1, m.codEmpleado);
cstmt.setString(2, m.telefono);
cstmt.setDate(3, m.fechaCreacion);
cstmt.setDate(4, m.fechaActualizacion);
cstmt.setString(5, m.usuarioCreador);
cstmt.setString(6, m.usuarioActualizador);
cstmt.executeUpdate();
 con.commit();
}
 catch (Exception e) {
JOptionPane.showMessageDialog(null, e.getMessage());
}
}
public void deleteEmpleadoTelefonos(ModelEmpleadoTelefonos m){
try {
cstmt = con.prepareCall("{call SP_EMPLEADOTELEFONOS_DELETE}");
cstmt.setint(1, m.codEmpleado);
cstmt.executeUpdate();
 con.commit();
}
 catch (Exception e) {
JOptionPane.showMessageDialog(null, e.getMessage());
}
}
 public DefaultListModel obtenerDatos ()
{
DefaultListModel l = new DefaultListModel();
try
{
   ResultSet rs = st.executeQuery("select * from EmpleadoTelefonos");
           while (rs.next())
  {
l.addElement(rs.getint(1));l.addElement(rs.getString(2));l.addElement(rs.getDate(3));l.addElement(rs.getDate(4));l.addElement(rs.getString(5));l.addElement(rs.getString(6));}
 }
 catch (Exception e)
{
   JOptionPane.showMessageDialog(null, e.getMessage());
}
return l;
}
}
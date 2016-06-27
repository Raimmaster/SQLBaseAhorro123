package Controller;
import Model.*;
import java.sql.*;
import javax.swing.*;
public class CEmpleadoRoles{
Connection con;
CallableStatement cstmt;
Statement st;
ResultSet rs;
String driver;
public CEmpleadoRoles() {
try{
Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";}
catch (Exception e){
    JOptionPane.showMessageDialog(null, e.getMessage());
}
 }
public ModelEmpleadoRoles getEmpleadoRoles(int codEmpleado) {
ModelEmpleadoRoles m = new ModelEmpleadoRoles();try
{
   rs = st.executeQuery("select * from EmpleadoRoles where codEmpleado=" + codEmpleado);
    rs.next();m.codEmpleado= rs.getint("codEmpleado");m.idRol= rs.getint("idRol");m.fechaCreacion= rs.getDate("fechaCreacion");m.fechaActualizacion= rs.getDate("fechaActualizacion");m.usuarioCreador= rs.getString("usuarioCreador");m.usuarioActualizador= rs.getString("usuarioActualizador");} 
catch (Exception e){    JOptionPane.showMessageDialog(null, e.getMessage());}return m; }
public void insertEmpleadoRoles(ModelEmpleadoRoles m){
try {
cstmt = con.prepareCall("{call SP_EMPLEADOROLES_INSERT}");
cstmt.setint(1, m.codEmpleado);
cstmt.setint(2, m.idRol);
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
public void updateEmpleadoRoles(ModelEmpleadoRoles m){
try {
cstmt = con.prepareCall("{call SP_EMPLEADOROLES_UPDATE}");
cstmt.setint(1, m.codEmpleado);
cstmt.setint(2, m.idRol);
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
public void deleteEmpleadoRoles(ModelEmpleadoRoles m){
try {
cstmt = con.prepareCall("{call SP_EMPLEADOROLES_DELETE}");
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
   ResultSet rs = st.executeQuery("select * from EmpleadoRoles");
           while (rs.next())
  {
l.addElement(rs.getint(1));l.addElement(rs.getint(2));l.addElement(rs.getDate(3));l.addElement(rs.getDate(4));l.addElement(rs.getString(5));l.addElement(rs.getString(6));}
 }
 catch (Exception e)
{
   JOptionPane.showMessageDialog(null, e.getMessage());
}
return l;
}
}
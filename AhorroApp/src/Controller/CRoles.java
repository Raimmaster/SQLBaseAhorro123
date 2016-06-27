package Controller;
import Model.*;
import java.sql.*;
import javax.swing.*;
public class CRoles{
Connection con;
CallableStatement cstmt;
Statement st;
ResultSet rs;
String driver;
public CRoles() {
try{
Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";}
catch (Exception e){
    JOptionPane.showMessageDialog(null, e.getMessage());
}
 }
public ModelRoles getRoles(int idRol) {
ModelRoles m = new ModelRoles();try
{
   rs = st.executeQuery("select * from Roles where idRol=" + idRol);
    rs.next();m.idRol= rs.getint("idRol");m.nombreRol= rs.getString("nombreRol");m.fechaCreacion= rs.getString("fechaCreacion");m.fechaActualizacion= rs.getDate("fechaActualizacion");m.usuarioCreador= rs.getString("usuarioCreador");m.usuarioActualizador= rs.getString("usuarioActualizador");} 
catch (Exception e){    JOptionPane.showMessageDialog(null, e.getMessage());}return m; }
public void insertRoles(ModelRoles m){
try {
cstmt = con.prepareCall("{call SP_ROLES_INSERT}");
cstmt.setint(1, m.idRol);
cstmt.setString(2, m.nombreRol);
cstmt.setString(3, m.fechaCreacion);
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
public void updateRoles(ModelRoles m){
try {
cstmt = con.prepareCall("{call SP_ROLES_UPDATE}");
cstmt.setint(1, m.idRol);
cstmt.setString(2, m.nombreRol);
cstmt.setString(3, m.fechaCreacion);
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
public void deleteRoles(ModelRoles m){
try {
cstmt = con.prepareCall("{call SP_ROLES_DELETE}");
cstmt.setint(1, m.idRol);
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
   ResultSet rs = st.executeQuery("select * from Roles");
           while (rs.next())
  {
l.addElement(rs.getint(1));l.addElement(rs.getString(2));l.addElement(rs.getString(3));l.addElement(rs.getDate(4));l.addElement(rs.getString(5));l.addElement(rs.getString(6));}
 }
 catch (Exception e)
{
   JOptionPane.showMessageDialog(null, e.getMessage());
}
return l;
}
}
package Controller;
import Model.*;
import java.sql.*;
import javax.swing.*;
public class CPrivilegios{
Connection con;
CallableStatement cstmt;
Statement st;
ResultSet rs;
String driver;
public CPrivilegios() {
try{
Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";}
catch (Exception e){
    JOptionPane.showMessageDialog(null, e.getMessage());
}
 }
public ModelPrivilegios getPrivilegios(int idPrivilegio) {
ModelPrivilegios m = new ModelPrivilegios();try
{
   rs = st.executeQuery("select * from Privilegios where idPrivilegio=" + idPrivilegio);
    rs.next();m.idPrivilegio= rs.getint("idPrivilegio");m.nombrePrivilegio= rs.getString("nombrePrivilegio");m.fechaCreacion= rs.getDate("fechaCreacion");m.fechaActualizacion= rs.getDate("fechaActualizacion");m.usuarioCreador= rs.getString("usuarioCreador");m.usuarioActualizador= rs.getString("usuarioActualizador");} 
catch (Exception e){    JOptionPane.showMessageDialog(null, e.getMessage());}return m; }
public void insertPrivilegios(ModelPrivilegios m){
try {
cstmt = con.prepareCall("{call SP_PRIVILEGIOS_INSERT}");
cstmt.setint(1, m.idPrivilegio);
cstmt.setString(2, m.nombrePrivilegio);
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
public void updatePrivilegios(ModelPrivilegios m){
try {
cstmt = con.prepareCall("{call SP_PRIVILEGIOS_UPDATE}");
cstmt.setint(1, m.idPrivilegio);
cstmt.setString(2, m.nombrePrivilegio);
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
public void deletePrivilegios(ModelPrivilegios m){
try {
cstmt = con.prepareCall("{call SP_PRIVILEGIOS_DELETE}");
cstmt.setint(1, m.idPrivilegio);
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
   ResultSet rs = st.executeQuery("select * from Privilegios");
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
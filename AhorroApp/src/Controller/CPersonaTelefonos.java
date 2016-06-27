package Controller;
import Model.*;
import java.sql.*;
import javax.swing.*;
public class CPersonaTelefonos{
Connection con;
CallableStatement cstmt;
Statement st;
ResultSet rs;
String driver;
public CPersonaTelefonos() {
try{
Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";}
catch (Exception e){
    JOptionPane.showMessageDialog(null, e.getMessage());
}
 }
public ModelPersonaTelefonos getPersonaTelefonos(int codPersona) {
ModelPersonaTelefonos m = new ModelPersonaTelefonos();try
{
   rs = st.executeQuery("select * from PersonaTelefonos where codPersona=" + codPersona);
    rs.next();m.codPersona= rs.getint("codPersona");m.telefono= rs.getString("telefono");m.fechaCreacion= rs.getDate("fechaCreacion");m.fechaActualizacion= rs.getDate("fechaActualizacion");m.usuarioCreador= rs.getString("usuarioCreador");m.usuarioActualizador= rs.getString("usuarioActualizador");} 
catch (Exception e){    JOptionPane.showMessageDialog(null, e.getMessage());}return m; }
public void insertPersonaTelefonos(ModelPersonaTelefonos m){
try {
cstmt = con.prepareCall("{call SP_PERSONATELEFONOS_INSERT}");
cstmt.setint(1, m.codPersona);
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
public void updatePersonaTelefonos(ModelPersonaTelefonos m){
try {
cstmt = con.prepareCall("{call SP_PERSONATELEFONOS_UPDATE}");
cstmt.setint(1, m.codPersona);
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
public void deletePersonaTelefonos(ModelPersonaTelefonos m){
try {
cstmt = con.prepareCall("{call SP_PERSONATELEFONOS_DELETE}");
cstmt.setint(1, m.codPersona);
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
   ResultSet rs = st.executeQuery("select * from PersonaTelefonos");
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
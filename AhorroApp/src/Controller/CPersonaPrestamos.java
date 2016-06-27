package Controller;
import Model.*;
import java.sql.*;
import javax.swing.*;
public class CPersonaPrestamos{
Connection con;
CallableStatement cstmt;
Statement st;
ResultSet rs;
String driver;
public CPersonaPrestamos() {
try{
Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";}
catch (Exception e){
    JOptionPane.showMessageDialog(null, e.getMessage());
}
 }
public ModelPersonaPrestamos getPersonaPrestamos(int numPrestamo) {
ModelPersonaPrestamos m = new ModelPersonaPrestamos();try
{
   rs = st.executeQuery("select * from PersonaPrestamos where numPrestamo=" + numPrestamo);
    rs.next();m.numPrestamo= rs.getint("numPrestamo");m.codEmpleado= rs.getint("codEmpleado");m.codPersona= rs.getint("codPersona");m.parentesco= rs.getString("parentesco");m.fechaCreacion= rs.getDate("fechaCreacion");m.fechaActualizacion= rs.getDate("fechaActualizacion");m.usuarioCreador= rs.getString("usuarioCreador");m.usuarioActualizador= rs.getString("usuarioActualizador");} 
catch (Exception e){    JOptionPane.showMessageDialog(null, e.getMessage());}return m; }
public void insertPersonaPrestamos(ModelPersonaPrestamos m){
try {
cstmt = con.prepareCall("{call SP_PERSONAPRESTAMOS_INSERT}");
cstmt.setint(1, m.numPrestamo);
cstmt.setint(2, m.codEmpleado);
cstmt.setint(3, m.codPersona);
cstmt.setString(4, m.parentesco);
cstmt.setDate(5, m.fechaCreacion);
cstmt.setDate(6, m.fechaActualizacion);
cstmt.setString(7, m.usuarioCreador);
cstmt.setString(8, m.usuarioActualizador);
cstmt.executeUpdate();
 con.commit();
}
 catch (Exception e) {
JOptionPane.showMessageDialog(null, e.getMessage());
}
}
public void updatePersonaPrestamos(ModelPersonaPrestamos m){
try {
cstmt = con.prepareCall("{call SP_PERSONAPRESTAMOS_UPDATE}");
cstmt.setint(1, m.numPrestamo);
cstmt.setint(2, m.codEmpleado);
cstmt.setint(3, m.codPersona);
cstmt.setString(4, m.parentesco);
cstmt.setDate(5, m.fechaCreacion);
cstmt.setDate(6, m.fechaActualizacion);
cstmt.setString(7, m.usuarioCreador);
cstmt.setString(8, m.usuarioActualizador);
cstmt.executeUpdate();
 con.commit();
}
 catch (Exception e) {
JOptionPane.showMessageDialog(null, e.getMessage());
}
}
public void deletePersonaPrestamos(ModelPersonaPrestamos m){
try {
cstmt = con.prepareCall("{call SP_PERSONAPRESTAMOS_DELETE}");
cstmt.setint(1, m.numPrestamo);
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
   ResultSet rs = st.executeQuery("select * from PersonaPrestamos");
           while (rs.next())
  {
l.addElement(rs.getint(1));l.addElement(rs.getint(2));l.addElement(rs.getint(3));l.addElement(rs.getString(4));l.addElement(rs.getDate(5));l.addElement(rs.getDate(6));l.addElement(rs.getString(7));l.addElement(rs.getString(8));}
 }
 catch (Exception e)
{
   JOptionPane.showMessageDialog(null, e.getMessage());
}
return l;
}
}
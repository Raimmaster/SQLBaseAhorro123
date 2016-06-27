package Controller;
import Model.*;
import java.sql.*;
import javax.swing.*;
public class CPrestamos{
Connection con;
CallableStatement cstmt;
Statement st;
ResultSet rs;
String driver;
public CPrestamos() {
try{
Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";}
catch (Exception e){
    JOptionPane.showMessageDialog(null, e.getMessage());
}
 }
public ModelPrestamos getPrestamos(int numPrestamo) {
ModelPrestamos m = new ModelPrestamos();try
{
   rs = st.executeQuery("select * from Prestamos where numPrestamo=" + numPrestamo);
    rs.next();m.numPrestamo= rs.getint("numPrestamo");m.fechaPrestamo= rs.getDate("fechaPrestamo");m.montoPrestamo= rs.getdouble("montoPrestamo");m.periodos= rs.getint("periodos");m.saldo= rs.getdouble("saldo");m.fechaCreacion= rs.getDate("fechaCreacion");m.fechaActualizacion= rs.getDate("fechaActualizacion");m.usuarioCreador= rs.getString("usuarioCreador");m.usuarioActualizador= rs.getString("usuarioActualizador");} 
catch (Exception e){    JOptionPane.showMessageDialog(null, e.getMessage());}return m; }
public void insertPrestamos(ModelPrestamos m){
try {
cstmt = con.prepareCall("{call SP_PRESTAMOS_INSERT}");
cstmt.setint(1, m.numPrestamo);
cstmt.setDate(2, m.fechaPrestamo);
cstmt.setdouble(3, m.montoPrestamo);
cstmt.setint(4, m.periodos);
cstmt.setdouble(5, m.saldo);
cstmt.setDate(6, m.fechaCreacion);
cstmt.setDate(7, m.fechaActualizacion);
cstmt.setString(8, m.usuarioCreador);
cstmt.setString(9, m.usuarioActualizador);
cstmt.executeUpdate();
 con.commit();
}
 catch (Exception e) {
JOptionPane.showMessageDialog(null, e.getMessage());
}
}
public void updatePrestamos(ModelPrestamos m){
try {
cstmt = con.prepareCall("{call SP_PRESTAMOS_UPDATE}");
cstmt.setint(1, m.numPrestamo);
cstmt.setDate(2, m.fechaPrestamo);
cstmt.setdouble(3, m.montoPrestamo);
cstmt.setint(4, m.periodos);
cstmt.setdouble(5, m.saldo);
cstmt.setDate(6, m.fechaCreacion);
cstmt.setDate(7, m.fechaActualizacion);
cstmt.setString(8, m.usuarioCreador);
cstmt.setString(9, m.usuarioActualizador);
cstmt.executeUpdate();
 con.commit();
}
 catch (Exception e) {
JOptionPane.showMessageDialog(null, e.getMessage());
}
}
public void deletePrestamos(ModelPrestamos m){
try {
cstmt = con.prepareCall("{call SP_PRESTAMOS_DELETE}");
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
   ResultSet rs = st.executeQuery("select * from Prestamos");
           while (rs.next())
  {
l.addElement(rs.getint(1));l.addElement(rs.getDate(2));l.addElement(rs.getdouble(3));l.addElement(rs.getint(4));l.addElement(rs.getdouble(5));l.addElement(rs.getDate(6));l.addElement(rs.getDate(7));l.addElement(rs.getString(8));l.addElement(rs.getString(9));}
 }
 catch (Exception e)
{
   JOptionPane.showMessageDialog(null, e.getMessage());
}
return l;
}
}
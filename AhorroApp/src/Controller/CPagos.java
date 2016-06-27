package Controller;
import Model.*;
import java.sql.*;
import javax.swing.*;
public class CPagos{
Connection con;
CallableStatement cstmt;
Statement st;
ResultSet rs;
String driver;
public CPagos() {
try{
Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";}
catch (Exception e){
    JOptionPane.showMessageDialog(null, e.getMessage());
}
 }
public ModelPagos getPagos(int numPrestamo) {
ModelPagos m = new ModelPagos();try
{
   rs = st.executeQuery("select * from Pagos where numPrestamo=" + numPrestamo);
    rs.next();m.numPrestamo= rs.getint("numPrestamo");m.numeroPago= rs.getint("numeroPago");m.fechaPago= rs.getDate("fechaPago");m.montoPago= rs.getdouble("montoPago");m.fechaCreacion= rs.getDate("fechaCreacion");m.fechaActualizacion= rs.getDate("fechaActualizacion");m.usuarioCreador= rs.getString("usuarioCreador");m.usuarioActualizador= rs.getString("usuarioActualizador");} 
catch (Exception e){    JOptionPane.showMessageDialog(null, e.getMessage());}return m; }
public void insertPagos(ModelPagos m){
try {
cstmt = con.prepareCall("{call SP_PAGOS_INSERT}");
cstmt.setint(1, m.numPrestamo);
cstmt.setint(2, m.numeroPago);
cstmt.setDate(3, m.fechaPago);
cstmt.setdouble(4, m.montoPago);
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
public void updatePagos(ModelPagos m){
try {
cstmt = con.prepareCall("{call SP_PAGOS_UPDATE}");
cstmt.setint(1, m.numPrestamo);
cstmt.setint(2, m.numeroPago);
cstmt.setDate(3, m.fechaPago);
cstmt.setdouble(4, m.montoPago);
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
public void deletePagos(ModelPagos m){
try {
cstmt = con.prepareCall("{call SP_PAGOS_DELETE}");
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
   ResultSet rs = st.executeQuery("select * from Pagos");
           while (rs.next())
  {
l.addElement(rs.getint(1));l.addElement(rs.getint(2));l.addElement(rs.getDate(3));l.addElement(rs.getdouble(4));l.addElement(rs.getDate(5));l.addElement(rs.getDate(6));l.addElement(rs.getString(7));l.addElement(rs.getString(8));}
 }
 catch (Exception e)
{
   JOptionPane.showMessageDialog(null, e.getMessage());
}
return l;
}
}
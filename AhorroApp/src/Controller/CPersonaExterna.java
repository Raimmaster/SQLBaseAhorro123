package Controller;
import Model.*;
import java.sql.*;
import javax.swing.*;
public class CPersonaExterna{
Connection con;
CallableStatement cstmt;
Statement st;
ResultSet rs;
String driver;
public CPersonaExterna() {
try{
Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";}
catch (Exception e){
    JOptionPane.showMessageDialog(null, e.getMessage());
}
 }
public ModelPersonaExterna getPersonaExterna(int codPersona) {
ModelPersonaExterna m = new ModelPersonaExterna();try
{
   rs = st.executeQuery("select * from PersonaExterna where codPersona=" + codPersona);
    rs.next();m.codPersona= rs.getint("codPersona");m.primerNombre= rs.getString("primerNombre");m.segundoNombre= rs.getString("segundoNombre");m.primerApellido= rs.getString("primerApellido");m.segundoApellido= rs.getString("segundoApellido");m.dirCalle= rs.getString("dirCalle");m.dirAvenida= rs.getString("dirAvenida");m.dirNumCasa= rs.getint("dirNumCasa");m.dirCiudad= rs.getString("dirCiudad");m.dirDepto= rs.getString("dirDepto");m.dirReferencia= rs.getString("dirReferencia");m.emailPrimario= rs.getString("emailPrimario");m.emailSecundario= rs.getString("emailSecundario");m.fechaNacimiento= rs.getDate("fechaNacimiento");m.fechaCreacion= rs.getDate("fechaCreacion");m.fechaActualizacion= rs.getDate("fechaActualizacion");m.usuarioCreador= rs.getString("usuarioCreador");m.usuarioActualizador= rs.getString("usuarioActualizador");} 
catch (Exception e){    JOptionPane.showMessageDialog(null, e.getMessage());}return m; }
public void insertPersonaExterna(ModelPersonaExterna m){
try {
cstmt = con.prepareCall("{call SP_PERSONAEXTERNA_INSERT}");
cstmt.setint(1, m.codPersona);
cstmt.setString(2, m.primerNombre);
cstmt.setString(3, m.segundoNombre);
cstmt.setString(4, m.primerApellido);
cstmt.setString(5, m.segundoApellido);
cstmt.setString(6, m.dirCalle);
cstmt.setString(7, m.dirAvenida);
cstmt.setint(8, m.dirNumCasa);
cstmt.setString(9, m.dirCiudad);
cstmt.setString(10, m.dirDepto);
cstmt.setString(11, m.dirReferencia);
cstmt.setString(12, m.emailPrimario);
cstmt.setString(13, m.emailSecundario);
cstmt.setDate(14, m.fechaNacimiento);
cstmt.setDate(15, m.fechaCreacion);
cstmt.setDate(16, m.fechaActualizacion);
cstmt.setString(17, m.usuarioCreador);
cstmt.setString(18, m.usuarioActualizador);
cstmt.executeUpdate();
 con.commit();
}
 catch (Exception e) {
JOptionPane.showMessageDialog(null, e.getMessage());
}
}
public void updatePersonaExterna(ModelPersonaExterna m){
try {
cstmt = con.prepareCall("{call SP_PERSONAEXTERNA_UPDATE}");
cstmt.setint(1, m.codPersona);
cstmt.setString(2, m.primerNombre);
cstmt.setString(3, m.segundoNombre);
cstmt.setString(4, m.primerApellido);
cstmt.setString(5, m.segundoApellido);
cstmt.setString(6, m.dirCalle);
cstmt.setString(7, m.dirAvenida);
cstmt.setint(8, m.dirNumCasa);
cstmt.setString(9, m.dirCiudad);
cstmt.setString(10, m.dirDepto);
cstmt.setString(11, m.dirReferencia);
cstmt.setString(12, m.emailPrimario);
cstmt.setString(13, m.emailSecundario);
cstmt.setDate(14, m.fechaNacimiento);
cstmt.setDate(15, m.fechaCreacion);
cstmt.setDate(16, m.fechaActualizacion);
cstmt.setString(17, m.usuarioCreador);
cstmt.setString(18, m.usuarioActualizador);
cstmt.executeUpdate();
 con.commit();
}
 catch (Exception e) {
JOptionPane.showMessageDialog(null, e.getMessage());
}
}
public void deletePersonaExterna(ModelPersonaExterna m){
try {
cstmt = con.prepareCall("{call SP_PERSONAEXTERNA_DELETE}");
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
   ResultSet rs = st.executeQuery("select * from PersonaExterna");
           while (rs.next())
  {
l.addElement(rs.getint(1));l.addElement(rs.getString(2));l.addElement(rs.getString(3));l.addElement(rs.getString(4));l.addElement(rs.getString(5));l.addElement(rs.getString(6));l.addElement(rs.getString(7));l.addElement(rs.getint(8));l.addElement(rs.getString(9));l.addElement(rs.getString(10));l.addElement(rs.getString(11));l.addElement(rs.getString(12));l.addElement(rs.getString(13));l.addElement(rs.getDate(14));l.addElement(rs.getDate(15));l.addElement(rs.getDate(16));l.addElement(rs.getString(17));l.addElement(rs.getString(18));}
 }
 catch (Exception e)
{
   JOptionPane.showMessageDialog(null, e.getMessage());
}
return l;
}
}
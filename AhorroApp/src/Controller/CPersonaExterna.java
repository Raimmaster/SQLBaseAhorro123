package Controller;

import Model.*;
import java.sql.*;
import javax.swing.*;

public class CPersonaExterna {

    Connection con;
    CallableStatement cstmt;
    Statement st;
    ResultSet rs;
    String driver;

    public CPersonaExterna() {
        try {
            Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");
            this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ModelPersonaExterna getPersonaExterna(int codPersona) {
        ModelPersonaExterna m = new ModelPersonaExterna();
        try {
            rs = st.executeQuery("select * from PersonaExterna where CODIGO_PERSONA=" + codPersona);
            rs.next();
            m.codPersona = rs.getInt(1);
            m.primerNombre = rs.getString(2);
            m.segundoNombre = rs.getString(3);
            m.primerApellido = rs.getString(4);
            m.segundoApellido = rs.getString(5);
            m.dirCalle = rs.getString(6);
            m.dirAvenida = rs.getString(7);
            m.dirNumCasa = rs.getInt(8);
            m.dirCiudad = rs.getString(9);
            m.dirDepto = rs.getString(10);
            m.dirReferencia = rs.getString(11);
            m.emailPrimario = rs.getString(12);
            m.emailSecundario = rs.getString(13);
            m.fechaNacimiento = rs.getDate(14);
            m.fechaCreacion = rs.getDate(15);
            m.fechaActualizacion = rs.getDate(16);
            m.usuarioCreador = rs.getString(17);
            m.usuarioActualizador = rs.getString(18);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return m;
    }

    public void insertPersonaExterna(ModelPersonaExterna m) {
        try {
            cstmt = con.prepareCall("{call SP_PERSONAEXTERNA_INSERT}");
            cstmt.setInt(1, m.codPersona);
            cstmt.setString(2, m.primerNombre);
            cstmt.setString(3, m.segundoNombre);
            cstmt.setString(4, m.primerApellido);
            cstmt.setString(5, m.segundoApellido);
            cstmt.setString(6, m.dirCalle);
            cstmt.setString(7, m.dirAvenida);
            cstmt.setInt(8, m.dirNumCasa);
            cstmt.setString(9, m.dirCiudad);
            cstmt.setString(10, m.dirDepto);
            cstmt.setString(11, m.dirReferencia);
            cstmt.setString(12, m.emailPrimario);
            cstmt.setString(13, m.emailSecundario);
            cstmt.setDate(14, (Date) m.fechaNacimiento);
            cstmt.setDate(15, (Date) m.fechaCreacion);
            cstmt.setDate(16, (Date) m.fechaActualizacion);
            cstmt.setString(17, m.usuarioCreador);
            cstmt.setString(18, m.usuarioActualizador);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updatePersonaExterna(ModelPersonaExterna m) {
        try {
            cstmt = con.prepareCall("{call SP_PERSONAEXTERNA_UPDATE}");
            cstmt.setInt(1, m.codPersona);
            cstmt.setString(2, m.primerNombre);
            cstmt.setString(3, m.segundoNombre);
            cstmt.setString(4, m.primerApellido);
            cstmt.setString(5, m.segundoApellido);
            cstmt.setString(6, m.dirCalle);
            cstmt.setString(7, m.dirAvenida);
            cstmt.setInt(8, m.dirNumCasa);
            cstmt.setString(9, m.dirCiudad);
            cstmt.setString(10, m.dirDepto);
            cstmt.setString(11, m.dirReferencia);
            cstmt.setString(12, m.emailPrimario);
            cstmt.setString(13, m.emailSecundario);
            cstmt.setDate(14, (Date) m.fechaNacimiento);
            cstmt.setDate(15, (Date) m.fechaCreacion);
            cstmt.setDate(16, (Date) m.fechaActualizacion);
            cstmt.setString(17, m.usuarioCreador);
            cstmt.setString(18, m.usuarioActualizador);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deletePersonaExterna(ModelPersonaExterna m) {
        try {
            cstmt = con.prepareCall("{call SP_PERSONAEXTERNA_DELETE}");
            cstmt.setInt(1, m.codPersona);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public DefaultListModel obtenerDatos() {
        DefaultListModel l = new DefaultListModel();
        try {
            ResultSet rs = st.executeQuery("select * from PersonaExterna");
            while (rs.next()) {
                l.addElement(rs.getInt(1));
                l.addElement(rs.getString(2));
                l.addElement(rs.getString(3));
                l.addElement(rs.getString(4));
                l.addElement(rs.getString(5));
                l.addElement(rs.getString(6));
                l.addElement(rs.getString(7));
                l.addElement(rs.getInt(8));
                l.addElement(rs.getString(9));
                l.addElement(rs.getString(10));
                l.addElement(rs.getString(11));
                l.addElement(rs.getString(12));
                l.addElement(rs.getString(13));
                l.addElement(rs.getDate(14));
                l.addElement(rs.getDate(15));
                l.addElement(rs.getDate(16));
                l.addElement(rs.getString(17));
                l.addElement(rs.getString(18));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return l;
    }
}

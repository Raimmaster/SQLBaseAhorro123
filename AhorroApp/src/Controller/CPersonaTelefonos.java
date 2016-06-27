package Controller;

import Model.*;
import java.sql.*;
import javax.swing.*;

public class CPersonaTelefonos {

    Connection con;
    CallableStatement cstmt;
    Statement st;
    ResultSet rs;
    String driver;

    public CPersonaTelefonos() {
        try {
            Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");
            this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ModelPersonaTelefonos getPersonaTelefonos(int codPersona, String telefono) {
        ModelPersonaTelefonos m = new ModelPersonaTelefonos();
        try {
            rs = st.executeQuery("select * from PersonaTelefonos where CODIGO_PERSONA=" + codPersona + " AND TELEFONO=" + telefono);
            rs.next();
            m.codPersona = rs.getInt(1);
            m.telefono = rs.getString(2);
            m.fechaCreacion = rs.getDate(3);
            m.fechaActualizacion = rs.getDate(4);
            m.usuarioCreador = rs.getString(5);
            m.usuarioActualizador = rs.getString(6);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return m;
    }

    public void insertPersonaTelefonos(ModelPersonaTelefonos m) {
        try {
            cstmt = con.prepareCall("{call SP_PERSONATELEFONOS_INSERT}");
            cstmt.setInt(1, m.codPersona);
            cstmt.setString(2, m.telefono);
            cstmt.setDate(3, (Date) m.fechaCreacion);
            cstmt.setDate(4, (Date) m.fechaActualizacion);
            cstmt.setString(5, m.usuarioCreador);
            cstmt.setString(6, m.usuarioActualizador);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updatePersonaTelefonos(ModelPersonaTelefonos m) {
        try {
            cstmt = con.prepareCall("{call SP_PERSONATELEFONOS_UPDATE}");
            cstmt.setInt(1, m.codPersona);
            cstmt.setString(2, m.telefono);
            cstmt.setDate(3, (Date) m.fechaCreacion);
            cstmt.setDate(4, (Date) m.fechaActualizacion);
            cstmt.setString(5, m.usuarioCreador);
            cstmt.setString(6, m.usuarioActualizador);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deletePersonaTelefonos(ModelPersonaTelefonos m) {
        try {
            cstmt = con.prepareCall("{call SP_PERSONATELEFONOS_DELETE}");
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
            ResultSet rs = st.executeQuery("select * from PersonaTelefonos");
            while (rs.next()) {
                l.addElement(rs.getInt(1));
                l.addElement(rs.getString(2));
                l.addElement(rs.getDate(3));
                l.addElement(rs.getDate(4));
                l.addElement(rs.getString(5));
                l.addElement(rs.getString(6));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return l;
    }
}

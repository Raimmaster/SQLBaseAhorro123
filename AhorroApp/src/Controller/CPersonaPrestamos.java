package Controller;

import Model.*;
import java.sql.*;
import javax.swing.*;

public class CPersonaPrestamos {

    Connection con;
    CallableStatement cstmt;
    Statement st;
    ResultSet rs;
    String driver;

    public CPersonaPrestamos() {
        try {
            Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");
            this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ModelPersonaPrestamos getPersonaPrestamos(int numPrestamo) {
        ModelPersonaPrestamos m = new ModelPersonaPrestamos();
        try {
            rs = st.executeQuery("select * from PersonaPrestamos where NUMERO_PRESTAMO=" + numPrestamo);
            rs.next();
            m.numPrestamo = rs.getInt(1);
            m.codEmpleado = rs.getInt(2);
            m.codPersona = rs.getInt(3);
            m.parentesco = rs.getString(4);
            m.fechaCreacion = rs.getDate(5);
            m.fechaActualizacion = rs.getDate(6);
            m.usuarioCreador = rs.getString(7);
            m.usuarioActualizador = rs.getString(8);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return m;
    }

    public void insertPersonaPrestamos(ModelPersonaPrestamos m) {
        try {
            cstmt = con.prepareCall("{call SP_PERSONAPRESTAMOS_INSERT}");
            cstmt.setInt(1, m.numPrestamo);
            cstmt.setInt(2, m.codEmpleado);
            cstmt.setInt(3, m.codPersona);
            cstmt.setString(4, m.parentesco);
            cstmt.setDate(5, (Date) m.fechaCreacion);
            cstmt.setDate(6, (Date) m.fechaActualizacion);
            cstmt.setString(7, m.usuarioCreador);
            cstmt.setString(8, m.usuarioActualizador);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updatePersonaPrestamos(ModelPersonaPrestamos m) {
        try {
            cstmt = con.prepareCall("{call SP_PERSONAPRESTAMOS_UPDATE}");
            cstmt.setInt(1, m.numPrestamo);
            cstmt.setInt(2, m.codEmpleado);
            cstmt.setInt(3, m.codPersona);
            cstmt.setString(4, m.parentesco);
            cstmt.setDate(5, (Date) m.fechaCreacion);
            cstmt.setDate(6, (Date) m.fechaActualizacion);
            cstmt.setString(7, m.usuarioCreador);
            cstmt.setString(8, m.usuarioActualizador);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deletePersonaPrestamos(ModelPersonaPrestamos m) {
        try {
            cstmt = con.prepareCall("{call SP_PERSONAPRESTAMOS_DELETE}");
            cstmt.setInt(1, m.numPrestamo);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public DefaultListModel obtenerDatos() {
        DefaultListModel l = new DefaultListModel();
        try {
            ResultSet rs = st.executeQuery("select * from PersonaPrestamos");
            while (rs.next()) {
                l.addElement(rs.getInt(1));
                l.addElement(rs.getInt(2));
                l.addElement(rs.getInt(3));
                l.addElement(rs.getString(4));
                l.addElement(rs.getDate(5));
                l.addElement(rs.getDate(6));
                l.addElement(rs.getString(7));
                l.addElement(rs.getString(8));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return l;
    }
}

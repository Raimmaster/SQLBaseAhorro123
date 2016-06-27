package Controller;

import Model.*;
import java.sql.*;
import javax.swing.*;

public class CPrestamos {

    Connection con;
    CallableStatement cstmt;
    Statement st;
    ResultSet rs;
    String driver;

    public CPrestamos() {
        try {
            Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");
            this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ModelPrestamos getPrestamos(int numPrestamo) {
        ModelPrestamos m = new ModelPrestamos();
        try {
            rs = st.executeQuery("select * from Prestamos where NUMERO_PRESTAMO=" + numPrestamo);
            rs.next();
            m.numPrestamo = rs.getInt(1);
            m.fechaPrestamo = rs.getDate(2);
            m.montoPrestamo = rs.getDouble(3);
            m.periodos = rs.getInt(4);
            m.saldo = rs.getDouble(5);
            m.fechaCreacion = rs.getDate(6);
            m.fechaActualizacion = rs.getDate(7);
            m.usuarioCreador = rs.getString(8);
            m.usuarioActualizador = rs.getString(9);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return m;
    }

    public void insertPrestamos(ModelPrestamos m) {
        try {
            cstmt = con.prepareCall("{call SP_PRESTAMOS_INSERT}");
            cstmt.setInt(1, m.numPrestamo);
            cstmt.setDate(2, (Date) m.fechaPrestamo);
            cstmt.setDouble(3, m.montoPrestamo);
            cstmt.setInt(4, m.periodos);
            cstmt.setDouble(5, m.saldo);
            cstmt.setDate(6, (Date) m.fechaCreacion);
            cstmt.setDate(7, (Date) m.fechaActualizacion);
            cstmt.setString(8, m.usuarioCreador);
            cstmt.setString(9, m.usuarioActualizador);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updatePrestamos(ModelPrestamos m) {
        try {
            cstmt = con.prepareCall("{call SP_PRESTAMOS_UPDATE}");
            cstmt.setInt(1, m.numPrestamo);
            cstmt.setDate(2, (Date) m.fechaPrestamo);
            cstmt.setDouble(3, m.montoPrestamo);
            cstmt.setInt(4, m.periodos);
            cstmt.setDouble(5, m.saldo);
            cstmt.setDate(6, (Date) m.fechaCreacion);
            cstmt.setDate(7, (Date) m.fechaActualizacion);
            cstmt.setString(8, m.usuarioCreador);
            cstmt.setString(9, m.usuarioActualizador);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deletePrestamos(ModelPrestamos m) {
        try {
            cstmt = con.prepareCall("{call SP_PRESTAMOS_DELETE}");
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
            ResultSet rs = st.executeQuery("select * from Prestamos");
            while (rs.next()) {
                l.addElement(rs.getInt(1));
                l.addElement(rs.getDate(2));
                l.addElement(rs.getDouble(3));
                l.addElement(rs.getInt(4));
                l.addElement(rs.getDouble(5));
                l.addElement(rs.getDate(6));
                l.addElement(rs.getDate(7));
                l.addElement(rs.getString(8));
                l.addElement(rs.getString(9));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return l;
    }
}

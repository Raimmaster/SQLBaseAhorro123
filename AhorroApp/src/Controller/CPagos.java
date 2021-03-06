package Controller;

import Model.*;
import java.sql.*;
import javax.swing.*;

public class CPagos {

    Connection con;
    CallableStatement cstmt;
    Statement st;
    ResultSet rs;
    String driver;

    public CPagos() {
        try {
            Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");
            this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ModelPagos getPagos(int numPrestamo, int numPago) {
        ModelPagos m = new ModelPagos();
        try {
            rs = st.executeQuery("select * from Pagos where NUMERO_PRESTAMO=" + numPrestamo + " AND NUMERO_PAGO=" + numPago);
            rs.next();
            m.numPrestamo = rs.getInt(1);
            m.numeroPago = rs.getInt(2);
            m.fechaPago = rs.getDate(3);
            m.montoPago = rs.getDouble(4);
            m.fechaCreacion = rs.getDate(5);
            m.fechaActualizacion = rs.getDate(6);
            m.usuarioCreador = rs.getString(7);
            m.usuarioActualizador = rs.getString(8);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return m;
    }

    public void insertPagos(ModelPagos m) {
        try {
            cstmt = con.prepareCall("{call SP_PAGOS_INSERT}");
            cstmt.setInt(1, m.numPrestamo);
            cstmt.setInt(2, m.numeroPago);
            cstmt.setDate(3, (Date) m.fechaPago);
            cstmt.setDouble(4, m.montoPago);
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

    public void updatePagos(ModelPagos m) {
        try {
            cstmt = con.prepareCall("{call SP_PAGOS_UPDATE}");
            cstmt.setInt(1, m.numPrestamo);
            cstmt.setInt(2, m.numeroPago);
            cstmt.setDate(3, (Date) m.fechaPago);
            cstmt.setDouble(4, m.montoPago);
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

    public void deletePagos(ModelPagos m) {
        try {
            cstmt = con.prepareCall("{call SP_PAGOS_DELETE}");
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
            ResultSet rs = st.executeQuery("select * from Pagos");
            while (rs.next()) {
                l.addElement(rs.getInt(1));
                l.addElement(rs.getInt(2));
                l.addElement(rs.getDate(3));
                l.addElement(rs.getDouble(4));
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

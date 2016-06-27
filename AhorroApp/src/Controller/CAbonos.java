package Controller;

import Model.*;
import java.sql.*;
import javax.swing.*;

public class CAbonos {

    Connection con;
    CallableStatement cstmt;
    Statement st;
    ResultSet rs;
    String driver;

    public CAbonos() {
        try {
            Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");
            this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ModelAbonos getAbonos(String codigoAbono) {
        ModelAbonos m = new ModelAbonos();
        try {
            rs = st.executeQuery("select * from Abonos where codigoAbono=" + codigoAbono);
            rs.next();
            m.codigoAbono = rs.getString("codigoAbono");
            m.monto = rs.getDouble("monto");
            m.fecha = rs.getDate("fecha");
            m.comentario = rs.getString("comentario");
            m.numeroCuenta = rs.getInt("numeroCuenta");
            m.fechaCreacion = rs.getDate("fechaCreacion");
            m.fechaActualizacion = rs.getDate("fechaActualizacion");
            m.usuarioCreador = rs.getString("usuarioCreador");
            m.usuarioActualizador = rs.getString("usuarioActualizador");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return m;
    }

    public void insertAbonos(ModelAbonos m) {
        try {
            cstmt = con.prepareCall("{call SP_ABONOS_INSERT}");
            cstmt.setString(1, m.codigoAbono);
            cstmt.setDouble(2, m.monto);
            cstmt.setDate(3, (Date) m.fecha);
            cstmt.setString(4, m.comentario);
            cstmt.setInt(5, m.numeroCuenta);
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

    public void updateAbonos(ModelAbonos m) {
        try {
            cstmt = con.prepareCall("{call SP_ABONOS_UPDATE}");
            cstmt.setString(1, m.codigoAbono);
            cstmt.setDouble(2, m.monto);
            cstmt.setDate(3, (Date) m.fecha);
            cstmt.setString(4, m.comentario);
            cstmt.setInt(5, m.numeroCuenta);
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

    public void deleteAbonos(ModelAbonos m) {
        try {
            cstmt = con.prepareCall("{call SP_ABONOS_DELETE}");
            cstmt.setString(1, m.codigoAbono);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public DefaultListModel obtenerDatos() {
        DefaultListModel l = new DefaultListModel();
        try {
            ResultSet rs = st.executeQuery("select * from Abonos");
            while (rs.next()) {
                l.addElement(rs.getString(1));
                l.addElement(rs.getDouble(2));
                l.addElement(rs.getDate(3));
                l.addElement(rs.getString(4));
                l.addElement(rs.getInt(5));
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

package Controller;

import Model.*;
import java.sql.*;
import javax.swing.*;

public class CCuentas {

    Connection con;
    CallableStatement cstmt;
    Statement st;
    ResultSet rs;
    String driver;

    public CCuentas() {
        try {
            Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");
            this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ModelCuentas getCuentas(int numeroCuenta) {
        ModelCuentas m = new ModelCuentas();
        try {
            rs = st.executeQuery("select * from Cuentas where NUMERO_CUENTA=" + numeroCuenta);
            rs.next();
            m.numeroCuenta = rs.getInt(1);
            m.fechaApertura = rs.getDate(2);
            m.saldoCuenta = rs.getDouble(3);
            m.tipoCuenta = rs.getString(4);
            m.montoAnual = rs.getDouble(5);
            m.tipoAbono = rs.getString(6);
            m.fechaCreacion = rs.getDate(7);
            m.fechaActualizacion = rs.getDate(8);
            m.usuarioCreador = rs.getString(9);
            m.usuarioActualizador = rs.getString(10);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return m;
    }

    public void insertCuentas(ModelCuentas m) {
        try {
            cstmt = con.prepareCall("{call SP_CUENTAS_INSERT}");
            cstmt.setInt(1, m.numeroCuenta);
            cstmt.setDate(2, (Date) m.fechaApertura);
            cstmt.setDouble(3, m.saldoCuenta);
            cstmt.setString(4, m.tipoCuenta);
            cstmt.setDouble(5, m.montoAnual);
            cstmt.setString(6, m.tipoAbono);
            cstmt.setDate(7, (Date) m.fechaCreacion);
            cstmt.setDate(8, (Date) m.fechaActualizacion);
            cstmt.setString(9, m.usuarioCreador);
            cstmt.setString(10, m.usuarioActualizador);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updateCuentas(ModelCuentas m) {
        try {
            cstmt = con.prepareCall("{call SP_CUENTAS_UPDATE}");
            cstmt.setInt(1, m.numeroCuenta);
            cstmt.setDate(2, (Date) m.fechaApertura);
            cstmt.setDouble(3, m.saldoCuenta);
            cstmt.setString(4, m.tipoCuenta);
            cstmt.setDouble(5, m.montoAnual);
            cstmt.setString(6, m.tipoAbono);
            cstmt.setDate(7, (Date) m.fechaCreacion);
            cstmt.setDate(8, (Date) m.fechaActualizacion);
            cstmt.setString(9, m.usuarioCreador);
            cstmt.setString(10, m.usuarioActualizador);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deleteCuentas(ModelCuentas m) {
        try {
            cstmt = con.prepareCall("{call SP_CUENTAS_DELETE}");
            cstmt.setInt(1, m.numeroCuenta);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public DefaultListModel obtenerDatos() {
        DefaultListModel l = new DefaultListModel();
        try {
            ResultSet rs = st.executeQuery("select * from Cuentas");
            while (rs.next()) {
                l.addElement(rs.getInt(1));
                l.addElement(rs.getDate(2));
                l.addElement(rs.getDouble(3));
                l.addElement(rs.getString(4));
                l.addElement(rs.getDouble(5));
                l.addElement(rs.getString(6));
                l.addElement(rs.getDate(7));
                l.addElement(rs.getDate(8));
                l.addElement(rs.getString(9));
                l.addElement(rs.getString(10));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return l;
    }
}

package Controller;

import Model.*;
import java.sql.*;
import javax.swing.*;

public class CEmpleadosCuentas {

    Connection con;
    CallableStatement cstmt;
    Statement st;
    ResultSet rs;
    String driver;

    public CEmpleadosCuentas() {
        try {
            Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");
            this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ModelEmpleadosCuentas getEmpleadosCuentas(int codEmpleado, int codCuenta) {
        ModelEmpleadosCuentas m = new ModelEmpleadosCuentas();
        try {
            rs = st.executeQuery("select * from EmpleadosCuentas where CODIGO_EMPLEADO=" + codEmpleado + " AND NUMERO_CUENTA=" + codCuenta);
            rs.next();
            m.codEmpleado = rs.getInt(1);
            m.numeroCuenta = rs.getInt(2);
            m.fechaCreacion = rs.getDate(3);
            m.fechaActualizacion = rs.getDate(4);
            m.usuarioCreador = rs.getString(5);
            m.usuarioActualizador = rs.getString(6);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return m;
    }

    public void insertEmpleadosCuentas(ModelEmpleadosCuentas m) {
        try {
            cstmt = con.prepareCall("{call SP_EMPLEADOSCUENTAS_INSERT}");
            cstmt.setInt(1, m.codEmpleado);
            cstmt.setInt(2, m.numeroCuenta);
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

    public void updateEmpleadosCuentas(ModelEmpleadosCuentas m) {
        try {
            cstmt = con.prepareCall("{call SP_EMPLEADOSCUENTAS_UPDATE}");
            cstmt.setInt(1, m.codEmpleado);
            cstmt.setInt(2, m.numeroCuenta);
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

    public void deleteEmpleadosCuentas(ModelEmpleadosCuentas m) {
        try {
            cstmt = con.prepareCall("{call SP_EMPLEADOSCUENTAS_DELETE}");
            cstmt.setInt(1, m.codEmpleado);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public DefaultListModel obtenerDatos() {
        DefaultListModel l = new DefaultListModel();
        try {
            ResultSet rs = st.executeQuery("select * from EmpleadosCuentas");
            while (rs.next()) {
                l.addElement(rs.getInt(1));
                l.addElement(rs.getInt(2));
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

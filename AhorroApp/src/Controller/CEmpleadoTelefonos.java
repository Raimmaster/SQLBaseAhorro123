package Controller;

import Model.*;
import java.sql.*;
import javax.swing.*;

public class CEmpleadoTelefonos {

    Connection con;
    CallableStatement cstmt;
    Statement st;
    ResultSet rs;
    String driver;

    public CEmpleadoTelefonos() {
        try {
            Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");
            this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ModelEmpleadoTelefonos getEmpleadoTelefonos(int codEmpleado, String telefono) {
        ModelEmpleadoTelefonos m = new ModelEmpleadoTelefonos();
        try {
            rs = st.executeQuery("select * from EmpleadoTelefonos where codEmpleado=" + codEmpleado + " AND TELEFONO='" + telefono + "'");
            rs.next();
            m.codEmpleado = rs.getInt(1);
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

    public void insertEmpleadoTelefonos(ModelEmpleadoTelefonos m) {
        try {
            cstmt = con.prepareCall("{call SP_EMPLEADOTELEFONOS_INSERT}");
            cstmt.setInt(1, m.codEmpleado);
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

    public void updateEmpleadoTelefonos(ModelEmpleadoTelefonos m) {
        try {
            cstmt = con.prepareCall("{call SP_EMPLEADOTELEFONOS_UPDATE}");
            cstmt.setInt(1, m.codEmpleado);
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

    public void deleteEmpleadoTelefonos(ModelEmpleadoTelefonos m) {
        try {
            cstmt = con.prepareCall("{call SP_EMPLEADOTELEFONOS_DELETE}");
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
            ResultSet rs = st.executeQuery("select * from EmpleadoTelefonos");
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

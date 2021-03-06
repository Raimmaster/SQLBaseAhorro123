package Controller;

import Model.*;
import java.sql.*;
import javax.swing.*;

public class CEmpleadoPrestamos {

    Connection con;
    CallableStatement cstmt;
    Statement st;
    ResultSet rs;
    String driver;

    public CEmpleadoPrestamos() {
        try {
            Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");
            this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ModelEmpleadoPrestamos getEmpleadoPrestamos(int numPrestamo) {
        ModelEmpleadoPrestamos m = new ModelEmpleadoPrestamos();
        try {
            rs = st.executeQuery("select * from EmpleadoPrestamos where NUMERO_PRESTAMO=" + numPrestamo);
            rs.next();
            m.numPrestamo = rs.getInt(1);
            m.codEmpleado = rs.getInt(2);
            m.fechaCreacion = rs.getDate(3);
            m.fechaActualizacion = rs.getDate(4);
            m.usuarioCreador = rs.getString(5);
            m.usuarioActualizador = rs.getString(6);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return m;
    }

    public void insertEmpleadoPrestamos(ModelEmpleadoPrestamos m) {
        try {
            cstmt = con.prepareCall("{call SP_EMPLEADOPRESTAMOS_INSERT}");
            cstmt.setInt(1, m.numPrestamo);
            cstmt.setInt(2, m.codEmpleado);
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

    public void updateEmpleadoPrestamos(ModelEmpleadoPrestamos m) {
        try {
            cstmt = con.prepareCall("{call SP_EMPLEADOPRESTAMOS_UPDATE}");
            cstmt.setInt(1, m.numPrestamo);
            cstmt.setInt(2, m.codEmpleado);
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

    public void deleteEmpleadoPrestamos(ModelEmpleadoPrestamos m) {
        try {
            cstmt = con.prepareCall("{call SP_EMPLEADOPRESTAMOS_DELETE}");
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
            ResultSet rs = st.executeQuery("select * from EmpleadoPrestamos");
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

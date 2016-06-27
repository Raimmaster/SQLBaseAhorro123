package Controller;

import Model.*;
import java.sql.*;
import javax.swing.*;

public class CUsuarios {

    Connection con;
    CallableStatement cstmt;
    Statement st;
    ResultSet rs;
    String driver;

    public CUsuarios() {
        try {
            Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");
            this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ModelUsuarios getUsuarios(String idUsuario) {
        ModelUsuarios m = new ModelUsuarios();
        try {
            rs = st.executeQuery("select * from Usuarios where idUsuario=" + idUsuario);
            rs.next();
            m.idUsuario = rs.getString("idUsuario");
            m.username = rs.getString("username");
            m.claveUsuario = rs.getString("claveUsuario");
            m.fechaCreacion = rs.getDate("fechaCreacion");
            m.fechaActualizacion = rs.getDate("fechaActualizacion");
            m.usuarioCreador = rs.getString("usuarioCreador");
            m.usuarioActualizador = rs.getString("usuarioActualizador");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return m;
    }

    public void insertUsuarios(ModelUsuarios m) {
        try {
            cstmt = con.prepareCall("{call SP_USUARIOS_INSERT}");
            cstmt.setString(1, m.idUsuario);
            cstmt.setString(2, m.username);
            cstmt.setString(3, m.claveUsuario);
            cstmt.setDate(4, (Date) m.fechaCreacion);
            cstmt.setDate(5, (Date) m.fechaActualizacion);
            cstmt.setString(6, m.usuarioCreador);
            cstmt.setString(7, m.usuarioActualizador);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updateUsuarios(ModelUsuarios m) {
        try {
            cstmt = con.prepareCall("{call SP_USUARIOS_UPDATE}");
            cstmt.setString(1, m.idUsuario);
            cstmt.setString(2, m.username);
            cstmt.setString(3, m.claveUsuario);
            cstmt.setDate(4, (Date) m.fechaCreacion);
            cstmt.setDate(5, (Date) m.fechaActualizacion);
            cstmt.setString(6, m.usuarioCreador);
            cstmt.setString(7, m.usuarioActualizador);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deleteUsuarios(ModelUsuarios m) {
        try {
            cstmt = con.prepareCall("{call SP_USUARIOS_DELETE}");
            cstmt.setString(1, m.idUsuario);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public DefaultListModel obtenerDatos() {
        DefaultListModel l = new DefaultListModel();
        try {
            ResultSet rs = st.executeQuery("select * from Usuarios");
            while (rs.next()) {
                l.addElement(rs.getString("idUsuario"));
                l.addElement(rs.getString("username"));
                l.addElement(rs.getString("claveUsuario"));
                l.addElement(rs.getDate("fechaCreacion"));
                l.addElement(rs.getDate("fechaActualizacion"));
                l.addElement(rs.getString("usuarioCreador"));
                l.addElement(rs.getString("usuarioActualizador"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return l;
    }
}

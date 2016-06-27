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

    public ModelUsuarios getUsuarios(String ID_USUARIO) {
        MEmpleados m = new MEmpleados();
        try {
            rs = st.executeQuery("select * from Usuarios where ID_USUARIO=" + id);
            rs.next();
            m.ID_USUARIO = rs.getString("ID_USUARIO");
            m.USERNAME = rs.getString("USERNAME");
            m.CLAVE_USUARIO = rs.getString("CLAVE_USUARIO");
            m.FECHA_CREACION_USU = rs.getDate("FECHA_CREACION_USU");
            m.FECHA_ACTUALIZACION_USU = rs.getDate("FECHA_ACTUALIZACION_USU");
            m.CODIGO_USUARIO_CREADOR = rs.getString("CODIGO_USUARIO_CREADOR");
            m.CODIGO_USUARIO_ACTUALIZO = rs.getString("CODIGO_USUARIO_ACTUALIZO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return m; 
    }
    
    public void insertUsuarios(ModelUsuarios m) {
        try {
            cstmt = con.prepareCall("{call SP_USUARIOS_INSERT}");
            cstmt.setString(1, m.ID_USUARIO);
            cstmt.setString(2, m.USERNAME);
            cstmt.setString(3, m.CLAVE_USUARIO);
            cstmt.setDate(4, m.FECHA_CREACION_USU);
            cstmt.setDate(5, m.FECHA_ACTUALIZACION_USU);
            cstmt.setString(6, m.CODIGO_USUARIO_CREADOR);
            cstmt.setString(7, m.CODIGO_USUARIO_ACTUALIZO);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updateUsuarios(ModelUsuarios m) {
        try {
            cstmt = con.prepareCall("{call SP_USUARIOS_UPDATE}");
            cstmt.setString(1, m.ID_USUARIO);
            cstmt.setString(2, m.USERNAME);
            cstmt.setString(3, m.CLAVE_USUARIO);
            cstmt.setDate(4, m.FECHA_CREACION_USU);
            cstmt.setDate(5, m.FECHA_ACTUALIZACION_USU);
            cstmt.setString(6, m.CODIGO_USUARIO_CREADOR);
            cstmt.setString(7, m.CODIGO_USUARIO_ACTUALIZO);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deleteUsuarios(ModelUsuarios m) {
        try {
            cstmt = con.prepareCall("{call SP_USUARIOS_DELETE}");
            cstmt.setString(1, m.ID_USUARIO);
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
                l.addElement(rs.getString("ID_USUARIO"));
                l.addElement(rs.getString("USERNAME"));
                l.addElement(rs.getString("CLAVE_USUARIO"));
                l.addElement(rs.getDate("FECHA_CREACION_USU"));
                l.addElement(rs.getDate("FECHA_ACTUALIZACION_USU"));
                l.addElement(rs.getString("CODIGO_USUARIO_CREADOR"));
                l.addElement(rs.getString("CODIGO_USUARIO_ACTUALIZO"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return l;
    }
}

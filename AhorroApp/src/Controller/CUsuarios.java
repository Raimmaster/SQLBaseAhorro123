package Controller;

import Model.*;
import java.sql.*;
import java.util.Calendar;
import javax.swing.*;
import java.util.Date;

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
            con = DriverManager.getConnection(this.driver, "SYSADM", "SYSADM");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, "Ese fue el error...");
        }
    }

    public ModelUsuarios getUsuarios(String idUsuario) {
        ModelUsuarios m = new ModelUsuarios();
        try {
            rs = st.executeQuery("select * from USUARIOS where ID_USUARIO=" + idUsuario);
            rs.next();
            m.idUsuario = rs.getString(1);
            m.username = rs.getString(2);
            m.claveUsuario = rs.getString(3);
            m.fechaCreacion = rs.getDate(4);
            m.fechaActualizacion = rs.getDate(5);
            m.usuarioCreador = rs.getString(6);
            m.usuarioActualizador = rs.getString(7);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return m;
    }

    public void insertUsuarios(ModelUsuarios m) {
        try {
            cstmt = con.prepareCall("{call SP_USUARIOS_INSERT}");
            cstmt.setString(1, m.idUsuario);
            cstmt.setString(2, m.claveUsuario);
            cstmt.setString(3, m.username);
            cstmt.setString(4, m.usuarioCreador);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, "Something went wrong...");
        }
    }

    public void updateUsuarios(ModelUsuarios m) {
        try {
            Calendar cal = Calendar.getInstance();
            
            cstmt = con.prepareCall("{call SP_USUARIOS_UPDATE}");
            cstmt.setString(1, m.idUsuario);
            cstmt.setString(2, m.username);
            cstmt.setString(3, m.claveUsuario);
            cstmt.setDate(4, new java.sql.Date( m.fechaCreacion.getTime() ));
            cstmt.setDate(5, new java.sql.Date( m.fechaActualizacion.getTime() ) );
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
            //st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM USUARIOS");
            while (res.next()) {
                l.addElement(res.getString(1));
                l.addElement(res.getString(2));
                l.addElement(res.getString(3));
                //l.addElement(res.getDate(4) == null ? (new Date()).getTime() : res.getDate(4) );
               //l.addElement(res.getDate(5) == null ? (new Date()).getTime() : res.getDate(5));
                l.addElement(res.getDate(4));
                l.addElement(res.getDate(5));
                l.addElement(res.getString(6));
                l.addElement(res.getString(7));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e.getMessage());
        }
        return l;
    }
}

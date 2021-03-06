package Controller;

import Model.*;
import java.sql.*;
import javax.swing.*;

public class CRolesPrivilegios {

    Connection con;
    CallableStatement cstmt;
    Statement st;
    ResultSet rs;
    String driver;

    public CRolesPrivilegios() {
        try {
            Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");
            this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ModelRolesPrivilegios getRolesPrivilegios(int idPrivilegio, int idRol) {
        ModelRolesPrivilegios m = new ModelRolesPrivilegios();
        try {
            rs = st.executeQuery("select * from RolesPrivilegios where ID_PRIVILEGIO=" + idPrivilegio + " AND ID_ROL=" + idRol);
            rs.next();
            m.idPrivilegio = rs.getInt(1);
            m.idRol = rs.getInt(2);
            m.nombreRol = rs.getString(3);
            m.fechaCreacion = rs.getDate(4);
            m.fechaActualizacion = rs.getDate(5);
            m.usuarioCreador = rs.getString(6);
            m.usuarioActualizador = rs.getString(7);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return m;
    }

    public void insertRolesPrivilegios(ModelRolesPrivilegios m) {
        try {
            cstmt = con.prepareCall("{call SP_RolesPrivilegios_INSERT}");
            cstmt.setInt(1, m.idPrivilegio);
            cstmt.setInt(2, m.idRol);
            cstmt.setString(3, m.nombreRol);
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

    public void updateRolesPrivilegios(ModelRolesPrivilegios m) {
        try {
            cstmt = con.prepareCall("{call SP_RolesPrivilegios_UPDATE}");
            cstmt.setInt(1, m.idPrivilegio);
            cstmt.setInt(2, m.idRol);
            cstmt.setString(3, m.nombreRol);
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

    public void deleteRolesPrivilegios(ModelRolesPrivilegios m) {
        try {
            cstmt = con.prepareCall("{call SP_RolesPrivilegios_DELETE}");
            cstmt.setInt(1, m.idPrivilegio);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public DefaultListModel obtenerDatos() {
        DefaultListModel l = new DefaultListModel();
        try {
            ResultSet rs = st.executeQuery("select * from RolesPrivilegios");
            while (rs.next()) {
                l.addElement(rs.getInt(1));
                l.addElement(rs.getInt(2));
                l.addElement(rs.getString(3));
                l.addElement(rs.getDate(4));
                l.addElement(rs.getDate(5));
                l.addElement(rs.getString(6));
                l.addElement(rs.getString(7));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return l;
    }
}

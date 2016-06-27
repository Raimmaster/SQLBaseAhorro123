package Controller;

import Model.*;
import java.sql.*;
import javax.swing.*;

public class CEmpleados {

    Connection con;
    CallableStatement cstmt;
    Statement st;
    ResultSet rs;
    String driver;

    public CEmpleados() {
        try {
            Class.forName("jdbc.gupta.sqlbase.SqlbaseDriver");
            this.driver = "jdbc:sqlbase://localhost:2155/AHORRO123";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ModelEmpleados getEmpleados(int codEmpleado) {
        ModelEmpleados m = new ModelEmpleados();
        try {
            rs = st.executeQuery("select * from Empleados where CODIGO_EMPLEADO=" + codEmpleado);
            rs.next();
            m.codEmpleado = rs.getInt(1);
            m.primerNombre = rs.getString(2);
            m.segundoNombre = rs.getString(3);
            m.primerApellido = rs.getString(4);
            m.segundoApellido = rs.getString(5);
            m.dirCalle = rs.getString(6);
            m.dirAvenida = rs.getString(7);
            m.dirNumCasa = rs.getInt(8);
            m.dirCiudad = rs.getString(9);
            m.dirDepto = rs.getString(10);
            m.dirReferencia = rs.getString(11);
            m.idUsuario = rs.getString(12);
            m.emailSecundario = rs.getString(13);
            m.fechaNacimiento = rs.getDate(14);
            m.fechaInicioEnEmpresa = rs.getDate(15);
            m.fechaCreacion = rs.getDate(16);
            m.fechaActualizacion = rs.getDate(17);
            m.usuarioCreador = rs.getString(18);
            m.usuarioActualizador = rs.getString(19);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return m;
    }

    public void insertEmpleados(ModelEmpleados m) {
        try {
            cstmt = con.prepareCall("{call SP_EMPLEADOS_INSERT}");
            cstmt.setInt(1, m.codEmpleado);
            cstmt.setString(2, m.primerNombre);
            cstmt.setString(3, m.segundoNombre);
            cstmt.setString(4, m.primerApellido);
            cstmt.setString(5, m.segundoApellido);
            cstmt.setString(6, m.dirCalle);
            cstmt.setString(7, m.dirAvenida);
            cstmt.setInt(8, m.dirNumCasa);
            cstmt.setString(9, m.dirCiudad);
            cstmt.setString(10, m.dirDepto);
            cstmt.setString(11, m.dirReferencia);
            cstmt.setString(12, m.idUsuario);
            cstmt.setString(13, m.emailSecundario);
            cstmt.setDate(14, (Date) m.fechaNacimiento);
            cstmt.setDate(15, (Date) m.fechaInicioEnEmpresa);
            cstmt.setDate(16, (Date) m.fechaCreacion);
            cstmt.setDate(17, (Date) m.fechaActualizacion);
            cstmt.setString(18, m.usuarioCreador);
            cstmt.setString(19, m.usuarioActualizador);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updateEmpleados(ModelEmpleados m) {
        try {
            cstmt = con.prepareCall("{call SP_EMPLEADOS_UPDATE}");
            cstmt.setInt(1, m.codEmpleado);
            cstmt.setString(2, m.primerNombre);
            cstmt.setString(3, m.segundoNombre);
            cstmt.setString(4, m.primerApellido);
            cstmt.setString(5, m.segundoApellido);
            cstmt.setString(6, m.dirCalle);
            cstmt.setString(7, m.dirAvenida);
            cstmt.setInt(8, m.dirNumCasa);
            cstmt.setString(9, m.dirCiudad);
            cstmt.setString(10, m.dirDepto);
            cstmt.setString(11, m.dirReferencia);
            cstmt.setString(12, m.idUsuario);
            cstmt.setString(13, m.emailSecundario);
            cstmt.setDate(14, (Date) m.fechaNacimiento);
            cstmt.setDate(15, (Date) m.fechaInicioEnEmpresa);
            cstmt.setDate(16, (Date) m.fechaCreacion);
            cstmt.setDate(17, (Date) m.fechaActualizacion);
            cstmt.setString(18, m.usuarioCreador);
            cstmt.setString(19, m.usuarioActualizador);
            cstmt.executeUpdate();
            con.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deleteEmpleados(ModelEmpleados m) {
        try {
            cstmt = con.prepareCall("{call SP_EMPLEADOS_DELETE}");
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
            ResultSet rs = st.executeQuery("select * from Empleados");
            while (rs.next()) {
                l.addElement(rs.getInt(1));
                l.addElement(rs.getString(2));
                l.addElement(rs.getString(3));
                l.addElement(rs.getString(4));
                l.addElement(rs.getString(5));
                l.addElement(rs.getString(6));
                l.addElement(rs.getString(7));
                l.addElement(rs.getInt(8));
                l.addElement(rs.getString(9));
                l.addElement(rs.getString(10));
                l.addElement(rs.getString(11));
                l.addElement(rs.getString(12));
                l.addElement(rs.getString(13));
                l.addElement(rs.getDate(14));
                l.addElement(rs.getDate(15));
                l.addElement(rs.getDate(16));
                l.addElement(rs.getDate(17));
                l.addElement(rs.getString(18));
                l.addElement(rs.getString(19));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return l;
    }
}

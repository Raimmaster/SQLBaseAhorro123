/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelUsuarios {
    public String idUsuario;
    public String username;
    public String claveUsuario;
    public Calendar fechaCreacion;
    public Calendar fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelUsuarios(String id, String uname, String clave, 
            Calendar fechaCrea, Calendar fechaUpdate, String uCreador,
            String uUpdate){        
        idUsuario = id;
        username = uname;
        claveUsuario = clave;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
        
    }
}

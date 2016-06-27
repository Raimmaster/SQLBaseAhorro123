/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Date;
import java.util.Date;

/**
 *
 * @author Raim
 */
public class ModelUsuarios {
    public String idUsuario;
    public String username;
    public String claveUsuario;
    public Date fechaCreacion;
    public Date fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelUsuarios(){
        
    }
    
    public ModelUsuarios(String id, String uname, String clave, 
            Date fechaCrea, Date fechaUpdate, String uCreador,
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

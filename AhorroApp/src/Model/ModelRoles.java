package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelRoles {
    public int idRol;
    public String nombreRol;
    public Date fechaCreacion;
    public Date fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelRoles(){
        
    }
    
    public ModelRoles(
            int id,
            String nombre,
            Date fechaCrea, 
            Date fechaUpdate, 
            String uCreador,
            String uUpdate){        
        idRol = id;
        nombreRol = nombre;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
    }
}

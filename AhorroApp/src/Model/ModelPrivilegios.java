package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelPrivilegios {
    public int idPrivilegio;
    public String nombrePrivilegio;
    public Date fechaCreacion;
    public Date fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelPrivilegios(){
        
    }
    
    public ModelPrivilegios(int id,
            String nombre,
            Date fechaCrea, 
            Date fechaUpdate, 
            String uCreador,
            String uUpdate){        
        idPrivilegio = id;
        nombrePrivilegio = nombre;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
    }
}

package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelRolesPrivilegios {
    public int idPrivilegio;
    public int idRol;
    public String nombreRol; 
    public Date fechaCreacion;
    public Date fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelRolesPrivilegios(){
        
    }
    
    public ModelRolesPrivilegios(
            int idRo,
            int idPri,
            Date fechaCrea, 
            Date fechaUpdate, 
            String uCreador,
            String uUpdate){        
        idRol = idRo;
        idPrivilegio = idPri;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
    }
}

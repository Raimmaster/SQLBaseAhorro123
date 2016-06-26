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
    String nombreRol; 
    public Calendar fechaCreacion;
    public Calendar fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelRolesPrivilegios(
            int idRo,
            int idPri,
            Calendar fechaCrea, 
            Calendar fechaUpdate, 
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

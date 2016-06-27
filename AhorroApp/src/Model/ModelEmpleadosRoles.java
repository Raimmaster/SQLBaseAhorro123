package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelEmpleadosRoles {
    public int codEmpleado;
    public int idRol;
    public Date fechaCreacion;
    public Date fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelEmpleadosRoles(){
        
    }
    
    public ModelEmpleadosRoles(
            int codEmp,
            int idRo,
            Date fechaCrea, 
            Date fechaUpdate, 
            String uCreador,
            String uUpdate){    
        codEmpleado = codEmp;    
        idRol = idRo;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
    }
}

package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelEmpleadoTelefonos {
    public int codEmpleado;
    public String telefono;
    public Date fechaCreacion;
    public Date fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelEmpleadoTelefonos(){
        
    }
    
    public ModelEmpleadoTelefonos(
            int codEmp,
            String teleph,
            Date fechaCrea, 
            Date fechaUpdate, 
            String uCreador,
            String uUpdate){    
        codEmpleado = codEmp;    
        telefono = teleph;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
    }
}

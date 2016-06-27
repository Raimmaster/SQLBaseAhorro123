package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelPersonaPrestamos {
    public int numPrestamo;
    public int codEmpleado;
    public int codPersona;
    public String parentesco;
    public Date fechaCreacion;
    public Date fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelPersonaPrestamos(){
        
    }
    
    public ModelPersonaPrestamos(
            int numPre,
            int codEmp,
            int codPer,
            Date fechaCrea, 
            Date fechaUpdate, 
            String uCreador,
            String uUpdate){    
        numPrestamo = numPre;   
        codEmpleado = codEmp;
        codPersona = codPer;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
    }
}

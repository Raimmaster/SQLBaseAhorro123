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
    public Calendar fechaCreacion;
    public Calendar fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelPersonaPrestamos(
            int numPre,
            int codEmp,
            int codPer,
            Calendar fechaCrea, 
            Calendar fechaUpdate, 
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

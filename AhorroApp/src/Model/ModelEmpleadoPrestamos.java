package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelEmpleadoPrestamos {
    public int numPrestamo;
    public int codEmpleado;
    public Calendar fechaCreacion;
    public Calendar fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelEmpleadoPrestamos(){
        
    }
    
    public ModelEmpleadoPrestamos(
            int numPre,
            int cod,
            Calendar fechaCrea, 
            Calendar fechaUpdate, 
            String uCreador,
            String uUpdate){    
        numPrestamo = numPre;   
        codEmpleado = cod;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
    }
}

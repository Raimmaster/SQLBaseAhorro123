package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelEmpleadosCuentas {
    public int codEmpleado;
    public int numeroCuenta;
    public Date fechaCreacion;
    public Date fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelEmpleadosCuentas(){
        
    }
    
    public ModelEmpleadosCuentas(
            int codEmp,
            int numCuenta,
            Date fechaCrea, 
            Date fechaUpdate, 
            String uCreador,
            String uUpdate){    
        codEmpleado = codEmp;    
        numeroCuenta = numCuenta;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
    }
}

package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelPrestamos {
    public int numPrestamo;
    public Date fechaPrestamo;
    public double montoPrestamo;
    public int periodos;
    public double saldo;
    public Date fechaCreacion;
    public Date fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelPrestamos(){
        
    }
    
    public ModelPrestamos(
            int numPre,
            Date fechaP,
            double monto,
            int period,
            double sald,
            Date fechaCrea, 
            Date fechaUpdate, 
            String uCreador,
            String uUpdate){    
        numPrestamo = numPre;   
        fechaPrestamo = fechaP;
        montoPrestamo = monto;
        periodos = period;
        saldo = sald;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
    }
}

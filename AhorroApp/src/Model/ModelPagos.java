package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelPagos {
    public int numPrestamo;
    public int numeroPago;
    public Date fechaPago;
    public double montoPago;
    public Date fechaCreacion;
    public Date fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelPagos(){
        
    }
    
    public ModelPagos(
            int numPre,
            int numPago,
            Date fechaP,
            double monto,
            Date fechaCrea, 
            Date fechaUpdate, 
            String uCreador,
            String uUpdate){    
        numPrestamo = numPre;   
        numeroPago = numPago;
        fechaPago = fechaP;
        montoPago = monto;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
    }
}

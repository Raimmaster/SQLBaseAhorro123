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
    public Calendar fechaPago;
    public double montoPago;
    public String parentesco;
    public Calendar fechaCreacion;
    public Calendar fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelPagos(
            int numPre,
            int numPago,
            Calendar fechaP,
            double monto,
            String paren,
            Calendar fechaCrea, 
            Calendar fechaUpdate, 
            String uCreador,
            String uUpdate){    
        numPrestamo = numPre;   
        numeroPago = numPago;
        fechaPago = fechaP;
        montoPago = monto;
        parentesco = paren;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
    }
}

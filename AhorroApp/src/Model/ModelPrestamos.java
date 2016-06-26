package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelPrestamos {
    public int numPrestamo;
    public Calendar fechaPrestamo;
    public double montoPrestamo;
    public int periodos;
    public double saldo;
    public Calendar fechaCreacion;
    public Calendar fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelPrestamos(
            int numPre,
            Calendar fechaP,
            double monto,
            int period,
            double sald,
            Calendar fechaCrea, 
            Calendar fechaUpdate, 
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

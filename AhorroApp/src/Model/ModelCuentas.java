package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelCuentas {
    public int numeroCuenta;
    public Date fechaApertura;
    public double saldoCuenta;
    public String tipoCuenta;
    public double montoAnual;
    public String tipoAbono;   
    public Date fechaCreacion;
    public Date fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelCuentas(){
        
    }
    
    public ModelCuentas(int numCuenta,
            Date fechaApert,
            double saldo,
            String tipoCuen,
            double monto,
            String tipoAbo,
            Date fechaCrea, 
            Date fechaUpdate, 
            String uCreador,
            String uUpdate){        
        numeroCuenta = numCuenta;
        fechaApertura = fechaApert;
        saldoCuenta = saldo;
        tipoCuenta = tipoCuen;
        montoAnual = monto;
        tipoAbono = tipoAbo;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
    }
}

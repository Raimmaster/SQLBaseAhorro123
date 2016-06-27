/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelCuentas {
    public int numeroCuenta;
    public Calendar fechaApertura;
    public double saldoCuenta;
    public String tipoCuenta;
    public double montoAnual;
    public String tipoAbono;   
    public Calendar fechaCreacion;
    public Calendar fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelCuentas(){
        
    }
    
    public ModelCuentas(int numCuenta,
            Calendar fechaApert,
            double saldo,
            String tipoCuen,
            double monto,
            String tipoAbo,
            Calendar fechaCrea, 
            Calendar fechaUpdate, 
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

package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelAbonos {
    public String codigoAbono;
    public double monto;
    public Calendar fecha;
    public String comentario;
    public int numeroCuenta;  
    public Calendar fechaCreacion;
    public Calendar fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    /**
     * Para INSERT
     * @param mont
     * @param fech
     * @param coment
     * @param numCuenta
     * @param fechaCrea
     * @param fechaUpdate
     * @param uCreador
     * @param uUpdate 
     */
    public ModelAbonos(
            double mont,
            Calendar fech,
            String coment,
            int numCuenta, 
            Calendar fechaCrea, 
            Calendar fechaUpdate, 
            String uCreador,
            String uUpdate){        
        codigoAbono = getCodigoAbono(numCuenta);
        monto = mont;
        fecha = fech;
        comentario = coment;
        numeroCuenta = numCuenta;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
    }
    
    /**
     * Para UPDATE
     * @param codigo
     * @param mont
     * @param fech
     * @param coment
     * @param numCuenta
     * @param fechaCrea
     * @param fechaUpdate
     * @param uCreador
     * @param uUpdate 
     */
    public ModelAbonos(
            String codigo,
            double mont,
            Calendar fech,
            String coment,
            int numCuenta, 
            Calendar fechaCrea, 
            Calendar fechaUpdate, 
            String uCreador,
            String uUpdate){        
        codigoAbono = codigo;
        monto = mont;
        fecha = fech;
        comentario = coment;
        numeroCuenta = numCuenta;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
    }

    public String getCodigoAbono(int numCuenta){
        String codigo = "";
        java.util.Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String month = getMonth(cal.get(Calendar.MONTH));
        String year = "" + cal.get(Calendar.YEAR);

        codigo = year + month + numCuenta;

        return codigo;
    }
    
    public static String getMonth(int num){
        switch(num){
            case 0:
                return "ENE";
            case 1:
                return "FEB";
            case 2:
                return "MAR";
            case 3:
                return "ABR";
            case 4:
                return "MAY";
            case 5:
                return "JUN";
            case 6:
                return "JUL";
            case 7:
                return "AGO";
            case 8:
                return "SEP";
            case 9:
                return "OCT";
            case 10:
                return "NOV";
            case 11:
                return "DIC";
            default: 
                return "";
        }        
    }
}

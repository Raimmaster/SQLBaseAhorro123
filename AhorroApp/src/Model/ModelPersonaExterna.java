package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelPersonaExterna {
    public int codPersona;
    public String primerNombre;
    public String segundoNombre;
    public String primerApellido;
    public String segundoApellido;
    public String dirCalle;
    public String dirAvenida;
    public int dirNumCasa;
    public String dirCiudad;
    public String dirDepto;
    public String dirReferencia;
    public String emailPrimario; 
    public String emailSecundario;
    public Calendar fechaNacimiento;
    public Calendar fechaCreacion;
    public Calendar fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelPersonaExterna(){
        
    }
    
    public ModelPersonaExterna(
            int id,
            String firstName,
            String secondName,
            String firstLastName,
            String secondLastName,
            String calle,
            String avenida,
            int numCasa,
            String ciudad,
            String depto,
            String referencia,
            String emailPrim,
            String emailSec,
            Calendar fechaNac,
            Calendar fechaCrea, 
            Calendar fechaUpdate, 
            String uCreador,
            String uUpdate){
        codPersona = id;
        primerNombre = firstName;
        segundoNombre = secondName;
        primerApellido = firstLastName;
        segundoApellido = secondLastName;
        dirCalle = calle;
        dirAvenida = avenida;
        dirNumCasa = numCasa;
        dirCiudad = ciudad;
        dirDepto = depto;
        dirReferencia = referencia;
        emailPrimario = emailPrim;
        emailSecundario = emailSec;
        fechaNacimiento = fechaNac;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
    }
}

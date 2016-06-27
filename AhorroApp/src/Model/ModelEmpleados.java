package Model;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Raim
 */
public class ModelEmpleados {
    public int codEmpleado;
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
    public String idUsuario; //correo primario
    public String emailSecundario;
    public Date fechaNacimiento;
    public Date fechaInicioEnEmpresa;
    public Date fechaCreacion;
    public Date fechaActualizacion;
    public String usuarioCreador;
    public String usuarioActualizador;
    
    public ModelEmpleados(){
        
    }
    
    public ModelEmpleados(
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
            String idUser,
            String emailSec,
            Date fechaNac,
            Date fechaIni,
            Date fechaCrea, 
            Date fechaUpdate, 
            String uCreador,
            String uUpdate){
        codEmpleado = id;
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
        idUsuario = idUser;
        emailSecundario = emailSec;
        fechaNacimiento = fechaNac;
        fechaInicioEnEmpresa = fechaIni;
        fechaCreacion = fechaCrea;
        fechaActualizacion = fechaUpdate;
        usuarioCreador = uCreador;
        usuarioActualizador = uUpdate;
    }
}

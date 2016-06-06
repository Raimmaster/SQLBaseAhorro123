--------USUARIOS
STORE SP_USUARIOS_INSERT
Procedure SP_USUARIOS_INSERT STATIC
Parameters
	STRING:  n_Id_Usuario
	STRING:  n_Clave
	STRING:  n_Username
Local Variables
	Sql Handle  hSql
Actions
	On Procedure Startup
		Call SqlConnect( hSql )
	On Procedure Execute
		Call SqlPrepare( hSql, 'INSERT INTO USUARIOS (ID_USUARIO, USERNAME, CLAVE_USUARIO) VALUES (:n_Id_Usuario, :n_Username, :n_Clave)' )
		Call SqlExecute( hSql )
	On Procedure Close
		Call SqlDisconnect( hSql );

-------
STORE SP_USUARIOS_UPDATE
Procedure SP_USUARIOS_UPDATE STATIC
Parameters
	STRING:  n_Id_Usuario
	STRING:  n_Clave
	STRING:  n_Username
Local Variables
	Sql Handle  hSql
Actions
	On Procedure Startup
		Call SqlConnect( hSql )
	On Procedure Execute
		Call SqlPrepare( hSql, 'UPDATE USUARIOS SET USERNAME = :n_Username, CLAVE_USUARIO = :n_Clave WHERE ID_USUARIO = :n_Id_Usuario' )
		Call SqlExecute( hSql )
	On Procedure Close
		Call SqlDisconnect( hSql );

--------------
STORE SP_USUARIOS_DELETE
Procedure SP_USUARIOS_DELETE STATIC
Parameters
	STRING:  n_Id_Usuario
Local Variables
	Sql Handle  hSql
Actions
	On Procedure Startup
		Call SqlConnect( hSql )
	On Procedure Execute
		Call SqlPrepare( hSql, 'DELETE FROM USUARIOS WHERE ID_USUARIO = :n_Id_Usuario' )
		Call SqlExecute( hSql )
	On Procedure Close
		Call SqlDisconnect( hSql );

-----------------CUENTAS
-------
STORE SP_CUENTAS_INSERT
Procedure SP_CUENTAS_INSERT STATIC
Parameters
	NUMBER: n_Num_Cuenta
	DATE/TIME: n_Fecha_Apert
	NUMBER: n_Saldo
	STRING: n_Tipo_Cuenta
Local Variables
	Sql Handle  hSql
Actions
	On Procedure Startup
		Call SqlConnect( hSql )
	On Procedure Execute
		Call SqlPrepare( hSql, 'INSERT INTO CUENTAS(NUMERO_CUENTA, FECHA_APERTURA, SALDO_CUENTA, TIPO_CUENTA) VALUES (:n_Num_Cuenta, :n_Fecha_Apert, :n_Saldo, :n_Tipo_Cuenta)' )
		Call SqlExecute( hSql )
	On Procedure Close
		Call SqlDisconnect( hSql );

-------
STORE SP_CUENTAS_UPDATE
Procedure SP_CUENTAS_UPDATE STATIC
Parameters
	NUMBER: n_Num_Cuenta
	DATE/TIME: n_Fecha_Apert
	NUMBER: n_Saldo
	STRING: n_Tipo_Cuenta
Local Variables
	Sql Handle hSql
Actions
	On Procedure Startup
		Call SqlConnect( hSql )
	On Procedure Execute
		Call SqlPrepare( hSql, 'UPDATE CUENTAS SET FECHA_APERTURA = n_Fecha_Apert, SALDO_CUENTA = :n_Saldo, TIPO_CUENTA = :n_Tipo_Cuenta WHERE NUMERO_CUENTA = :n_Num_Cuenta' )
		Call SqlExecute( hSql )
	On Procedure Close
		Call SqlDisconnect( hSql );

-------
STORE SP_CUENTAS_DELETE
Procedure SP_CUENTAS_DELETE STATIC
Parameters
	NUMBER: n_Num_Cuenta
Local Variables
	Sql Handle hSql
Actions
	On Procedure Startup
		Call SqlConnect( hSql )
	On Procedure Execute
		Call SqlPrepare( hSql, 'DELETE FROM CUENTAS WHERE NUMERO_CUENTA = :n_Num_Cuenta' )
		Call SqlExecute( hSql )
	On Procedure Close
		Call SqlDisconnect( hSql );


---ABONOS
STORE SP_ABONOS_INSERT
Procedure SP_ABONOS_INSERT STATIC
Parameters
	STRING: n_CODIGO_DE_ABONO
	NUMBER: n_MONTO
	DATE/TIME: n_FECHA
	STRING: n_COMENTARIO
	NUMBER: n_NUMERO_CUENTA
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'INSERT INTO ABONOS(CODIGO_DE_ABONO,MONTO,FECHA,COMENTARIO,NUMERO_CUENTA) VALUES (:n_CODIGO_DE_ABONO,:n_MONTO,:n_FECHA,:n_COMENTARIO,:n_NUMERO_CUENTA)')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

-----
STORE SP_ABONOS_UPDATE
Procedure SP_ABONOS_UPDATE STATIC
Parameters
	STRING: n_CODIGO_DE_ABONO
	NUMBER: n_MONTO
	DATE/TIME: n_FECHA
	STRING: n_COMENTARIO
	NUMBER: n_NUMERO_CUENTA
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'UPDATE ABONOS SET MONTO = :n_MONTO, FECHA = :n_FECHA, COMENTARIO = :n_COMENTARIO, NUMERO_CUENTA = :n_NUMERO_CUENTA WHERE CODIGO_DE_ABONO = :n_CODIGO_DE_ABONO')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

-------
STORE SP_ABONOS_DELETE
Procedure SP_ABONOS_DELETE STATIC
Parameters
	STRING: n_CODIGO_DE_ABONO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'DELETE FROM ABONOS WHERE CODIGO_DE_ABONO = :n_CODIGO_DE_ABONO')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

---------
--PRIVILEGIOS
STORE SP_PRIVILEGIOS_INSERT
Procedure SP_PRIVILEGIOS_INSERT STATIC
Parameters
	NUMBER: n_ID_PRIVILEGIO
	STRING: n_NOMBRE_PRIVILEGIO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'INSERT INTO PRIVILEGIOS(NOMBRE_PRIVILEGIO) VALUES (:n_NOMBRE_PRIVILEGIO)')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--------
STORE SP_PRIVILEGIOS_UPDATE
Procedure SP_PRIVILEGIOS_UPDATE STATIC
Parameters
	NUMBER: n_ID_PRIVILEGIO
	STRING: n_NOMBRE_PRIVILEGIO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'UPDATE PRIVILEGIOS SET NOMBRE_PRIVILEGIO = :n_NOMBRE_PRIVILEGIO WHERE ID_PRIVILEGIO = :n_ID_PRIVILEGIO')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );


--------
STORE SP_PRIVILEGIOS_DELETE
Procedure SP_PRIVILEGIOS_DELETE STATIC
Parameters
	NUMBER: n_ID_PRIVILEGIO
	STRING: n_NOMBRE_PRIVILEGIO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'DELETE FROM PRIVILEGIOS WHERE ID_PRIVILEGIO = :n_ID_PRIVILEGIO')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

-----------
--ROLES
STORE SP_ROLES_INSERT
Procedure SP_ROLES_INSERT STATIC
Parameters
	NUMBER: n_ID_ROL
	STRING: n_NOMBRE_ROL
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'INSERT INTO ROLES(ID_ROL,NOMBRE_ROL) VALUES (:n_ID_ROL,:n_NOMBRE_ROL)')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--Update
STORE SP_ROLES_UPDATE
Procedure SP_ROLES_UPDATE STATIC
Parameters
	NUMBER: n_ID_ROL
	STRING: n_NOMBRE_ROL
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'UPDATE ROLES SET NOMBRE_ROL = :n_NOMBRE_ROL WHERE ID_ROL = :n_ID_ROL')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--Delete
STORE SP_ROLES_DELETE
Procedure SP_ROLES_DELETE STATIC
Parameters
	NUMBER: n_ID_ROL
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'DELETE FROM ROLES WHERE ID_ROL = :n_ID_ROL')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

-----------
--ROLES_PRIVILEGIOS
STORE SP_ROLES_PRIVILEGIOS_INSERT
Procedure SP_ROLES_PRIVILEGIOS_INSERT STATIC
Parameters
	NUMBER: n_ID_PRIVILEGIO
	NUMBER: n_ID_ROL
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'INSERT INTO ROLES_PRIVILEGIOS(ID_PRIVILEGIO,ID_ROL) VALUES (:n_ID_PRIVILEGIO,:n_ID_ROL)')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

----
STORE SP_ROLES_PRIVILEGIOS_UPDATE
Procedure SP_ROLES_PRIVILEGIOS_UPDATE STATIC
Parameters
	NUMBER: n_ID_PRIVILEGIO
	NUMBER: n_ID_ROL
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'UPDATE ROLES_PRIVILEGIOS SET ID_ROL = :n_ID_ROL WHERE ID_PRIVILEGIO = :n_ID_PRIVILEGIO AND ID_ROL = :n_ID_ROL ')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

-----
STORE SP_ROLES_PRIVILEGIOS_DELETE
Procedure SP_ROLES_PRIVILEGIOS_DELETE STATIC
Parameters
	NUMBER: n_ID_PRIVILEGIO
	NUMBER: n_ID_ROL
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'DELETE FROM ROLES_PRIVILEGIOS WHERE ID_PRIVILEGIO = :n_ID_PRIVILEGIO AND ID_ROL = :n_ID_ROL')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

----------
--EMPLEADOS
STORE SP_EMPLEADOS_INSERT
Procedure SP_EMPLEADOS_INSERT STATIC
Parameters
	NUMBER: n_CODIGO_EMPLEADO
	STRING: n_PRIMER_NOMBRE
	STRING: n_SEGUNDO_NOMBRE
	STRING: n_PRIMER_APELLIDO
	STRING: n_SEGUNDO_APELLIDO
	STRING: n_DIRECCION_CALLE
	STRING: n_DIRECCION_AVENIDA
	NUMBER: n_DIRECCION_NUM_CASA
	STRING: n_DIRECCION_CIUDAD
	STRING: n_DIRECCION_DEPARTAMENTO
	STRING: n_DIRECCION_REFERENCIA
	STRING: n_ID_USUARIO
	STRING: n_EMAIL_SECUNDARIO
	DATE/TIME: n_FECHA_NACIMIENTO
	DATE/TIME: n_FECHA_INICIO_EN_EMPRESA
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'INSERT INTO EMPLEADOS(CODIGO_EMPLEADO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,DIRECCION_CALLE,DIRECCION_AVENIDA,DIRECCION_NUM_CASA,DIRECCION_CIUDAD,DIRECCION_DEPARTAMENTO,DIRECCION_REFERENCIA,ID_USUARIO,EMAIL_SECUNDARIO,FECHA_NACIMIENTO,FECHA_INICIO_EN_EMPRESA) VALUES (:n_CODIGO_EMPLEADO,:n_PRIMER_NOMBRE,:n_SEGUNDO_NOMBRE,:n_PRIMER_APELLIDO,:n_SEGUNDO_APELLIDO,:n_DIRECCION_CALLE,:n_DIRECCION_AVENIDA,:n_DIRECCION_NUM_CASA,:n_DIRECCION_CIUDAD,:n_DIRECCION_DEPARTAMENTO,:n_DIRECCION_REFERENCIA,:n_ID_USUARIO,:n_EMAIL_SECUNDARIO,:n_FECHA_NACIMIENTO,:n_FECHA_INICIO_EN_EMPRESA)')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

----
STORE SP_EMPLEADOS_UPDATE
Procedure SP_EMPLEADOS_UPDATE STATIC
Parameters
	NUMBER: n_CODIGO_EMPLEADO
	STRING: n_PRIMER_NOMBRE
	STRING: n_SEGUNDO_NOMBRE
	STRING: n_PRIMER_APELLIDO
	STRING: n_SEGUNDO_APELLIDO
	STRING: n_DIRECCION_CALLE
	STRING: n_DIRECCION_AVENIDA
	NUMBER: n_DIRECCION_NUM_CASA
	STRING: n_DIRECCION_CIUDAD
	STRING: n_DIRECCION_DEPARTAMENTO
	STRING: n_DIRECCION_REFERENCIA
	STRING: n_ID_USUARIO
	STRING: n_EMAIL_SECUNDARIO
	DATE/TIME: n_FECHA_NACIMIENTO
	DATE/TIME: n_FECHA_INICIO_EN_EMPRESA
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'UPDATE EMPLEADOS SET PRIMER_NOMBRE = :n_PRIMER_NOMBRE, SEGUNDO_NOMBRE = :n_SEGUNDO_NOMBRE, PRIMER_APELLIDO = :n_PRIMER_APELLIDO, SEGUNDO_APELLIDO = :n_SEGUNDO_APELLIDO, DIRECCION_CALLE = :n_DIRECCION_CALLE, DIRECCION_AVENIDA = :n_DIRECCION_AVENIDA, DIRECCION_NUM_CASA = :n_DIRECCION_NUM_CASA, DIRECCION_CIUDAD = :n_DIRECCION_CIUDAD, DIRECCION_DEPARTAMENTO = :n_DIRECCION_DEPARTAMENTO, DIRECCION_REFERENCIA = :n_DIRECCION_REFERENCIA, ID_USUARIO = :n_ID_USUARIO, EMAIL_SECUNDARIO = :n_EMAIL_SECUNDARIO, FECHA_NACIMIENTO = :n_FECHA_NACIMIENTO, FECHA_INICIO_EN_EMPRESA = :n_FECHA_INICIO_EN_EMPRESA WHERE CODIGO_EMPLEADO = :n_CODIGO_EMPLEADO')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

------
STORE SP_EMPLEADOS_DELETE
Procedure SP_EMPLEADOS_DELETE STATIC
Parameters
	NUMBER: n_CODIGO_EMPLEADO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'DELETE FROM EMPLEADOS WHERE CODIGO_EMPLEADO = :n_CODIGO_EMPLEADO')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--------
--EMPLEADOS CUENTAS
STORE SP_EMPLEADOS_CUENTAS_INSERT
Procedure SP_EMPLEADOS_CUENTAS_INSERT STATIC
Parameters
	NUMBER: n_CODIGO_EMPLEADO
	NUMBER: n_NUMERO_CUENTA
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'INSERT INTO EMPLEADOS_CUENTAS(CODIGO_EMPLEADO,NUMERO_CUENTA) VALUES (:n_CODIGO_EMPLEADO,:n_NUMERO_CUENTA)')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

----
STORE SP_EMPLEADOS_CUENTAS_UPDATE
Procedure SP_EMPLEADOS_CUENTAS_UPDATE STATIC
Parameters
	NUMBER: n_CODIGO_EMPLEADO
	NUMBER: n_NUMERO_CUENTA
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'UPDATE EMPLEADOS_CUENTAS SET  WHERE CODIGO_EMPLEADO = :n_CODIGO_EMPLEADO AND NUMERO_CUENTA = :n_NUMERO_CUENTA')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--
STORE SP_EMPLEADOS_CUENTAS_DELETE
Procedure SP_EMPLEADOS_CUENTAS_DELETE STATIC
Parameters
	NUMBER: n_CODIGO_EMPLEADO
	NUMBER: n_NUMERO_CUENTA
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'DELETE FROM EMPLEADOS_CUENTAS WHERE CODIGO_EMPLEADO = :n_CODIGO_EMPLEADO AND NUMERO_CUENTA = :n_NUMERO_CUENTA')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

------
--EMPLEADOS ROLES
STORE SP_EMPLEADOS_ROLES_INSERT
Procedure SP_EMPLEADOS_ROLES_INSERT STATIC
Parameters
	NUMBER: n_CODIGO_EMPLEADO
	NUMBER: n_ID_ROL
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'INSERT INTO EMPLEADOS_ROLES(CODIGO_EMPLEADO,ID_ROL) VALUES (:n_CODIGO_EMPLEADO,:n_ID_ROL)')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--
STORE SP_EMPLEADOS_ROLES_UPDATE
Procedure SP_EMPLEADOS_ROLES_UPDATE STATIC
Parameters
	NUMBER: n_CODIGO_EMPLEADO
	NUMBER: n_ID_ROL
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'UPDATE EMPLEADOS_ROLES SET  WHERE CODIGO_EMPLEADO = :n_CODIGO_EMPLEADO AND ID_ROL = :n_ID_ROL')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--
STORE SP_EMPLEADOS_ROLES_DELETE
Procedure SP_EMPLEADOS_ROLES_DELETE STATIC
Parameters
	NUMBER: n_CODIGO_EMPLEADO
	NUMBER: n_ID_ROL
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'DELETE FROM EMPLEADOS_ROLES WHERE CODIGO_EMPLEADO = :n_CODIGO_EMPLEADO AND ID_ROL = :n_ID_ROL')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );


------
--EMPLEADO_TELEFONOS
STORE SP_EMPLEADO_TELEFONOS_INSERT
Procedure SP_EMPLEADO_TELEFONOS_INSERT STATIC
Parameters
	NUMBER: n_CODIGO_EMPLEADO
	STRING: n_TELEFONO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'INSERT INTO EMPLEADO_TELEFONOS(CODIGO_EMPLEADO,TELEFONO) VALUES (:n_CODIGO_EMPLEADO,:n_TELEFONO)')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--
STORE SP_EMPLEADO_TELEFONOS_UPDATE
Procedure SP_EMPLEADO_TELEFONOS_UPDATE STATIC
Parameters
	NUMBER: n_CODIGO_EMPLEADO
	STRING: n_TELEFONO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'UPDATE EMPLEADO_TELEFONOS SET  WHERE CODIGO_EMPLEADO = :n_CODIGO_EMPLEADO AND TELEFONO = :n_TELEFONO')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--
STORE SP_EMPLEADO_TELEFONOS_DELETE
Procedure SP_EMPLEADO_TELEFONOS_DELETE STATIC
Parameters
	NUMBER: n_CODIGO_EMPLEADO
	STRING: n_TELEFONO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'DELETE FROM EMPLEADO_TELEFONOS WHERE CODIGO_EMPLEADO = :n_CODIGO_EMPLEADO AND TELEFONO = :n_TELEFONO')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--------
--PERSONA_EXTERNA
STORE SP_PERSONA_EXTERNA_INSERT
Procedure SP_PERSONA_EXTERNA_INSERT STATIC
Parameters
	NUMBER: n_CODIGO_PERSONA
	STRING: n_PRIMER_NOMBRE
	STRING: n_SEGUNDO_NOMBRE
	STRING: n_PRIMER_APELLIDO
	STRING: n_SEGUNDO_APELLIDO
	STRING: n_DIRECCION_CALLE
	STRING: n_DIRECCION_AVENIDA
	NUMBER: n_DIRECCION_NUM_CASA
	STRING: n_DIRECCION_CIUDAD
	STRING: n_DIRECCION_DEPARTAMENTO
	STRING: n_DIRECCION_REFERENCIA
	STRING: n_EMAIL_PRIMARIO
	STRING: n_EMAIL_SECUNDARIO
	DATE/TIME: n_FECHA_NACIMIENTO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'INSERT INTO PERSONA_EXTERNA(CODIGO_PERSONA,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,DIRECCION_CALLE,DIRECCION_AVENIDA,DIRECCION_NUM_CASA,DIRECCION_CIUDAD,DIRECCION_DEPARTAMENTO,DIRECCION_REFERENCIA,EMAIL_PRIMARIO,EMAIL_SECUNDARIO,FECHA_NACIMIENTO) VALUES (:n_CODIGO_PERSONA,:n_PRIMER_NOMBRE,:n_SEGUNDO_NOMBRE,:n_PRIMER_APELLIDO,:n_SEGUNDO_APELLIDO,:n_DIRECCION_CALLE,:n_DIRECCION_AVENIDA,:n_DIRECCION_NUM_CASA,:n_DIRECCION_CIUDAD,:n_DIRECCION_DEPARTAMENTO,:n_DIRECCION_REFERENCIA,:n_EMAIL_PRIMARIO,:n_EMAIL_SECUNDARIO,:n_FECHA_NACIMIENTO)')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--
STORE SP_PERSONA_EXTERNA_UPDATE
Procedure SP_PERSONA_EXTERNA_UPDATE STATIC
Parameters
	NUMBER: n_CODIGO_PERSONA
	STRING: n_PRIMER_NOMBRE
	STRING: n_SEGUNDO_NOMBRE
	STRING: n_PRIMER_APELLIDO
	STRING: n_SEGUNDO_APELLIDO
	STRING: n_DIRECCION_CALLE
	STRING: n_DIRECCION_AVENIDA
	NUMBER: n_DIRECCION_NUM_CASA
	STRING: n_DIRECCION_CIUDAD
	STRING: n_DIRECCION_DEPARTAMENTO
	STRING: n_DIRECCION_REFERENCIA
	STRING: n_EMAIL_PRIMARIO
	STRING: n_EMAIL_SECUNDARIO
	DATE/TIME: n_FECHA_NACIMIENTO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'UPDATE PERSONA_EXTERNA SET PRIMER_NOMBRE = :n_PRIMER_NOMBRE, SEGUNDO_NOMBRE = :n_SEGUNDO_NOMBRE, PRIMER_APELLIDO = :n_PRIMER_APELLIDO, SEGUNDO_APELLIDO = :n_SEGUNDO_APELLIDO, DIRECCION_CALLE = :n_DIRECCION_CALLE, DIRECCION_AVENIDA = :n_DIRECCION_AVENIDA, DIRECCION_NUM_CASA = :n_DIRECCION_NUM_CASA, DIRECCION_CIUDAD = :n_DIRECCION_CIUDAD, DIRECCION_DEPARTAMENTO = :n_DIRECCION_DEPARTAMENTO, DIRECCION_REFERENCIA = :n_DIRECCION_REFERENCIA, EMAIL_PRIMARIO = :n_EMAIL_PRIMARIO, EMAIL_SECUNDARIO = :n_EMAIL_SECUNDARIO, FECHA_NACIMIENTO = :n_FECHA_NACIMIENTO WHERE CODIGO_PERSONA = :n_CODIGO_PERSONA')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--
STORE SP_PERSONA_EXTERNA_DELETE
Procedure SP_PERSONA_EXTERNA_DELETE STATIC
Parameters
	NUMBER: n_CODIGO_PERSONA
	STRING: n_PRIMER_NOMBRE
	STRING: n_SEGUNDO_NOMBRE
	STRING: n_PRIMER_APELLIDO
	STRING: n_SEGUNDO_APELLIDO
	STRING: n_DIRECCION_CALLE
	STRING: n_DIRECCION_AVENIDA
	NUMBER: n_DIRECCION_NUM_CASA
	STRING: n_DIRECCION_CIUDAD
	STRING: n_DIRECCION_DEPARTAMENTO
	STRING: n_DIRECCION_REFERENCIA
	STRING: n_EMAIL_PRIMARIO
	STRING: n_EMAIL_SECUNDARIO
	DATE/TIME: n_FECHA_NACIMIENTO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'DELETE FROM PERSONA_EXTERNA WHERE CODIGO_PERSONA = :n_CODIGO_PERSONA')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

----
--PERSONA_TELEFONOS
STORE SP_PERSONA_TELEFONOS_INSERT
Procedure SP_PERSONA_TELEFONOS_INSERT STATIC
Parameters
	NUMBER: n_CODIGO_PERSONA
	STRING: n_TELEFONO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'INSERT INTO PERSONA_TELEFONOS(CODIGO_PERSONA,TELEFONO) VALUES (:n_CODIGO_PERSONA,:n_TELEFONO)')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--
STORE SP_PERSONA_TELEFONOS_UPDATE
Procedure SP_PERSONA_TELEFONOS_UPDATE STATIC
Parameters
	NUMBER: n_CODIGO_PERSONA
	STRING: n_TELEFONO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'UPDATE PERSONA_TELEFONOS SET  WHERE CODIGO_PERSONA = :n_CODIGO_PERSONA AND TELEFONO = :n_TELEFONO')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--
STORE SP_PERSONA_TELEFONOS_DELETE
Procedure SP_PERSONA_TELEFONOS_DELETE STATIC
Parameters
	NUMBER: n_CODIGO_PERSONA
	STRING: n_TELEFONO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'DELETE FROM PERSONA_TELEFONOS WHERE CODIGO_PERSONA = :n_CODIGO_PERSONA AND TELEFONO = :n_TELEFONO')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

----
--PRESTAMOS
STORE SP_PRESTAMOS_INSERT
Procedure SP_PRESTAMOS_INSERT STATIC
Parameters
	NUMBER: n_NUMERO_PRESTAMO
	DATE/TIME: n_FECHA_PRESTAMO
	NUMBER: n_MONTO_PRESTAMO
	NUMBER: n_PERIODOS
	NUMBER: n_SALDO
	NUMBER: n_CODIGO_EMPLEADO
	NUMBER: n_CODIGO_PERSONA
	NUMBER: n_CODIGO_PERSONA_AVAL
	STRING: n_PARENTESCO_AVAL
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'INSERT INTO PRESTAMOS(NUMERO_PRESTAMO,FECHA_PRESTAMO,MONTO_PRESTAMO,PERIODOS,SALDO,CODIGO_EMPLEADO,CODIGO_PERSONA,CODIGO_PERSONA_AVAL,PARENTESCO_AVAL) VALUES (:n_NUMERO_PRESTAMO,:n_FECHA_PRESTAMO,:n_MONTO_PRESTAMO,:n_PERIODOS,:n_SALDO,:n_CODIGO_EMPLEADO,:n_CODIGO_PERSONA,:n_CODIGO_PERSONA_AVAL,:n_PARENTESCO_AVAL)')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--
STORE SP_PRESTAMOS_UPDATE
Procedure SP_PRESTAMOS_UPDATE STATIC
Parameters
	NUMBER: n_NUMERO_PRESTAMO
	DATE/TIME: n_FECHA_PRESTAMO
	NUMBER: n_MONTO_PRESTAMO
	NUMBER: n_PERIODOS
	NUMBER: n_SALDO
	NUMBER: n_CODIGO_EMPLEADO
	NUMBER: n_CODIGO_PERSONA
	NUMBER: n_CODIGO_PERSONA_AVAL
	STRING: n_PARENTESCO_AVAL
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'UPDATE PRESTAMOS SET FECHA_PRESTAMO = :n_FECHA_PRESTAMO, MONTO_PRESTAMO = :n_MONTO_PRESTAMO, PERIODOS = :n_PERIODOS, SALDO = :n_SALDO, CODIGO_EMPLEADO = :n_CODIGO_EMPLEADO, CODIGO_PERSONA = :n_CODIGO_PERSONA, CODIGO_PERSONA_AVAL = :n_CODIGO_PERSONA_AVAL, PARENTESCO_AVAL = :n_PARENTESCO_AVAL WHERE NUMERO_PRESTAMO = :n_NUMERO_PRESTAMO')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--
STORE SP_PRESTAMOS_DELETE
Procedure SP_PRESTAMOS_DELETE STATIC
Parameters
	NUMBER: n_NUMERO_PRESTAMO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'DELETE FROM PRESTAMOS WHERE NUMERO_PRESTAMO = :n_NUMERO_PRESTAMO')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

----
--PAGOS
STORE SP_PAGOS_INSERT
Procedure SP_PAGOS_INSERT STATIC
Parameters
	NUMBER: n_NUMERO_PRESTAMO
	NUMBER: n_NUMERO_PAGO
	DATE/TIME: n_FECHA_PAGO
	NUMBER: n_MONTO_PAGO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'INSERT INTO PAGOS(NUMERO_PRESTAMO,NUMERO_PAGO,FECHA_PAGO,MONTO_PAGO) VALUES (:n_NUMERO_PRESTAMO,:n_NUMERO_PAGO,:n_FECHA_PAGO,:n_MONTO_PAGO)')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--
STORE SP_PAGOS_UPDATE
Procedure SP_PAGOS_UPDATE STATIC
Parameters
	NUMBER: n_NUMERO_PRESTAMO
	NUMBER: n_NUMERO_PAGO
	DATE/TIME: n_FECHA_PAGO
	NUMBER: n_MONTO_PAGO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'UPDATE PAGOS SET FECHA_PAGO = :n_FECHA_PAGO, MONTO_PAGO = :n_MONTO_PAGO WHERE NUMERO_PRESTAMO = :n_NUMERO_PRESTAMO AND NUMERO_PAGO = :n_NUMERO_PAGO')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );

--
STORE SP_PAGOS_DELETE
Procedure SP_PAGOS_DELETE STATIC
Parameters
	NUMBER: n_NUMERO_PRESTAMO
	NUMBER: n_NUMERO_PAGO
Local Variables
	Sql Handle hSql
Actions
On Procedure Startup
	Call SqlConnect( hsql )
On Procedure Execute
	Call SqlPrepare ( hSql, 'DELETE FROM PAGOS WHERE NUMERO_PRESTAMO = :n_NUMERO_PRESTAMO AND NUMERO_PAGO = :n_NUMERO_PAGO')
	Call SqlExecute(hSql)
On Procedure Close
	Call SqlDisconnect( hSql );
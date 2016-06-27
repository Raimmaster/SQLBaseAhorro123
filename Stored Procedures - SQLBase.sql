Procedure QUANTITY_RESTORE STATIC
Parameters
	Number  nStyleId
	Number  nQuantity
Local Variables
 	Sql Handle  hSql
Actions
	On Procedure Startup
		Call SqlConnect( hSql )
	On Procedure Execute
		Call SqlPrepare( hSql, 'UPDATE INVENTORY
		SET ON_HAND_QTY = (ON_HAND_QTY + :nQuantity)
			WHERE STYLE_ID = :nStyleId' )
		Call SqlExecute(hSql)
	On Procedure Close
		Call SqlDisconnect( hSql )

------Sí funciona
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

---------------------
-----ABONOS
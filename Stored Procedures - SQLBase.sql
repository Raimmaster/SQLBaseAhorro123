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

------
STORE SP_INSERT_USUARIOS
PROCEDURE: SP_INSERT_USUARIOS static
Parameters
	STRING: vID_USER
	STRING: vUSERNAME
	STRING: vCLAVE
	DATE/Time:	FECHA_CREACION 
	DATE/Time:	FECHA_MODIFICACION
	STRING: vID_USER_CREADOR
	STRING: vID_USER_MODIFICADOR
Local Variables
	Sql Handle hSqlProc
Actions
	On Procedure Startup
		Call SqlConnect (hSqlProc)
	On Procedure Execute
		Call SqlPrepare( hSqlProc, \
			'INSERT INTO 
			USUARIOS (ID_USUARIO, USERNAME, CLAVE_USUARIO, 
			FECHA_CREACION_USU, FECHA_ACTUALIZACION_USU,
			CODIGO_USUARIO_CREADOR, CODIGO_USUARIO_ACTUALIZO)
			 VALUES (:vID_USER, :vUSERNAME, :vCLAVE, 
			:FECHA_CREACION, :FECHA_MODIFICACION, 
			:vID_USER_CREADOR, :vID_USER_MODIFICADOR);')
		Call SqlExecute(hSqlProc)
	On Procedure Close
		Call SqlDisconnect( hSqlProc );

------Sí funciona
Procedure USUARIOS_INSERT STATIC
Parameters
	STRING  n_Id_Usuario
	STRING  n_Clave
	STRING  n_Username
Local Variables
	Sql Handle  hSql
Actions
	On Procedure Startup
		Call SqlConnect( hSql )
	On Procedure Execute
		Call SqlPrepare( hSql, 'INSERT INTO USUARIOS (ID_USUARIO, USERNAME, CLAVE_USUARIO) VALUES (n_Id_Usuario, n_Username, n_Clave)' )
		Call SqlExecute( hSql )
	On Procedure Close
		Call SqlDisconnect( hSql );	
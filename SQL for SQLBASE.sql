CREATE TABLE USUARIOS
(
    ID_USUARIO              VARCHAR (50) NOT NULL,
    USERNAME                VARCHAR (50) NOT NULL,
    CLAVE_USUARIO           VARCHAR (50) NOT NULL,
    FECHA_CREACION_USU      DATE NOT NULL,
    FECHA_ACTUALIZACION_USU DATE,
    CODIGO_USUARIO_CREADOR  VARCHAR (50),    
    CODIGO_USUARIO_MODIFICADOR  VARCHAR (50),
    PRIMARY KEY (ID_USUARIO)
);

CREATE UNIQUE INDEX USUARIO_IDX ON USUARIOS(ID_USUARIO);

ALTER TABLE USUARIOS FOREIGN KEY ( CODIGO_USUARIO_CREADOR) REFERENCES USUARIOS ON DELETE CASCADE;

CREATE TABLE ABONOS
  (
    CODIGO_DE_ABONO            NUMBER (14) NOT NULL ,
    MONTO                      NUMBER (10,2) ,
    FECHA                      DATE ,
    COMENTARIO                 VARCHAR (200) ,
    NUMERO_CUENTA              NUMBER (8) NOT NULL ,
    FECHA_CREACION_ABONOS      DATE ,
    FECHA_ACTUALIZACION_ABONOS DATE ,
    CODIGO_USUARIO_CREADOR     VARCHAR (50) NOT NULL ,
    CODIGO_USUARIO_ACTUALIZO   VARCHAR (50) NOT NULL,
    PRIMARY KEY (CODIGO_DE_ABONO)  
  ) ;

CREATE UNIQUE INDEX ABONO_IDX ON ABONOS(CODIGO_DE_ABONO);


CREATE TABLE CUENTAS
  (
    NUMERO_CUENTA              NUMBER (8) NOT NULL ,
    FECHA_APERTURA             DATE ,
    SALDO_CUENTA               NUMBER (10,2) ,
    TIPO_CUENTA                VARCHAR (100) ,
    FECHA_CREACION_CUENTA      DATE ,
    FECHA_ACTUALIZACION_CUENTA DATE ,
    CODIGO_USUARIO_CREADOR     VARCHAR (50) NOT NULL ,
    CODIGO_USUARIO_ACTUALIZO   VARCHAR (50) NOT NULL,
    PRIMARY KEY (NUMERO_CUENTA)
  ) ;

CREATE UNIQUE INDEX CUENTAS_IDX ON CUENTAS(NUMERO_CUENTA);


ALTER TABLE CUENTAS ADD CONSTRAINT CUENTAS_PK PRIMARY KEY ( NUMERO_CUENTA ) ;


CREATE TABLE EMPLEADOS
  (
    CODIGO_EMPLEADO              NUMBER (8) NOT NULL ,
    PRIMER_NOMBRE                VARCHAR (20) ,
    SEGUNDO_NOMBRE               VARCHAR (20) ,
    PRIMER_APELLIDO              VARCHAR (20) ,
    SEGUNDO_APELLIDO             VARCHAR (20) ,
    DIRECCION_CALLE              VARCHAR (20) ,
    DIRECCION_AVENIDA            VARCHAR (20) ,
    DIRECCION_NUM_CASA           NUMBER (6) ,
    DIRECCION_CIUDAD             VARCHAR (30) ,
    DIRECCION_DEPARTAMENTO       VARCHAR (30) ,
    DIRECCION_REFERENCIA         VARCHAR (100) ,
    ID_USUARIO                   VARCHAR (50) ,
    EMAIL_SECUNDARIO             VARCHAR (50) ,
    CLAVE_USUARIO                VARCHAR(100),
    FECHA_NACIMIENTO             DATE ,
    FECHA_INICIO_EN_EMPRESA      DATE ,
    FECHA_CREACION_EMPLEADO      DATE ,
    FECHA_ACTUALIZACION_EMPLEADO DATE ,
    CODIGO_USUARIO_CREADOR       VARCHAR (50) ,
    CODIGO_USUARIO_ACTUALIZO     VARCHAR (50),
    PRIMARY KEY (CODIGO_EMPLEADO)
  ) ;

CREATE UNIQUE INDEX EMPLEADO_IDX ON EMPLEADOS(CODIGO_EMPLEADO);

ALTER TABLE EMPLEADOS ADD CONSTRAINT EMPLEADOS_PK PRIMARY KEY ( CODIGO_EMPLEADO ) ;


CREATE TABLE EMPLEADOS_CUENTAS
  (
    CODIGO_EMPLEADO           NUMBER (8) NOT NULL ,
    NUMERO_CUENTA            NUMBER (8) NOT NULL ,
    FECHA_CREACION_EMPC      DATE ,
    FECHA_ACTUALIZACION_EMPC DATE ,
    CODIGO_USUARIO_CREADOR   VARCHAR (50) NOT NULL ,
    CODIGO_USUARIO_ACTUALIZO VARCHAR (50) NOT NULL,
    PRIMARY KEY (CODIGO_EMPLEADO, NUMERO_CUENTA)
  ) ;

CREATE UNIQUE INDEX EMP_CUENTA_IDX ON EMPLEADOS_CUENTAS(CODIGO_EMPLEADO, NUMERO_CUENTA);

ALTER TABLE EMPLEADOS_CUENTAS ADD CONSTRAINT EMPLEADOS_CUENTAS_PK PRIMARY KEY ( CODIGO_EMPLEADO, NUMERO_CUENTA ) ;


CREATE TABLE EMPLEADOS_ROLES
  (
    CODIGO_EMPLEADO           NUMBER (8) NOT NULL ,
    ID_ROL                   NUMBER (8) NOT NULL ,
    FECHA_CREACION_ER        DATE ,
    FECHA_ACTUALIZACION_ER   DATE ,
    CODIGO_USUARIO_CREADOR   VARCHAR (50) NOT NULL ,
    CODIGO_USUARIO_ACTUALIZO VARCHAR (50) NOT NULL,
    PRIMARY KEY (CODIGO_EMPLEADO, ID_ROL)
  ) ;

CREATE UNIQUE INDEX EMP_ROL_IDX ON EMPLEADOS_ROLES(CODIGO_EMPLEADO, ID_ROL);

ALTER TABLE EMPLEADOS_ROLES ADD CONSTRAINT EMPLEADOS_ROLES_PK PRIMARY KEY ( CODIGO_EMPLEADO, ID_ROL ) ;


CREATE TABLE EMPLEADO_TELEFONOS
  (
    CODIGO_EMPLEADO          NUMBER (8) NOT NULL ,
    TELEFONO                 VARCHAR (16) NOT NULL ,
    FECHA_CREACION_ET        DATE ,
    FECHA_ACTUALIZACION_ET   DATE ,
    CODIGO_USUARIO_CREADOR   VARCHAR (50) NOT NULL ,
    CODIGO_USUARIO_ACTUALIZO VARCHAR (50) NOT NULL,
    PRIMARY KEY (CODIGO_EMPLEADO, TELEFONO)
  ) ;

CREATE UNIQUE INDEX EMP_TEL_IDX ON EMPLEADO_TELEFONOS(CODIGO_EMPLEADO, TELEFONO);

ALTER TABLE EMPLEADO_TELEFONOS ADD CONSTRAINT EMPLEADO_TELEFONOS_PK PRIMARY KEY ( CODIGO_EMPLEADO, TELEFONO ) ;


CREATE TABLE PAGOS
  (
    NUMERO_PRESTAMO          NUMBER (8) NOT NULL ,
    NUMERO_PAGO              NUMBER (8) NOT NULL ,
    FECHA_PAGO               DATE ,
    MONTO_PAGO               NUMBER (10,2) ,
    FECHA_CREACION_PAGO      DATE ,
    FECHA_ACTUALIZACION_PAGO DATE ,
    CODIGO_USUARIO_CREADOR   VARCHAR (50) NOT NULL ,
    CODIGO_USUARIO_ACTUALIZO VARCHAR (50) NOT NULL,
    PRIMARY KEY (NUMERO_PRESTAMO, NUMERO_PAGO)
  ) ;

CREATE UNIQUE INDEX PAGO_IDX ON PAGOS(NUMERO_PRESTAMO, NUMERO_PAGO);

ALTER TABLE PAGOS ADD CONSTRAINT PAGOS_PK PRIMARY KEY ( NUMERO_PAGO, NUMERO_PRESTAMO ) ;


CREATE TABLE PERSONA_EXTERNA
  (
    CODIGO_PERSONA               NUMBER (8) NOT NULL ,
    PRIMER_NOMBRE                VARCHAR (20) ,
    SEGUNDO_NOMBRE               VARCHAR (20) ,
    PRIMER_APELLIDO              VARCHAR (20) ,
    SEGUNDO_APELLIDO             VARCHAR (20) ,
    DIRECCION_CALLE              VARCHAR (20) ,
    DIRECCION_AVENIDA            VARCHAR (20) ,
    DIRECCION_NUM_CASA           NUMBER (6) ,
    DIRECCION_CIUDAD             VARCHAR (30) ,
    DIRECCION_DEPARTAMENTO       VARCHAR (30) ,
    DIRECCION_REFERENCIA         VARCHAR (100) ,
    ID_USUARIO                   VARCHAR (50) ,
    EMAIL_SECUNDARIO             VARCHAR (50) ,
    CLAVE_USUARIO                VARCHAR(100),
    FECHA_NACIMIENTO             DATE ,
    FECHA_CREACION_PERSONA       DATE ,
    FECHA_ACTUALIZACION_PERSONA  DATE ,
    CODIGO_USUARIO_CREADOR       VARCHAR (50) NOT NULL ,
    CODIGO_USUARIO_ACTUALIZACION VARCHAR (50) NOT NULL,
    PRIMARY KEY (CODIGO_PERSONA)
  ) ;

CREATE UNIQUE INDEX PERSONA_IDX ON PERSONA_EXTERNA(CODIGO_PERSONA);

ALTER TABLE PERSONA_EXTERNA ADD CONSTRAINT PERSONA_EXTERNA_PK PRIMARY KEY ( CODIGO_PERSONA ) ;


CREATE TABLE PERSONA_TELEFONOS
  (
    CODIGO_PERSONA           NUMBER (8) NOT NULL ,
    TELEFONO                 VARCHAR (16) NOT NULL ,
    FECHA_CREACION_ET        DATE ,
    FECHA_ACTUALIZACION_ET   DATE ,
    CODIGO_USUARIO_CREADOR   VARCHAR (50) NOT NULL ,
    CODIGO_USUARIO_ACTUALIZO VARCHAR (50) NOT NULL,
    PRIMARY KEY (CODIGO_PERSONA, TELEFONO)
  ) ;

CREATE UNIQUE INDEX PER_TEL_IDX ON PERSONA_TELEFONOS(CODIGO_PERSONA, TELEFONO);



CREATE TABLE PRESTAMOS
  (
    NUMERO_PRESTAMO                NUMBER (8) NOT NULL ,
    FECHA_PRESTAMO                 DATE NOT NULL ,
    MONTO_PRESTAMO                 NUMBER (10,2) NOT NULL ,
    PERIODOS                       NUMBER (2) NOT NULL ,
    SALDO                          NUMBER (10,2) NOT NULL ,
    CODIGO_EMPLEADO                NUMBER (8) NOT NULL ,
    CODIGO_PERSONA                 NUMBER (8) NOT NULL ,
    CODIGO_PERSONA_AVAL            NUMBER (8) NOT NULL ,
    PARENTESCO_AVAL                VARCHAR (100) ,
    FECHA_CREACION_PRESTAMO        DATE ,
    FECHA_ACTUALIZACION_PRESTAMO   DATE ,
    CODIGO_USUARIO_CREADOR         VARCHAR (50) NOT NULL ,
    CODIGO_USUARIO_ACTUALIZO       VARCHAR (50) NOT NULL
  ) ;

CREATE UNIQUE INDEX PRESTAMO_IDX ON PRESTAMOS(NUMERO_PRESTAMO);

ALTER TABLE PRESTAMOS ADD CONSTRAINT PRESTAMOS_PK PRIMARY KEY ( NUMERO_PRESTAMO ) ;


CREATE TABLE PRIVILEGIOS
  (
    ID_PRIVILEGIO                  NUMBER (8) NOT NULL ,
    NOMBRE_PRIVILEGIO              VARCHAR (100) ,
    FECHA_CREACION_PRIVILEGIO      DATE ,
    FECHA_ACTUALIZACION_PRIVILEGIO DATE ,
    CODIGO_USUARIO_CREADOR         VARCHAR (50) NOT NULL ,
    CODIGO_USUARIO_ACTUALIZO       VARCHAR (50) NOT NULL,
    PRIMARY KEY (ID_PRIVILEGIO)
  ) ;

CREATE UNIQUE INDEX PRIVILEGIO_IDX ON PRIVILEGIOS(ID_PRIVILEGIO);

ALTER TABLE PRIVILEGIOS ADD CONSTRAINT PRIVILEGIOS_PK PRIMARY KEY ( ID_PRIVILEGIO ) ;


CREATE TABLE ROLES
  (
    ID_ROL                   NUMBER (8) NOT NULL ,
    NOMBRE_ROL               VARCHAR (100) ,
    FECHA_CREACION_ROL       DATE ,
    FECHA_ACTUALIZACION_ROL  DATE ,
    CODIGO_USUARIO_CREADOR   VARCHAR (50) NOT NULL ,
    CODIGO_USUARIO_ACTUALIZO VARCHAR (50) NOT NULL,
    PRIMARY KEY (ID_ROL)
  ) ;


CREATE UNIQUE INDEX ROL_IDX ON ROLES(ID_ROL);

ALTER TABLE ROLES ADD CONSTRAINT ROLES_PK PRIMARY KEY ( ID_ROL ) ;


CREATE TABLE ROLES_PRIVILEGIOS
  (
    ID_PRIVILEGIO            NUMBER (8) NOT NULL ,
    ID_ROL                   NUMBER (8) NOT NULL ,
    FECHA_CREACION_RP        DATE ,
    FECHA_ACTUALIZACION_RP   DATE ,
    CODIGO_USUARIO_CREADOR   VARCHAR (50) NOT NULL ,
    CODIGO_USUARIO_ACTUALIZO VARCHAR (50) NOT NULL,
    PRIMARY KEY (ID_PRIVILEGIO, ID_ROL)
  ) ;

CREATE UNIQUE INDEX ROL_PRIV_IDX ON ROLES_PRIVILEGIOS(ID_PRIVILEGIO, ID_ROL);

ALTER TABLE ROLES_PRIVILEGIOS ADD CONSTRAINT ROLES_PRIVILEGIOS_PK PRIMARY KEY ( ID_PRIVILEGIO, ID_ROL ) ;


ALTER TABLE ABONOS ADD CONSTRAINT ABONOS_CUENTAS_FK FOREIGN KEY ( NUMERO_CUENTA ) REFERENCES CUENTAS ( NUMERO_CUENTA ) ;

ALTER TABLE ABONOS ADD CONSTRAINT ABONOS_USERA_FK FOREIGN KEY ( CODIGO_USUARIO_ACTUALIZO ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE ABONOS ADD CONSTRAINT ABONOS_USERC_FK FOREIGN KEY ( CODIGO_USUARIO_CREADOR ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE CUENTAS ADD CONSTRAINT CUENTAS_USERA_FK FOREIGN KEY ( CODIGO_USUARIO_ACTUALIZO ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE CUENTAS ADD CONSTRAINT CUENTAS_USERC_FK FOREIGN KEY ( CODIGO_USUARIO_CREADOR ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE EMPLEADOS_CUENTAS ADD CONSTRAINT EC_CUENTAS_FK FOREIGN KEY ( NUMERO_CUENTA ) REFERENCES CUENTAS ( NUMERO_CUENTA ) ;

ALTER TABLE EMPLEADOS_CUENTAS ADD CONSTRAINT EC_EMPLEADOS_FK FOREIGN KEY ( CODIGO_PERSONA ) REFERENCES EMPLEADOS ( CODIGO_PERSONA ) ;

ALTER TABLE EMPLEADOS_CUENTAS ADD CONSTRAINT EC_USERA_FK FOREIGN KEY ( CODIGO_USUARIO_ACTUALIZO ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE EMPLEADOS_CUENTAS ADD CONSTRAINT EC_USERC_FK FOREIGN KEY ( CODIGO_USUARIO_CREADOR ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE EMPLEADOS_ROLES ADD CONSTRAINT ER_EMPLEADOS_FK FOREIGN KEY ( CODIGO_EMPLEADO ) REFERENCES EMPLEADOS ( CODIGO_EMPLEADO ) ;

ALTER TABLE EMPLEADOS_ROLES ADD CONSTRAINT ER_ROLES_FK FOREIGN KEY ( ID_ROL ) REFERENCES ROLES ( ID_ROL ) ;

ALTER TABLE EMPLEADOS_ROLES ADD CONSTRAINT ER_USERA_EMPLEADOS_FK FOREIGN KEY ( CODIGO_USUARIO_ACTUALIZO ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE EMPLEADOS_ROLES ADD CONSTRAINT ER_USERC_EMPLEADOS_FK FOREIGN KEY ( CODIGO_USUARIO_CREADOR ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE EMPLEADO_TELEFONOS ADD CONSTRAINT ET_EMPLEADOS_FK FOREIGN KEY ( CODIGO_EMPLEADO ) REFERENCES EMPLEADOS ( CODIGO_EMPLEADO ) ;

ALTER TABLE EMPLEADO_TELEFONOS ADD CONSTRAINT ET_USERA_FK FOREIGN KEY ( CODIGO_USUARIO_ACTUALIZO ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE EMPLEADO_TELEFONOS ADD CONSTRAINT ET_USERC_FK FOREIGN KEY ( CODIGO_USUARIO_CREADOR ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE PAGOS ADD CONSTRAINT PAGOS_PRESTAMOS_FK FOREIGN KEY ( NUMERO_PRESTAMO ) REFERENCES PRESTAMOS ( NUMERO_PRESTAMO ) ;

ALTER TABLE PAGOS ADD CONSTRAINT PAGOS_USERA_FK FOREIGN KEY ( CODIGO_USUARIO_ACTUALIZO ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE PAGOS ADD CONSTRAINT PAGOS_USERC_FK FOREIGN KEY ( CODIGO_USUARIO_CREADOR ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE PERSONA_EXTERNA ADD CONSTRAINT PERSONA_EXTERNA_USERA_FK FOREIGN KEY ( CODIGO_USUARIO_ACTUALIZACION ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE PERSONA_EXTERNA ADD CONSTRAINT PERSONA_EXTERNA_USERC_FK FOREIGN KEY ( CODIGO_USUARIO_CREADOR ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE PRESTAMOS ADD CONSTRAINT PRESTAMOS_EMPLEADOS_FK FOREIGN KEY ( CODIGO_EMPLEADO ) REFERENCES EMPLEADOS ( CODIGO_EMPLEADO ) ;

ALTER TABLE PRESTAMOS ADD CONSTRAINT PRESTAMOS_EMPLEADOS_FKv1 FOREIGN KEY ( CODIGO_PERSONA_AVAL ) REFERENCES EMPLEADOS ( CODIGO_EMPLEADO ) ;

ALTER TABLE PRESTAMOS ADD CONSTRAINT PRESTAMOS_PERSONA_EXTERNA_FK FOREIGN KEY ( CODIGO_PERSONA ) REFERENCES PERSONA_EXTERNA ( CODIGO_PERSONA ) ;

ALTER TABLE PRESTAMOS ADD CONSTRAINT PRESTAMOS_USERA_FK FOREIGN KEY ( CODIGO_USUARIO_ACTUALIZO ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE PRESTAMOS ADD CONSTRAINT PRESTAMOS_USERC_FK FOREIGN KEY ( CODIGO_USUARIO_CREADOR ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE PRIVILEGIOS ADD CONSTRAINT PRIVILEGIOS_USERA_FK FOREIGN KEY ( CODIGO_USUARIO_ACTUALIZO ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE PRIVILEGIOS ADD CONSTRAINT PRIVILEGIOS_USERC_FK FOREIGN KEY ( CODIGO_USUARIO_CREADOR ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE ROLES ADD CONSTRAINT ROLES_USERC_FK FOREIGN KEY ( CODIGO_USUARIO_CREADOR ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE ROLES ADD CONSTRAINT ROLES_USER_FK FOREIGN KEY ( CODIGO_USUARIO_ACTUALIZO ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE ROLES_PRIVILEGIOS ADD CONSTRAINT RP_PRIVILEGIOS_FK FOREIGN KEY ( ID_PRIVILEGIO ) REFERENCES PRIVILEGIOS ( ID_PRIVILEGIO ) ;

ALTER TABLE ROLES_PRIVILEGIOS ADD CONSTRAINT RP_ROLES_FK FOREIGN KEY ( ID_ROL ) REFERENCES ROLES ( ID_ROL ) ;

ALTER TABLE ROLES_PRIVILEGIOS ADD CONSTRAINT RP_USERA_FK FOREIGN KEY ( CODIGO_USUARIO_ACTUALIZO ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE ROLES_PRIVILEGIOS ADD CONSTRAINT RP_USERC_FK FOREIGN KEY ( CODIGO_USUARIO_CREADOR ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE EMPLEADOS ADD CONSTRAINT USERA_EMPLEADOS_FK FOREIGN KEY ( CODIGO_USUARIO_ACTUALIZO ) REFERENCES USUARIOS ( ID_USUARIO ) ;

ALTER TABLE EMPLEADOS ADD CONSTRAINT USERC_EMPLEADOS_FK FOREIGN KEY ( CODIGO_USUARIO_CREADOR ) REFERENCES USUARIOS ( ID_USUARIO ) ;
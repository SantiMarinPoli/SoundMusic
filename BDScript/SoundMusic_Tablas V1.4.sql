CREATE TABLE PAIS
(
    ID_PAIS INTEGER NOT NULL,
    NOMBRE VARCHAR2(50) NOT NULL,
    PRIMARY KEY (ID_PAIS)
);

CREATE TABLE CIUDAD
(
    ID_CIUDAD INTEGER NOT NULL,
    NOMBRE VARCHAR2 (100) NOT NULL,
    ID_PAIS INTEGER NOT NULL,
    PRIMARY KEY (ID_CIUDAD),
    FOREIGN KEY (ID_PAIS) REFERENCES PAIS(ID_PAIS)
);

CREATE TABLE PERMISO
(
    ID_PERMISO INTEGER NOT NULL,
    NOMBRE_PERMISO VARCHAR2(30) NOT NULL,    
    PRIMARY KEY (ID_PERMISO)
);

CREATE TABLE TIPO_ACTIVIDAD
(
    ID_TIPO_ACTIVIDAD INTEGER NOT NULL,
    NOMBRE VARCHAR2(100) NOT NULL,    
    PRIMARY KEY (ID_TIPO_ACTIVIDAD)
);

CREATE TABLE COSTO_ACTIVITIDAD
(
    ID_COSTO_ACTIVIDAD INTEGER NOT NULL,
    COSTO_POR_OPERACION FLOAT NOT NULL,
    FECHA_CREACION DATE NOT NULL,
    FECHA_USO_FINAL DATE,    
    PRIMARY KEY (ID_COSTO_ACTIVIDAD)
);

CREATE TABLE PERFIL
(
    ID_PERFIL INTEGER NOT NULL,
    NOMBRE_PERFIL VARCHAR2(30) NOT NULL,    
    PRIMARY KEY (ID_PERFIL)
);

CREATE TABLE PERFIL_PERMISO
(
    ID_PERFIL_PERMISO INTEGER NOT NULL,
    ID_PERFIL INTEGER NOT NULL, 
    ID_PERMISO INTEGER NOT NULL,
    PRIMARY KEY (ID_PERFIL_PERMISO),
    FOREIGN KEY (ID_PERFIL) REFERENCES PERFIL(ID_PERFIL),
    FOREIGN KEY (ID_PERMISO) REFERENCES PERMISO(ID_PERMISO)
);

CREATE TABLE USUARIO_LOGIN
(
    ID_USUARIO_LOGIN INTEGER NOT NULL,
    NOMBRE_USUARIO VARCHAR2(30) NOT NULL,
    CONTRASENA VARCHAR2 (70) NOT NULL,
    PRIMARY KEY (ID_USUARIO_LOGIN)
);


CREATE TABLE LOGRO
(
    ID_LOGRO INTEGER NOT NULL,
    NOMBRE VARCHAR2 (70) NOT NULL,
    CRITERIO VARCHAR2(200),
    CANTIDAD_CRITERIO FLOAT NOT NULL,
    FECHA_CREACION DATE NOT NULL,
    FECHA_FINAL DATE,
    PREMIO FLOAT NOT NULL,
    PRIMARY KEY (ID_LOGRO)
);

CREATE TABLE CONTACTO
(
    ID_CONTACTO INTEGER NOT NULL,
    CELULAR VARCHAR2(20) NOT NULL,
    TELEFONO VARCHAR2(20),
    DIRECCION VARCHAR2(400),
    BARRIO VARCHAR2(200),    
    EMAIL VARCHAR2(100),
    ID_CIUDAD INTEGER NOT NULL,
    PRIMARY KEY (ID_CONTACTO),
    FOREIGN KEY (ID_CIUDAD) REFERENCES CIUDAD(ID_CIUDAD)
);



CREATE TABLE ARTISTA
(
    ID_ARTISTA INTEGER NOT NULL,
    PRIMER_NOMBRE VARCHAR2(30) NOT NULL,
    SEGUNDO_NOMBRE VARCHAR2(30),
    PRIMER_APELLIDO VARCHAR2(30) NOT NULL,
    SEGUNDO_APELLIDO VARCHAR2(30),
    NOMBRE_ARTISTICO VARCHAR2(50) NOT NULL,
    GENERO CHAR(1),    
    FECHA_NACIMIENTO DATE,
    FECHA_CREACION DATE NOT NULL,
    STATUS CHAR(1) NOT NULL,
    RUTA_IMAGEN VARCHAR2(200),
    ID_CONTACTO INTEGER NOT NULL,
    PRIMARY KEY (ID_ARTISTA),
    FOREIGN KEY (ID_CONTACTO) REFERENCES CONTACTO (ID_CONTACTO)    
);

CREATE TABLE ALBUM
(
    ID_ALBUM INTEGER NOT NULL,
    NOMBRE VARCHAR2(50) NOT NULL,
    NUMERO_CANCIONES INTEGER NOT NULL,
    FECHA_FINALIZACION DATE,
    RUTA_IMAGEN VARCHAR2(200),
    ID_CIUDAD INTEGER NOT NULL,
    ID_ARTISTA INTEGER NOT NULL,
    PRIMARY KEY (ID_ALBUM),
    FOREIGN KEY (ID_CIUDAD) REFERENCES CIUDAD(ID_CIUDAD),
    FOREIGN KEY (ID_ARTISTA) REFERENCES ARTISTA(ID_ARTISTA)
);

CREATE TABLE LOGRO_ARTISTA
(
    ID_LOGRO_ARTISTA INTEGER NOT NULL,
    ID_LOGRO INTEGER NOT NULL,
    ID_ARTISTA INTEGER NOT NULL,
    FECHA_PREMIACION DATE NOT NULL,
    PRIMARY KEY (ID_LOGRO_ARTISTA),
    FOREIGN KEY (ID_LOGRO) REFERENCES LOGRO(ID_LOGRO),
    FOREIGN KEY(ID_ARTISTA) REFERENCES ARTISTA(ID_ARTISTA)
);

CREATE TABLE EMPRESA_DIFUSORA
(
    ID_EMPRESA_DIFUSORA INTEGER NOT NULL,
    NOMBRE VARCHAR2(80) NOT NULL,
    FECHA_CREACION DATE NOT NULL,
    FECHA_TERMINACION DATE,
    STATUS CHAR(1) NOT NULL,
    ID_TIPO_ACTIVIDAD INTEGER NOT NULL,
    ID_CONTACTO INTEGER NOT NULL,
    ID_COSTO_ACTIVIDAD INTEGER NOT NULL,
    PRIMARY KEY (ID_EMPRESA_DIFUSORA),
    FOREIGN KEY (ID_TIPO_ACTIVIDAD) REFERENCES TIPO_ACTIVIDAD(ID_TIPO_ACTIVIDAD),
    FOREIGN KEY (ID_CONTACTO) REFERENCES CONTACTO(ID_CONTACTO),
    FOREIGN KEY (ID_COSTO_ACTIVIDAD) REFERENCES COSTO_ACTIVITIDAD (ID_COSTO_ACTIVIDAD)
);

CREATE TABLE ARTISTA_EMPRESA
(
    ID_ARTISTA_EMPRESA INTEGER NOT NULL,
    ID_ARTISTA INTEGER NOT NULL,
    ID_EMPRESA_DIFUSORA INTEGER NULL,
    PRIMARY KEY(ID_ARTISTA_EMPRESA),
    FOREIGN KEY(ID_ARTISTA) REFERENCES ARTISTA(ID_ARTISTA),
    FOREIGN KEY(ID_EMPRESA_DIFUSORA) REFERENCES EMPRESA_DIFUSORA(ID_EMPRESA_DIFUSORA)
);

CREATE TABLE USUARIO
(
    ID_USUARIO INTEGER NOT NULL,
    PRIMER_NOMBRE VARCHAR2(30) NOT NULL,
    SEGUNDO_NOMBRE VARCHAR2(30),
    PRIMER_APELLIDO VARCHAR2(30) NOT NULL,
    SEGUNDO_APELLIDO VARCHAR2(30),
    FECHA_CREACION DATE NOT NULL,
    STATUS CHAR(1) NOT NULL,
    GENERO CHAR(1),
    ID_PERFIL INTEGER NOT NULL,
    ID_USUARIO_LOGIN INTEGER NOT NULL,
    ID_CONTACTO INTEGER NOT NULL,
    PRIMARY KEY (ID_USUARIO),
    FOREIGN KEY(ID_PERFIL) REFERENCES PERFIL(ID_PERFIL),
    FOREIGN KEY (ID_USUARIO_LOGIN) REFERENCES USUARIO_LOGIN (ID_USUARIO_LOGIN),
    FOREIGN KEY (ID_CONTACTO) REFERENCES CONTACTO(ID_CONTACTO)
);

CREATE TABLE LOG_AUDITORIA
(
    ID_LOG_AUDITORIA INTEGER NOT NULL,
    FECHA TIMESTAMP(0) NOT NULL,    
    ID_USUARIO INTEGER NOT NULL,
    ID_OPERACION INTEGER NOT NULL,
    PRIMARY KEY (ID_LOG_AUDITORIA),
    FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID_USUARIO),
    FOREIGN KEY (ID_OPERACION) REFERENCES PERMISO(ID_PERMISO)
);

CREATE TABLE REGALIA
(
    ID_REGALIA INTEGER NOT NULL,
    TOTAL_GANADO FLOAT NOT NULL,
    NUMERO_OPERACIONES INTEGER NOT NULL,
    FECHA TIMESTAMP(0) NOT NULL,
    ID_ARTISTA_EMPRESA INTEGER NOT NULL,
    ID_COSTO INTEGER NOT NULL,    
    PRIMARY KEY (ID_REGALIA),
    FOREIGN KEY (ID_ARTISTA_EMPRESA) REFERENCES ARTISTA_EMPRESA (ID_ARTISTA_EMPRESA),
    FOREIGN KEY (ID_COSTO) REFERENCES COSTO_ACTIVITIDAD (ID_COSTO_ACTIVIDAD)
);

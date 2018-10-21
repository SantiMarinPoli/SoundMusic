---------------------PAIS-----------------------------
INSERT INTO PAIS (NOMBRE) VALUES ('COLOMBIA');
INSERT INTO PAIS (NOMBRE) VALUES ('EEUU');

---------------------CIUDAD-----------------------------
INSERT INTO CIUDAD (NOMBRE, ID_PAIS) VALUES ('MEDELLIN', 1);
INSERT INTO CIUDAD (NOMBRE, ID_PAIS) VALUES ('BOGOTA', 1);
INSERT INTO CIUDAD (NOMBRE, ID_PAIS) VALUES ('MIAMI', 2);

---------------------CONTACTO-----------------------------
INSERT INTO CONTACTO (CELULAR, TELEFONO, DIRECCION,BARRIO,EMAIL, ID_CIUDAD) 
VALUES ('3164349117','5836395','MI CASA','MI BARRIO','SANMEDI@45.COM',1);
INSERT INTO CONTACTO (CELULAR, TELEFONO, DIRECCION,BARRIO,EMAIL, ID_CIUDAD) 
VALUES ('454821','122587','MI CASA','MI BARRIO','MELMOL@45.COM',3);

INSERT INTO CONTACTO (CELULAR, ID_CIUDAD)
VALUES ('31245784', 1);

---------------------PERFIL-----------------------------
INSERT INTO PERFIL (NOMBRE_PERFIL)
VALUES ('ADMINISTRADOR');
INSERT INTO PERFIL (NOMBRE_PERFIL)
VALUES ('OPERARIO');

---------------------PERMISOS-----------------------------
INSERT INTO PERMISO (NOMBRE_PERMISO)
VALUES ('INICIAR SESION');
INSERT INTO PERMISO (NOMBRE_PERMISO)
VALUES ('CERRAR SESION');
INSERT INTO PERMISO (NOMBRE_PERMISO)
VALUES ('CREAR ARTISTA');
INSERT INTO PERMISO (NOMBRE_PERMISO)
VALUES ('CREAR EMPRESA');
INSERT INTO PERMISO (NOMBRE_PERMISO)
VALUES ('CREAR USUARIO');

---------------------USUARIO LOGIN-----------------------------
INSERT INTO USUARIO_LOGIN (NOMBRE_USUARIO, CONTRASENA)
VALUES ('SANMEDI','SANMEDI');
INSERT INTO USUARIO_LOGIN (NOMBRE_USUARIO, CONTRASENA)
VALUES ('SANMEDI27','SANMEDI27');

---------------------USUARIO-----------------------------
INSERT INTO USUARIO (PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,
FECHA_CREACION, STATUS, GENERO, ID_PERFIL, ID_USUARIO_LOGIN, ID_CONTACTO)
VALUES ('SANTIAGO','','MEDINA','PELAEZ',to_date('2018/06/01','yyyy/mm/dd'),'A','M',1,1,1);
INSERT INTO USUARIO (PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,
FECHA_CREACION, STATUS, GENERO, ID_PERFIL, ID_USUARIO_LOGIN, ID_CONTACTO)
VALUES ('MELANY','','PALACIOS','FONEGRA',to_date('2018/06/01','yyyy/mm/dd'),'A','F',1,2,2);
INSERT INTO USUARIO (PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,
FECHA_CREACION, STATUS, GENERO, ID_PERFIL, ID_USUARIO_LOGIN, ID_CONTACTO)
VALUES ('SANTIAGO','','CORTES','MARIN',to_date('2018/06/01','yyyy/mm/dd'),'A','M',1,2,2);

---------------------ARTISTA-----------------------------
INSERT INTO ARTISTA (PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,
NOMBRE_ARTISTICO,GENERO,FECHA_NACIMIENTO,FECHA_CREACION,STATUS,ID_CONTACTO) 
VALUES ('SANTIAGO','','MEDINA','PELAEZ','MC DINA','M',to_date('1992/06/01','yyyy/mm/dd'),to_date('2018/09/23','yyyy/mm/dd'),'A',1);
INSERT INTO ARTISTA (PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,
NOMBRE_ARTISTICO,GENERO,FECHA_NACIMIENTO,FECHA_CREACION,STATUS,ID_CONTACTO) 
VALUES ('SANTIAGO', null, 'MEDINA', 'PELAEZ', 'MC DINA', 'M',to_date('1992/06/01','yyyy/mm/dd'),to_date('2018/09/23','yyyy/mm/dd'),'A',1);

---------------------TIPO_ACTIVIDAD-----------------------------
INSERT INTO TIPO_ACTIVIDAD(NOMBRE)
VALUES('VIDEOS');
INSERT INTO TIPO_ACTIVIDAD(NOMBRE)
VALUES('DESCARGAS');
INSERT INTO TIPO_ACTIVIDAD(NOMBRE)
VALUES('RINGTONES');
INSERT INTO TIPO_ACTIVIDAD(NOMBRE)
VALUES('VENTA CDS');

---------------------COSTO_ACTIVIDAD-----------------------------
INSERT INTO COSTO_ACTIVITIDAD(COSTO_POR_OPERACION,FECHA_CREACION)
VALUES(5.0,to_date('2018/09/23','yyyy/mm/dd'));
INSERT INTO COSTO_ACTIVITIDAD(COSTO_POR_OPERACION,FECHA_CREACION)
VALUES(1,to_date('2018/09/23','yyyy/mm/dd'));
INSERT INTO COSTO_ACTIVITIDAD(COSTO_POR_OPERACION,FECHA_CREACION)
VALUES(10,to_date('2018/09/23','yyyy/mm/dd'));

---------------------EMPRESA DIFUSORA-----------------------------
INSERT INTO EMPRESA_DIFUSORA(NOMBRE, FECHA_CREACION, STATUS,ID_TIPO_ACTIVIDAD,ID_CONTACTO,ID_COSTO_ACTIVIDAD)
VALUES ('YOUTUBE',to_date('2018/06/01','yyyy/mm/dd'),'A',1,3,1);
INSERT INTO EMPRESA_DIFUSORA(NOMBRE, FECHA_CREACION, STATUS,ID_TIPO_ACTIVIDAD,ID_CONTACTO,ID_COSTO_ACTIVIDAD)
VALUES ('ITUNES',to_date('2018/06/01','yyyy/mm/dd'),'A',2,3,2);
INSERT INTO EMPRESA_DIFUSORA(NOMBRE, FECHA_CREACION, STATUS,ID_TIPO_ACTIVIDAD,ID_CONTACTO,ID_COSTO_ACTIVIDAD)
VALUES ('SPOTIFY',to_date('2018/06/01','yyyy/mm/dd'),'A',2,3,3);

---------------------ARTISTA_EMPRESA-----------------------------
INSERT INTO ARTISTA_EMPRESA(ID_ARTISTA,ID_EMPRESA_DIFUSORA)
VALUES (1,1);
INSERT INTO ARTISTA_EMPRESA(ID_ARTISTA,ID_EMPRESA_DIFUSORA)
VALUES (1,2);
INSERT INTO ARTISTA_EMPRESA(ID_ARTISTA,ID_EMPRESA_DIFUSORA)
VALUES (2,1);
INSERT INTO ARTISTA_EMPRESA(ID_ARTISTA,ID_EMPRESA_DIFUSORA)
VALUES (2,2);
INSERT INTO ARTISTA_EMPRESA(ID_ARTISTA,ID_EMPRESA_DIFUSORA)
VALUES (2,3);

-- Copyright (c) 2010 Lorenzo Carbonell
-- email: lorenzo.carbonell.cerezo@gmail.com
-- website: http://www.atareao.es
--
-- This program is free software: you can redistribute it and/or modify
-- it under the terms of the GNU General Public License as published by
-- the Free Software Foundation, version 3 of the License.
--
-- This program is distributed in the hope that it will be useful,
-- but WITHOUT ANY WARRANTY; without even the implied warranty of
-- MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
-- GNU General Public License for more details.
-- You should have received a copy of the GNU General Public License
-- along with this program.  If not, see <http://www.gnu.org/licenses/>.
-- ******************************************************************************************
-- CREATE USER
-- ******************************************************************************************
CREATE USER IF NOT EXISTS SA SALT '44eb6499dfe9d43e' HASH 'e39200b44d19be587e83a7692e66955e792a00eda630bb6ae6f3d3b254531edc' ADMIN;
-- ******************************************************************************************
-- CREATE TABLE
-- ******************************************************************************************
DROP TABLE IF EXISTS UNIDAD;
CREATE CACHED TABLE UNIDAD(
    ID IDENTITY NOT NULL PRIMARY KEY,
    ORDEN INTEGER NOT NULL AUTO_INCREMENT,
    SIMBOLO VARCHAR NOT NULL,
    DESCRIPCION VARCHAR NOT NULL,
    FECHA TIMESTAMP NOT NULL DEFAULT NOW()
);
ALTER TABLE UNIDAD ADD CONSTRAINT UK_UNIDAD_SIMBOLO UNIQUE (SIMBOLO);
ALTER TABLE UNIDAD ADD CONSTRAINT UK_UNIDAD_DESCRIPCION UNIQUE (DESCRIPCION);
--
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (1,1,'a','área');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (2,2,'cm2','centímetro cuadrado');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (3,3,'cm3','centímetro cúbico');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (4,4,'cu','cien unidades');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (5,5,'dm3','decímetro cúbico');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (6,6,'d','día');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (7,7,'h','hora');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (8,8,'ha','hectárea');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (9,9,'kg','kilogramo');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (10,10,'km','kilómetro');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (11,11,'l','litro');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (12,12,'mes','mes');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (13,13,'m','metro');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (14,14,'m2','metro cuadrado');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (15,15,'m3','metro cúbico');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (16,16,'mu','mil unidades');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (17,17,'t','tonelada');
INSERT INTO UNIDAD(ID, ORDEN, SIMBOLO, DESCRIPCION) VALUES (18,18,'u','unidad');
-- ******************************************************************************************
-- CREATE TABLE
-- ******************************************************************************************
DROP TABLE IF EXISTS TIPO;
CREATE CACHED TABLE TIPO(
    ID IDENTITY NOT NULL PRIMARY KEY,
    ORDEN INTEGER NOT NULL AUTO_INCREMENT,
    TIPO VARCHAR NOT NULL,
    DESCRIPCION VARCHAR NOT NULL,
    URL VARCHAR NOT NULL,
    FECHA TIMESTAMP NOT NULL DEFAULT NOW()
);
ALTER TABLE TIPO ADD CONSTRAINT UK_TIPO_TIPO UNIQUE (TIPO);
ALTER TABLE TIPO ADD CONSTRAINT UK_TIPO_DESCRIPCION UNIQUE (DESCRIPCION);
--
INSERT INTO TIPO(ID, ORDEN, TIPO, DESCRIPCION, URL) VALUES (1,1,'O', 'Mano de obra (elemento básico)','/es/atareao/metron/img/ic_manodeobra.png');
INSERT INTO TIPO(ID, ORDEN, TIPO, DESCRIPCION, URL) VALUES (2,2,'Q', 'Maquinaria (elemento básico)','/es/atareao/metron/img/ic_maquinaria.png');
INSERT INTO TIPO(ID, ORDEN, TIPO, DESCRIPCION, URL) VALUES (3,3,'T', 'Materiales (elemento básico)','/es/atareao/metron/img/ic_materiales.png');
INSERT INTO TIPO(ID, ORDEN, TIPO, DESCRIPCION, URL) VALUES (4,4,'%', 'Medios auxiliares (elemento básico)','/es/atareao/metron/img/ic_auxiliares.png');
INSERT INTO TIPO(ID, ORDEN, TIPO, DESCRIPCION, URL) VALUES (5,5,'R', 'Obra','/es/atareao/metron/img/ic_icono.png');
INSERT INTO TIPO(ID, ORDEN, TIPO, DESCRIPCION, URL) VALUES (6,6,'C', 'Capítulo','/es/atareao/metron/img/ic_capitulo.png');
INSERT INTO TIPO(ID, ORDEN, TIPO, DESCRIPCION, URL) VALUES (7,7,'P', 'Partida (elemento unitario)','/es/atareao/metron/img/ic_partida.png');
INSERT INTO TIPO(ID, ORDEN, TIPO, DESCRIPCION, URL) VALUES (8,8,'A', 'Partida alzada sin descomposición (elemento unitario)','/es/atareao/metron/img/ic_partida_alzada.png');
INSERT INTO TIPO(ID, ORDEN, TIPO, DESCRIPCION, URL) VALUES (9,9,'X', 'Partida auxiliar (elemento auxiliar)','/es/atareao/metron/img/ic_partida_auxiliar.png');
-- ******************************************************************************************
-- CREATE TABLE
-- ******************************************************************************************
DROP TABLE IF EXISTS CUADRO;
CREATE CACHED TABLE CUADRO(
    ID IDENTITY NOT NULL PRIMARY KEY,
    ORDEN INTEGER NOT NULL AUTO_INCREMENT,
    DESCRIPCION VARCHAR NOT NULL,
    FECHA TIMESTAMP NOT NULL DEFAULT NOW()
);
ALTER TABLE CUADRO ADD CONSTRAINT UK_CUADRO_DESCRIPCION UNIQUE (DESCRIPCION);
--
INSERT INTO CUADRO(ID,ORDEN, DESCRIPCION) VALUES (1,1,'Presupuesto');
INSERT INTO CUADRO(ID,ORDEN, DESCRIPCION) VALUES (2,2,'Certificación');
INSERT INTO CUADRO(ID,ORDEN, DESCRIPCION) VALUES (3,3,'Coste');
-- ******************************************************************************************
-- CREATE TABLE
-- ******************************************************************************************
DROP TABLE IF EXISTS CONCEPTO;
CREATE CACHED TABLE CONCEPTO(
    ID IDENTITY NOT NULL PRIMARY KEY,
    ORDEN INTEGER NOT NULL AUTO_INCREMENT,
    CODIGO VARCHAR NOT NULL,
    DESCRIPCION VARCHAR NOT NULL,
    UNIDAD_ID BIGINT NOT NULL DEFAULT 18,
    TIPO_ID BIGINT NOT NULL DEFAULT 6,
    FECHA TIMESTAMP NOT NULL DEFAULT NOW()
);
ALTER TABLE CONCEPTO ADD CONSTRAINT UK_CONCEPTO_CODIGO UNIQUE (CODIGO);
ALTER TABLE CONCEPTO ADD CONSTRAINT UK_CONCEPTO_DESCRIPCION UNIQUE (DESCRIPCION);
ALTER TABLE CONCEPTO ADD CONSTRAINT FK_CONCEPTO_UNIDAD_ID FOREIGN KEY(UNIDAD_ID) REFERENCES UNIDAD(ID) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE CONCEPTO ADD CONSTRAINT FK_CONCEPTO_TIPO_ID FOREIGN KEY(TIPO_ID) REFERENCES TIPO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
--
INSERT INTO CONCEPTO(ID,ORDEN,CODIGO,DESCRIPCION,UNIDAD_ID,TIPO_ID) VALUES (1,1,'##','Obra',18,5);
-- ******************************************************************************************
-- CREATE TABLE
-- ******************************************************************************************
DROP TABLE IF EXISTS PRECIO;
CREATE CACHED TABLE PRECIO(
    ID IDENTITY NOT NULL PRIMARY KEY,
    ORDEN INTEGER NOT NULL AUTO_INCREMENT,
    CODIGO VARCHAR NOT NULL,
    CONCEPTO_ID BIGINT NOT NULL DEFAULT 1,
    CUADRO_ID BIGINT NOT NULL DEFAULT 1,
    PRECIO FLOAT NOT NULL DEFAULT 0.0,
    FECHA TIMESTAMP NOT NULL DEFAULT NOW()
);
ALTER TABLE PRECIO ADD CONSTRAINT UK_PRECIO_CODIGO_CUADRO_ID UNIQUE (CODIGO,CUADRO_ID);
ALTER TABLE PRECIO ADD CONSTRAINT UK_PRECIO_CONCEPTO_ID_CUADRO_ID UNIQUE (CONCEPTO_ID,CUADRO_ID);
ALTER TABLE PRECIO ADD CONSTRAINT FK_PRECIO_CONCEPTO_ID FOREIGN KEY(CONCEPTO_ID) REFERENCES CONCEPTO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE PRECIO ADD CONSTRAINT FK_PRECIO_CUADRO_ID FOREIGN KEY(CUADRO_ID) REFERENCES CUADRO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
--
INSERT INTO PRECIO(ID,ORDEN,CODIGO,CONCEPTO_ID,CUADRO_ID,PRECIO) VALUES (1,1,'##',1,1,0.0);
INSERT INTO PRECIO(ID,ORDEN,CODIGO,CONCEPTO_ID,CUADRO_ID,PRECIO) VALUES (2,2,'##',1,2,0.0);
INSERT INTO PRECIO(ID,ORDEN,CODIGO,CONCEPTO_ID,CUADRO_ID,PRECIO) VALUES (3,3,'##',1,3,0.0);
-- ******************************************************************************************
-- CREATE TABLE
-- ******************************************************************************************
DROP TABLE IF EXISTS TEXTO;
CREATE CACHED TABLE TEXTO(
    ID IDENTITY NOT NULL PRIMARY KEY,
    ORDEN INTEGER NOT NULL AUTO_INCREMENT,
    DESCRIPCION VARCHAR NOT NULL,
    CONCEPTO_ID BIGINT NOT NULL DEFAULT 1,
    CUADRO_ID BIGINT NOT NULL DEFAULT 1,
    FECHA TIMESTAMP NOT NULL DEFAULT NOW()
);
ALTER TABLE TEXTO ADD CONSTRAINT UK_TEXTO_CONCEPTO_ID_CUADRO_ID UNIQUE (CONCEPTO_ID,CUADRO_ID);
ALTER TABLE TEXTO ADD CONSTRAINT FK_TEXTO_CONCEPTO_ID FOREIGN KEY(CONCEPTO_ID) REFERENCES CONCEPTO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE TEXTO ADD CONSTRAINT FK_TEXTO_CUADRO_ID FOREIGN KEY(CUADRO_ID) REFERENCES CUADRO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
--
INSERT INTO TEXTO(ID,ORDEN,DESCRIPCION,CONCEPTO_ID,CUADRO_ID) VALUES (1,1,'Obra',1,1);
INSERT INTO TEXTO(ID,ORDEN,DESCRIPCION,CONCEPTO_ID,CUADRO_ID) VALUES (2,2,'Obra',1,2);
INSERT INTO TEXTO(ID,ORDEN,DESCRIPCION,CONCEPTO_ID,CUADRO_ID) VALUES (3,3,'Obra',1,3);
-- ******************************************************************************************
-- CREATE TABLE
-- ******************************************************************************************
DROP TABLE IF EXISTS PLIEGO;
CREATE CACHED TABLE PLIEGO(
    ID IDENTITY NOT NULL PRIMARY KEY,
    ORDEN INTEGER NOT NULL AUTO_INCREMENT,
    DESCRIPCION VARCHAR NOT NULL,
    CONCEPTO_ID BIGINT NOT NULL DEFAULT 1,
    CUADRO_ID BIGINT NOT NULL DEFAULT 1,
    FECHA TIMESTAMP NOT NULL DEFAULT NOW()
);
ALTER TABLE PLIEGO ADD CONSTRAINT UK_PLIEGO_CONCEPTO_ID_CUADRO_ID UNIQUE (CONCEPTO_ID,CUADRO_ID);
ALTER TABLE PLIEGO ADD CONSTRAINT FK_PLIEGO_CONCEPTO_ID FOREIGN KEY(CONCEPTO_ID) REFERENCES CONCEPTO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE PLIEGO ADD CONSTRAINT FK_PLIEGO_CUADRO_ID FOREIGN KEY(CUADRO_ID) REFERENCES CUADRO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
--
INSERT INTO PLIEGO(ID,ORDEN,DESCRIPCION,CONCEPTO_ID,CUADRO_ID) VALUES (1,1,'Obra',1,1);
INSERT INTO PLIEGO(ID,ORDEN,DESCRIPCION,CONCEPTO_ID,CUADRO_ID) VALUES (2,2,'Obra',1,2);
INSERT INTO PLIEGO(ID,ORDEN,DESCRIPCION,CONCEPTO_ID,CUADRO_ID) VALUES (3,3,'Obra',1,3);
-- ******************************************************************************************
-- CREATE TABLE
-- ******************************************************************************************
DROP TABLE IF EXISTS IMAGEN;
CREATE CACHED TABLE IMAGEN(
    ID IDENTITY NOT NULL PRIMARY KEY,
    ORDEN INTEGER NOT NULL AUTO_INCREMENT,
    URI VARCHAR NOT NULL,
    DESCRIPCION VARCHAR NOT NULL,
    CONCEPTO_ID BIGINT NOT NULL DEFAULT 1,
    CUADRO_ID BIGINT NOT NULL DEFAULT 1,
    FECHA TIMESTAMP NOT NULL DEFAULT NOW()
);
ALTER TABLE IMAGEN ADD CONSTRAINT UK_IMAGEN_CONCEPTO_ID_CUADRO_ID UNIQUE (CONCEPTO_ID,CUADRO_ID);
ALTER TABLE IMAGEN ADD CONSTRAINT FK_IMAGEN_CONCEPTO_ID FOREIGN KEY(CONCEPTO_ID) REFERENCES CONCEPTO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE IMAGEN ADD CONSTRAINT FK_IMAGEN_CUADRO_ID FOREIGN KEY(CUADRO_ID) REFERENCES CUADRO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
-- ******************************************************************************************
-- CREATE TABLE
-- ******************************************************************************************
DROP TABLE IF EXISTS ADJUNTO;
CREATE CACHED TABLE ADJUNTO(
    ID IDENTITY NOT NULL PRIMARY KEY,
    ORDEN INTEGER NOT NULL AUTO_INCREMENT,
    URI VARCHAR NOT NULL,
    DESCRIPCION VARCHAR NOT NULL,
    CONCEPTO_ID BIGINT NOT NULL DEFAULT 1,
    CUADRO_ID BIGINT NOT NULL DEFAULT 1,
    FECHA TIMESTAMP NOT NULL DEFAULT NOW()
);
ALTER TABLE ADJUNTO ADD CONSTRAINT UK_ADJUNTO_CONCEPTO_ID_CUADRO_ID UNIQUE (CONCEPTO_ID,CUADRO_ID);
ALTER TABLE ADJUNTO ADD CONSTRAINT FK_ADJUNTO_CONCEPTO_ID FOREIGN KEY(CONCEPTO_ID) REFERENCES CONCEPTO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE ADJUNTO ADD CONSTRAINT FK_ADJUNTO_CUADRO_ID FOREIGN KEY(CUADRO_ID) REFERENCES CUADRO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
-- ******************************************************************************************
-- CREATE TABLE
-- ******************************************************************************************
DROP TABLE IF EXISTS FASE;
CREATE CACHED TABLE FASE(
    ID IDENTITY NOT NULL PRIMARY KEY,
    ORDEN INTEGER NOT NULL AUTO_INCREMENT,
    NUMERO INTEGER NOT NULL DEFAULT 1,
    DESCRIPCION VARCHAR NOT NULL,
    CUADRO_ID BIGINT NOT NULL DEFAULT 1,
    FECHA TIMESTAMP NOT NULL DEFAULT NOW(),
    APROBADA BOOLEAN NOT NULL DEFAULT FALSE,
    FECHA_APROBADA TIMESTAMP NOT NULL DEFAULT NOW()
);
ALTER TABLE FASE ADD CONSTRAINT UK_FASE_NUMERO_CUADRO_ID UNIQUE (NUMERO,CUADRO_ID);
ALTER TABLE FASE ADD CONSTRAINT UK_FASE_FECHA_CUADRO_ID UNIQUE (FECHA,CUADRO_ID);
ALTER TABLE FASE ADD CONSTRAINT FK_FASE_CUADRO_ID FOREIGN KEY(CUADRO_ID) REFERENCES CUADRO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
--
INSERT INTO FASE(ID,ORDEN,NUMERO,DESCRIPCION,CUADRO_ID) VALUES (1,1,1,'Inicio',1);
INSERT INTO FASE(ID,ORDEN,NUMERO,DESCRIPCION,CUADRO_ID) VALUES (2,2,1,'Inicio',2);
INSERT INTO FASE(ID,ORDEN,NUMERO,DESCRIPCION,CUADRO_ID) VALUES (3,3,1,'Inicio',3);
-- ******************************************************************************************
-- CREATE TABLE
-- ******************************************************************************************
DROP TABLE IF EXISTS DESCOMPOSICION;
CREATE CACHED TABLE DESCOMPOSICION(
    ID IDENTITY NOT NULL PRIMARY KEY,
    ORDEN INTEGER NOT NULL AUTO_INCREMENT,
    CONCEPTO_ID BIGINT NOT NULL,
    CONCEPTO_PADRE_ID BIGINT NOT NULL,
    CUADRO_ID BIGINT NOT NULL DEFAULT 1,
    FACTOR FLOAT NOT NULL DEFAULT 1.0,
    RENDIMIENTO FLOAT NOT NULL DEFAULT 1.0,
    FECHA TIMESTAMP NOT NULL DEFAULT NOW()
);
ALTER TABLE DESCOMPOSICION ADD CONSTRAINT UK_DESCOMPOSICION_CONCEPTO_ID_CONCEPTO_PADRE_ID_CUADRO_ID UNIQUE (CONCEPTO_ID,CONCEPTO_PADRE_ID,CUADRO_ID);
ALTER TABLE DESCOMPOSICION ADD CONSTRAINT FK_DESCOMPOSICION_CONCEPTO_ID FOREIGN KEY(CONCEPTO_ID) REFERENCES CONCEPTO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE DESCOMPOSICION ADD CONSTRAINT FK_DESCOMPOSICION_CONCEPTO_PADRE_ID FOREIGN KEY(CONCEPTO_PADRE_ID) REFERENCES CONCEPTO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE DESCOMPOSICION ADD CONSTRAINT FK_DESCOMPOSICION_CUADRO_ID FOREIGN KEY(CUADRO_ID) REFERENCES CUADRO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
-- ******************************************************************************************
-- CREATE TABLE
-- ******************************************************************************************
DROP TABLE IF EXISTS MEDICION;
CREATE CACHED TABLE MEDICION(
    ID IDENTITY NOT NULL PRIMARY KEY,
    ORDEN INTEGER NOT NULL AUTO_INCREMENT,
    CONCEPTO_ID BIGINT NOT NULL,
    CONCEPTO_PADRE_ID BIGINT NOT NULL,
    CUADRO_ID BIGINT NOT NULL DEFAULT 1,
    FASE_ID BIGINT NOT NULL DEFAULT 1,
    COMENTARIO VARCHAR,
    CANTIDAD FLOAT NOT NULL DEFAULT 1.0,
    LARGO FLOAT NOT NULL DEFAULT 1.0,
    ANCHO FLOAT NOT NULL DEFAULT 1.0,
    ALTO FLOAT NOT NULL DEFAULT 1.0,
    FORMULA VARCHAR NOT NULL DEFAULT 'a*b*c*d',
    PARCIAL FLOAT NOT NULL DEFAULT 0.0,
    FECHA TIMESTAMP NOT NULL DEFAULT NOW()
);
ALTER TABLE MEDICION ADD CONSTRAINT UK_MEDICION_CONCEPTO_ID_CONCEPTO_PADRE_ID_CUADRO_ID_FASE_ID UNIQUE (CONCEPTO_ID,CONCEPTO_PADRE_ID,CUADRO_ID,FASE_ID);
ALTER TABLE MEDICION ADD CONSTRAINT FK_MEDICION_CONCEPTO_ID FOREIGN KEY(CONCEPTO_ID) REFERENCES CONCEPTO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE MEDICION ADD CONSTRAINT FK_MEDICION_CONCEPTO_PADRE_ID FOREIGN KEY(CONCEPTO_PADRE_ID) REFERENCES CONCEPTO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE MEDICION ADD CONSTRAINT FK_MEDICION_CUADRO_ID FOREIGN KEY(CUADRO_ID) REFERENCES CUADRO(ID) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE MEDICION ADD CONSTRAINT FK_MEDICION_FASE_ID FOREIGN KEY(FASE_ID) REFERENCES FASE(ID) ON UPDATE CASCADE ON DELETE CASCADE;
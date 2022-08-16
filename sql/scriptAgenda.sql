CREATE DATABASE IF NOT EXISTS `agenda`;
USE agenda;


CREATE TABLE IF NOT EXISTS `pais`
(
  `id_pais` int(11) NOT NULL AUTO_INCREMENT,

  `nombre`varchar(40) DEFAULT NULL,

  PRIMARY KEY(`id_pais`)
);


CREATE TABLE IF NOT EXISTS `provincia`
(
  `id_provincia` int(11) NOT NULL AUTO_INCREMENT,
  `id_pais` int(11) DEFAULT NULL,

  `nombre`varchar(40) DEFAULT NULL,

  PRIMARY KEY(`id_provincia`),
  FOREIGN KEY(`id_pais`) REFERENCES `pais`(`id_pais`)
);


CREATE TABLE IF NOT EXISTS `localidad`
(
  `id_localidad` int(11) NOT NULL AUTO_INCREMENT,
  `id_provincia` int(11) DEFAULT NULL,

  `nombre`varchar(40) DEFAULT NULL,

  PRIMARY KEY(`id_localidad`),
  FOREIGN KEY(`id_provincia`) REFERENCES `provincia`(`id_provincia`)
);


CREATE TABLE IF NOT EXISTS `direccion`
(
  `id_direccion` int(11) NOT NULL AUTO_INCREMENT,
  `id_localidad` int(11) DEFAULT NULL,

  `calle` varchar(40) DEFAULT NULL,
  `altura` int(4) DEFAULT NULL,
  `piso` int(2) DEFAULT NULL,
  `dto` varchar(11) DEFAULT NULL,

  PRIMARY KEY(`id_direccion`),
  FOREIGN KEY(`id_localidad`) REFERENCES `localidad`(`id_localidad`)
);


CREATE TABLE IF NOT EXISTS `tipos_contacto`
(
  `id_tipo_contacto`int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(40) DEFAULT NULL,

  PRIMARY KEY(`id_tipo_contacto`)
);


CREATE TABLE `personas`
(
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo_contacto` int(11) DEFAULT NULL, 
  `id_direccion` int(11) DEFAULT NULL,

  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `fecha_cumpleaños` varchar(10) DEFAULT NULL,

  PRIMARY KEY (`id_persona`),
  FOREIGN KEY(`id_tipo_contacto`) REFERENCES `tipos_contacto`(`id_tipo_contacto`),
  FOREIGN KEY(`id_direccion`) REFERENCES `direccion`(`id_direccion`)

);
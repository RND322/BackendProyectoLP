CREATE DATABASE tiendaonlinefinal;

USE tiendaonlinefinal;

CREATE TABLE `compradores` (
  `idcomprador` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correoelectronico` varchar(50) DEFAULT NULL,
  `contrasena` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idcomprador`)
);

CREATE TABLE `categorias` (
  `idcategoria` int NOT NULL AUTO_INCREMENT,
  `nombrecategoria` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idcategoria`)
);

CREATE TABLE `vendedores` (
  `idvendedor` int NOT NULL AUTO_INCREMENT,
  `nombrevendedor` varchar(100) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `correoelectronico` varchar(50) DEFAULT NULL,
  `contrasena` varchar(50) DEFAULT NULL,
  `cuentavendedor` int DEFAULT NULL,
  PRIMARY KEY (`idvendedor`)
);

CREATE TABLE `productos` (
  `idproducto` int NOT NULL AUTO_INCREMENT,
  `idvendedor` int DEFAULT NULL,
  `idcategoria` int DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `cantidadproducto` int DEFAULT NULL,
  PRIMARY KEY (`idproducto`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`idvendedor`) REFERENCES `vendedores` (`idvendedor`),
  CONSTRAINT `productos_ibfk_2` FOREIGN KEY (`idcategoria`) REFERENCES `categorias` (`idcategoria`)
);

CREATE TABLE `carrito_compras` (
  `idcarrito` int NOT NULL AUTO_INCREMENT,
  `idcomprador` int DEFAULT NULL,
  `idproducto` int DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `fechacreacion` date DEFAULT NULL,
  PRIMARY KEY (`idcarrito`),
  CONSTRAINT `carrito_compras_ibfk_1` FOREIGN KEY (`idcomprador`) REFERENCES `compradores` (`idcomprador`),
  CONSTRAINT `carrito_compras_ibfk_2` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`idproducto`)
);

CREATE TABLE `detalle_factura` (
  `numerofactura` int NOT NULL AUTO_INCREMENT,
  `idproducto` int DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `descuento` int DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL,
  `estadopago` varchar(5) DEFAULT NULL,
  `fechaentrega` date DEFAULT NULL,
  PRIMARY KEY (`numerofactura`),
  CONSTRAINT `detalle_factura_ibfk_1` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`idproducto`)
);

CREATE TABLE `direcciones_compradores` (
  `iddireccion` int NOT NULL AUTO_INCREMENT,
  `idcomprador` int DEFAULT NULL,
  `calle` varchar(50) DEFAULT NULL,
  `ciudad` varchar(50) DEFAULT NULL,
  `pais` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`iddireccion`),
  CONSTRAINT `direcciones_compradores_ibfk_1` FOREIGN KEY (`idcomprador`) REFERENCES `compradores` (`idcomprador`)
);

CREATE TABLE `facturacion` (
  `idfactura` int NOT NULL AUTO_INCREMENT,
  `idcarrito` int DEFAULT NULL,
  `fechafacturacion` date DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idfactura`),
  CONSTRAINT `facturacion_ibfk_1` FOREIGN KEY (`idcarrito`) REFERENCES `carrito_compras` (`idcarrito`)
);

CREATE TABLE `tarjetas_compradores` (
  `idtarjetacomprador` int NOT NULL AUTO_INCREMENT,
  `numerotarjetacomprador` varchar(16) DEFAULT NULL,
  `fechavencimientocomprador` date DEFAULT NULL,
  `codigoseguridadcomprador` varchar(3) DEFAULT NULL,
  `idcomprador` int DEFAULT NULL,
  PRIMARY KEY (`idtarjetacomprador`),
  CONSTRAINT `tarjetas_compradores_ibfk_1` FOREIGN KEY (`idcomprador`) REFERENCES `compradores` (`idcomprador`)
);
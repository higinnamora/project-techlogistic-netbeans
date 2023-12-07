-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema techlogisticdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `techlogisticdb` ;

-- -----------------------------------------------------
-- Schema techlogisticdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `techlogisticdb` DEFAULT CHARACTER SET utf8mb4 ;
USE `techlogisticdb` ;

-- -----------------------------------------------------
-- Table `techlogisticdb`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `techlogisticdb`.`pedido` (
  `id_pedido` INT(11) NOT NULL,
  `cantidad` VARCHAR(255) NULL DEFAULT NULL,
  `numero_orden` VARCHAR(255) NULL DEFAULT NULL,
  `proveedor` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_pedido`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `techlogisticdb`.`materia_prima`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `techlogisticdb`.`materia_prima` (
  `id_materia_prima` INT(11) NOT NULL,
  `cantidad_materia` FLOAT NULL DEFAULT NULL,
  `color_materia` VARCHAR(255) NULL DEFAULT NULL,
  `peso` FLOAT NULL DEFAULT NULL,
  `precio` FLOAT NULL DEFAULT NULL,
  `textura` VARCHAR(255) NULL DEFAULT NULL,
  `pedido_id_pedido` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_materia_prima`),
  CONSTRAINT `FK_materia_prima_pedido_id_pedido`
    FOREIGN KEY (`pedido_id_pedido`)
    REFERENCES `techlogisticdb`.`pedido` (`id_pedido`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `techlogisticdb`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `techlogisticdb`.`productos` (
  `codigo_producto` INT(11) NOT NULL,
  `material` VARCHAR(255) NULL DEFAULT NULL,
  `modelo` VARCHAR(255) NULL DEFAULT NULL,
  `nombre_producto` VARCHAR(255) NULL DEFAULT NULL,
  `precio` VARCHAR(255) NULL DEFAULT NULL,
  `talla` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo_producto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `techlogisticdb`.`materia_prima_has_productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `techlogisticdb`.`materia_prima_has_productos` (
  `materia_prima_id_materia_prima` INT(11) NOT NULL,
  `productos_codigo_producto` INT(11) NOT NULL,
  PRIMARY KEY (`materia_prima_id_materia_prima`, `productos_codigo_producto`),
  CONSTRAINT `materiaprimahas_productosproductos_codigo_producto`
    FOREIGN KEY (`productos_codigo_producto`)
    REFERENCES `techlogisticdb`.`productos` (`codigo_producto`),
  CONSTRAINT `materiaprimahasproductosmateriaprimaidmateriaprima`
    FOREIGN KEY (`materia_prima_id_materia_prima`)
    REFERENCES `techlogisticdb`.`materia_prima` (`id_materia_prima`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `techlogisticdb`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `techlogisticdb`.`roles` (
  `id_rol` INT(11) NOT NULL,
  `descripcion` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_rol`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `techlogisticdb`.`personas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `techlogisticdb`.`personas` (
  `id_persona` INT(11) NOT NULL,
  `no_documento` VARCHAR(255) NULL DEFAULT NULL,
  `direccion` VARCHAR(255) NULL DEFAULT NULL,
  `primer_apellido` VARCHAR(255) NULL DEFAULT NULL,
  `primer_nombre` VARCHAR(255) NULL DEFAULT NULL,
  `segundo_apellido` INT(11) NULL DEFAULT NULL,
  `segundo_nombre` VARCHAR(255) NULL DEFAULT NULL,
  `telefono` VARCHAR(255) NULL DEFAULT NULL,
  `correo` VARCHAR(255) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `roles_id_rol` INT(11) NOT NULL,
  PRIMARY KEY (`id_persona`),
  CONSTRAINT `fk_personas_roles1`
    FOREIGN KEY (`roles_id_rol`)
    REFERENCES `techlogisticdb`.`roles` (`id_rol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `techlogisticdb`.`Orden_venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `techlogisticdb`.`Orden_venta` (
  `id_orden_venta` INT(11) NOT NULL,
  `fecha_venta` DATETIME NULL,
  `personas_id_persona` INT(11) NOT NULL,
  PRIMARY KEY (`id_orden_venta`),
  CONSTRAINT `fk_Orden_venta_personas1`
    FOREIGN KEY (`personas_id_persona`)
    REFERENCES `techlogisticdb`.`personas` (`id_persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `techlogisticdb`.`DetalleOrden_venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `techlogisticdb`.`DetalleOrden_venta` (
  `id_detalleorden_venta` INT(11) NOT NULL,
  `cantidad_productos` INT(11) NULL DEFAULT NULL,
  `descuento` FLOAT NULL DEFAULT NULL,
  `medio_pago` VARCHAR(255) NULL DEFAULT NULL,
  `observacion` VARCHAR(255) NULL DEFAULT NULL,
  `sub_total` FLOAT NULL DEFAULT NULL,
  `total` FLOAT NULL DEFAULT NULL,
  `productos_codigo_producto` INT(11) NOT NULL,
  `Orden_venta_id_orden_venta` INT(11) NOT NULL,
  PRIMARY KEY (`id_detalleorden_venta`),
  CONSTRAINT `fk_DetalleOrden_venta_productos1`
    FOREIGN KEY (`productos_codigo_producto`)
    REFERENCES `techlogisticdb`.`productos` (`codigo_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetalleOrden_venta_Orden_venta1`
    FOREIGN KEY (`Orden_venta_id_orden_venta`)
    REFERENCES `techlogisticdb`.`Orden_venta` (`id_orden_venta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `techlogisticdb`.`stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `techlogisticdb`.`stock` (
  `id_stock` INT(11) NOT NULL,
  `cantidad_stock` VARCHAR(255) NULL DEFAULT NULL,
  `descripcion_stock` VARCHAR(255) NULL DEFAULT NULL,
  `estado` VARCHAR(255) NULL DEFAULT NULL,
  `productos_codigo_producto` INT(11) NOT NULL,
  PRIMARY KEY (`id_stock`),
  CONSTRAINT `fk_stock_productos1`
    FOREIGN KEY (`productos_codigo_producto`)
    REFERENCES `techlogisticdb`.`productos` (`codigo_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

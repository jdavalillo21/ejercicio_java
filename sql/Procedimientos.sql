DROP PROCEDURE IF EXISTS `getpersonas`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getpersonas`()
BEGIN
	SELECT * FROM persona;
END
;;
DELIMITER ;


DROP PROCEDURE IF EXISTS `new_persona`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `new_persona`(
IN dni varchar(20),
IN nombre varchar(50),
IN apellido varchar(50),
IN telefono varchar(20),
IN email varchar(100),
IN direccion TEXT
)
BEGIN
	IF NOT EXISTS (SELECT * FROM persona WHERE persona.dni = dni) THEN
            INSERT INTO persona (persona.dni, persona.nombre, persona.apellido, persona.telefono, persona.email, persona.direccion)
            VALUES(dni, nombre, apellido, telefono, email, direccion);
        END IF;
END
;;
DELIMITER ;


DROP PROCEDURE IF EXISTS `editar_persona`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `editar_persona`(
IN id int(11),
IN dni varchar(20),
IN nombre varchar(50),
IN apellido varchar(50),
IN telefono varchar(20),
IN email varchar(100),
IN direccion TEXT
)
BEGIN
IF EXISTS(SELECT * FROM persona WHERE persona.id = id) THEN
    UPDATE persona SET
    persona.dni = dni,
    persona.nombre = nombre,
    persona.apellido = apellido,
    persona.telefono = telefono,
    persona.email = email,
    persona.direccion = direccion
    WHERE 
    persona.id = id;
END IF;
END
;;
DELIMITER ;

DROP PROCEDURE IF EXISTS `eliminar_persona`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_persona`(
IN id int(11)
)
BEGIN
IF EXISTS(SELECT * FROM persona WHERE persona.id = id) THEN
    DELETE FROM persona 
    WHERE 
    persona.id = id;
END IF;
END
;;
DELIMITER ;


DROP PROCEDURE IF EXISTS `encontrar_persona`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `encontrar_persona`(
IN id int(11)
)
BEGIN
IF EXISTS(SELECT * FROM persona WHERE persona.id = id) THEN
    SELECT * FROM persona 
    WHERE 
    persona.id = id;
END IF;
END
;;
DELIMITER ;
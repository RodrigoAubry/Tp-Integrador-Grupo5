/* Creando las tablas Pronosticos y Resultados */

CREATE TABLE Pronosticos (
idPronostico INTEGER NOT NULL AUTO_INCREMENT,
participante VARCHAR(25),
equipo1 VARCHAR(25),
resultado VARCHAR(10),
equipo2 VARCHAR(25),
PRIMARY KEY ( idPronostico ));
TRUNCATE TABLE Pronosticos;



/*Insertando datos en la tabla Pronosticos*/

INSERT INTO Pronosticos (participante, equipo1, resultado, equipo2) VALUES
('Mariana', 'Argentina', 'Gana 1', 'Arabia Saudita'),
('Mariana', 'Polonia', 'Empata', 'México'),
('Mariana', 'Argentina', 'Gana 1', 'México'),
('Mariana', 'Arabia Saudita', 'Gana 2', 'Polonia'),
('Pedro', 'Argentina', 'Gana 1', 'Arabia Saudita'),
('Pedro', 'Polonia', 'Gana 2', 'México'),
('Pedro', 'Argentina', 'Gana 1', 'México'),
('Pedro', 'Arabia Saudita', 'Empata', 'Polonia');
/*Si quieren agregar mas datos, simplemente sigan agregando tuplas antes del ';' */

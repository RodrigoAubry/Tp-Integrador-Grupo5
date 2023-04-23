
CREATE TABLE Resultados (
idResultado INTEGER not NULL AUTO_INCREMENT,
ronda INTEGER,
equipo1 VARCHAR(25),
cantGoles1 INTEGER,
cantGoles2 INTEGER,
equipo2 VARCHAR(25),
PRIMARY KEY ( idResultado ));
TRUNCATE TABLE Resultados;



/*Insertando datos en la tabla Resultados*/

INSERT INTO Resultados (ronda, equipo1, cantGoles1, cantGoles2, equipo2) VALUES
(1, 'Argentina', 1, 2, 'Arabia Saudita'),
(1, 'Polonia', 0, 0 , 'México'),
(2, 'Argentina', 2, 0, 'México'),
(2, 'Arabia Saudita', 0, 2, 'Polonia');
/*Si quieren agregar mas datos, simplemente sigan agregando tuplas antes del ';'*/
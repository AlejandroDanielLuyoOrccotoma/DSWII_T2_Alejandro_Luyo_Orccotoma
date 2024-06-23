CREATE DATABASE BDCibertec;
USE BDCibertec;

CREATE TABLE Personaje (
    IdPersonaje INT NOT NULL AUTO_INCREMENT,
    NomPersonaje VARCHAR(50) NOT NULL,
    ApePersonaje VARCHAR(50) NOT NULL,
    FechNacPersonaje DATE NOT NULL,
    PRIMARY KEY (IdPersonaje)
);

CREATE TABLE ProgramaTv (
    IdProgramaTv INT NOT NULL AUTO_INCREMENT,
    Titulo VARCHAR(250) NOT NULL,
    Resumen VARCHAR(250) NOT NULL,
    FechaInicio DATE NOT NULL,
    IdPersonaje INT NOT NULL,
    PRIMARY KEY (IdProgramaTv),
    FOREIGN KEY (IdPersonaje) REFERENCES Personaje(IdPersonaje)
);

-- Insertar registros en la tabla Personaje
INSERT INTO Personaje (NomPersonaje, ApePersonaje, FechNacPersonaje) VALUES ('Juan', 'Pérez', '1985-01-15');
INSERT INTO Personaje (NomPersonaje, ApePersonaje, FechNacPersonaje) VALUES ('María', 'López', '1990-06-20');
INSERT INTO Personaje (NomPersonaje, ApePersonaje, FechNacPersonaje) VALUES ('Carlos', 'González', '1988-09-10');
INSERT INTO Personaje (NomPersonaje, ApePersonaje, FechNacPersonaje) VALUES ('Ana', 'Martínez', '1992-12-05');
INSERT INTO Personaje (NomPersonaje, ApePersonaje, FechNacPersonaje) VALUES ('Luis', 'Rodríguez', '1983-03-25');

-- Insertar registros en la tabla ProgramaTv
INSERT INTO ProgramaTv (Titulo, Resumen, FechaInicio, IdPersonaje) VALUES ('Programa 1', 'Resumen del Programa 1', '2020-01-01', 1);
INSERT INTO ProgramaTv (Titulo, Resumen, FechaInicio, IdPersonaje) VALUES ('Programa 2', 'Resumen del Programa 2', '2020-02-01', 2);
INSERT INTO ProgramaTv (Titulo, Resumen, FechaInicio, IdPersonaje) VALUES ('Programa 3', 'Resumen del Programa 3', '2020-03-01', 3);
INSERT INTO ProgramaTv (Titulo, Resumen, FechaInicio, IdPersonaje) VALUES ('Programa 4', 'Resumen del Programa 4', '2020-04-01', 4);
INSERT INTO ProgramaTv (Titulo, Resumen, FechaInicio, IdPersonaje) VALUES ('Programa 5', 'Resumen del Programa 5', '2020-05-01', 5);

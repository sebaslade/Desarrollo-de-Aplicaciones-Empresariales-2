CREATE DATABASE Sucursales;

USE Sucursales;

CREATE TABLE Usuario (
    codigo INT IDENTITY(1,1) PRIMARY KEY,
    correo VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(20) NOT NULL,
    estado VARCHAR(20) NOT NULL
);

CREATE TABLE Sucursal (
    codigo INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    estado VARCHAR(20) NOT NULL
);

INSERT INTO Usuario (correo, password, estado) VALUES
('sebaslade29@gmail.com', 'clave123', 'activo'),
('sebastianlaos2b@gmail.com', 'pass123', 'activo'),
('laosdelgado@isil.com', 'abc123', 'inactivo');

INSERT INTO Sucursal (nombre, direccion, estado) VALUES
('Andina Express', 'Av. Los Andes 120, Cusco', 'activo'),
('CostaMar', 'Malecón Sur 45, Lima', 'activo'),
('NorteActivo', 'Av. Industrial 332, Chiclayo', 'activo'),
('Altura Sur', 'Calle Altiplano 88, Arequipa', 'inactivo'),
('VidaCentro', 'Av. Central 1001, Huancayo', 'activo'),
('Plaza Norte', 'Av. Túpac Amaru 1234, Independencia', 'activo'),
('Vía Moderna', 'Jr. Futuro 567, Trujillo', 'activo'),
('Amanecer', 'Calle Los Sauces 22, Iquitos', 'activo'),
('Horizonte Azul', 'Av. Horizonte 1010, Piura', 'inactivo'),
('EcoSur', 'Av. Ecológica 333, Tacna', 'activo');
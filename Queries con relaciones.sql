USE paqueteria
GO

--   ======================== TABLAS ========================
CREATE TABLE Estado (
  idEstado INT PRIMARY KEY IDENTITY (1, 1),
  Estado   VARCHAR(15) NOT NULL
);

CREATE TABLE Ciudad (
  idCiudad INT PRIMARY KEY IDENTITY (1, 1),
  Ciudad   VARCHAR(40) NOT NULL
);

CREATE TABLE Colonia (
  idColonia INT PRIMARY KEY IDENTITY (1, 1),
  Colonia   VARCHAR(15) NOT NULL,
  CP        VARCHAR(5)  NOT NULL
);

CREATE TABLE Domicilio (
  idDomicilio INT PRIMARY KEY IDENTITY (1, 1),
  Calle       VARCHAR(15) NOT NULL,
  No_Int      VARCHAR(5)  NOT NULL,
  No_Ext      VARCHAR(5)  NOT NULL
);

CREATE TABLE Cliente (
  idCliente      INT PRIMARY KEY IDENTITY (1, 1),
  Nombre         VARCHAR(15) NOT NULL,
  Apeido_Paterno VARCHAR(30) NOT NULL,
  Apeido_Materno VARCHAR(30) NOT NULL,
  Estatus DATETIME
);

CREATE TABLE Zona_horaria (
  idZH         INT PRIMARY KEY IDENTITY (1, 1),
  Zona_horaria VARCHAR(15) NOT NULL
);

CREATE TABLE Telefono (
  idTelefono  INT PRIMARY KEY IDENTITY (1, 1),
  Numero      VARCHAR(10) NOT NULL,
  Descripcion VARCHAR(30)
);

CREATE TABLE Paquete (
  idPaquete   INT PRIMARY KEY IDENTITY (1, 1),
  Fragil      BIT         NOT NULL,
  Prioridad   BIT         NOT NULL,
  Peso        VARCHAR(10) NOT NULL,
  Dimenciones VARCHAR(15) NOT NULL,
  Estatus DATETIME
);

CREATE TABLE Empleado (
  idEmpleado       INT PRIMARY KEY IDENTITY (1, 1),
  Nombre           VARCHAR(15) NOT NULL,
  Apellido_Paterno VARCHAR(15) NOT NULL,
  Apellido_Materno VARCHAR(15) NOT NULL,
  Sexo             VARCHAR(10) NOT NULL,
  Edad             VARCHAR(2)  NOT NULL,
  Turno            VARCHAR(10) NOT NULL,
  Estatus DATETIME
);

CREATE TABLE Localizacion (
  idLocalizacion INT PRIMARY KEY IDENTITY (1, 1),
  Localizacion   VARCHAR(15) NOT NULL
);

CREATE TABLE Transporte (
  idTransporte INT PRIMARY KEY IDENTITY (1, 1),
  Tipo         VARCHAR(50) NOT NULL
);

CREATE TABLE Email (
  idEmail     INT PRIMARY KEY IDENTITY (1, 1),
  Correo      VARCHAR(50) NOT NULL,
  Descripcion VARCHAR(15) NOT NULL
);

--  ======================== RELACIONES  ========================

CREATE TABLE Dir_origen_destino (
  idOD           INT PRIMARY KEY IDENTITY (1, 1),
  idZH           INT FOREIGN KEY REFERENCES Zona_horaria (idZH),
  idDomicilio    INT FOREIGN KEY REFERENCES Domicilio (idDomicilio),
  idPaquete      INT FOREIGN KEY REFERENCES Paquete (idPaquete),
  idLocalizacion INT FOREIGN KEY REFERENCES Localizacion (idLocalizacion),
  idCliente      INT FOREIGN KEY REFERENCES Cliente (idCliente),
  od             VARCHAR(15)
);

CREATE TABLE Det_domicilio (
  idDetDomicilio INT PRIMARY KEY IDENTITY (1, 1),
  idEstado       INT FOREIGN KEY REFERENCES Estado (idEstado),
  idColonia      INT FOREIGN KEY REFERENCES Colonia (idColonia),
  idDomicilio    INT FOREIGN KEY REFERENCES Domicilio (idDomicilio),
  idCiudad       INT FOREIGN KEY REFERENCES Ciudad (idCiudad)
);

CREATE TABLE Envio (
  idEnvio   INT PRIMARY KEY IDENTITY (1, 1),
  idPaquete INT FOREIGN KEY REFERENCES Paquete (idPaquete),
  idCliente INT FOREIGN KEY REFERENCES Cliente (idCliente),
  Costos    VARCHAR(10) NOT NULL
);

CREATE TABLE Rastreo (
  idRastreo      INT PRIMARY KEY IDENTITY (1, 1),
  idPaquete      INT FOREIGN KEY REFERENCES Paquete (idPaquete),
  idCliente      INT FOREIGN KEY REFERENCES Cliente (idCliente),
  idEmpleado     INT FOREIGN KEY REFERENCES Empleado (idEmpleado),
  idLocalizacion INT FOREIGN KEY REFERENCES Localizacion (idLocalizacion),
  idTransporte   INT FOREIGN KEY REFERENCES Transporte (idTransporte),
  Folio          VARCHAR(10) NOT NULL
);

CREATE TABLE Det_cliente (
  idDetCliente INT PRIMARY KEY IDENTITY (1, 1),
  idCliente    INT FOREIGN KEY REFERENCES Cliente (idCliente),
  idTelefono   INT FOREIGN KEY REFERENCES Telefono (idTelefono),
);

CREATE TABLE Email_cliente (
  idEmailCliente INT PRIMARY KEY IDENTITY (1, 1),
  idEmail        INT FOREIGN KEY REFERENCES Email (idEmail),
  idCliente      INT FOREIGN KEY REFERENCES Cliente (idCliente)
);

CREATE TABLE Email_empleado (
  idEmailEmpleado INT PRIMARY KEY IDENTITY (1, 1),
  idEmail         INT FOREIGN KEY REFERENCES Email (idEmail),
  idEmpleado      INT FOREIGN KEY REFERENCES Empleado (idEmpleado)
);
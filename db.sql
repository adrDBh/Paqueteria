USE [Paqueteria]
GO
/****** Object:  Table [dbo].[Ciudad]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Ciudad](
	[idCiudad] [int] IDENTITY(1,1) NOT NULL,
	[Ciudad] [varchar](40) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idCiudad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Cliente](
	[idCliente] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](15) NOT NULL,
	[Apeido_Paterno] [varchar](30) NOT NULL,
	[Apeido_Materno] [varchar](30) NOT NULL,
	[Estatus] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[idCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Colonia]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Colonia](
	[idColonia] [int] IDENTITY(1,1) NOT NULL,
	[Colonia] [varchar](15) NOT NULL,
	[CP] [varchar](5) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idColonia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Det_cliente]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Det_cliente](
	[idDetCliente] [int] IDENTITY(1,1) NOT NULL,
	[idCliente] [int] NULL,
	[idTelefono] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idDetCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Det_domicilio]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Det_domicilio](
	[idDetDomicilio] [int] IDENTITY(1,1) NOT NULL,
	[idEstado] [int] NOT NULL,
	[idColonia] [int] NOT NULL,
	[idDomicilio] [int] NOT NULL,
	[idCiudad] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idDetDomicilio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Dir_origen_destino]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Dir_origen_destino](
	[idOD] [int] IDENTITY(1,1) NOT NULL,
	[idZH] [int] NOT NULL,
	[idDetDomicilio] [int] NOT NULL,
	[idPaquete] [int] NOT NULL,
	[idCliente] [int] NOT NULL,
	[od] [varchar](15) NULL,
PRIMARY KEY CLUSTERED 
(
	[idOD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Domicilio]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Domicilio](
	[idDomicilio] [int] IDENTITY(1,1) NOT NULL,
	[Calle] [varchar](15) NOT NULL,
	[No_Int] [varchar](5) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idDomicilio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Email]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Email](
	[idEmail] [int] IDENTITY(1,1) NOT NULL,
	[Correo] [varchar](50) NOT NULL,
	[Descripcion] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idEmail] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Email_cliente]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Email_cliente](
	[idEmailCliente] [int] IDENTITY(1,1) NOT NULL,
	[idEmail] [int] NULL,
	[idCliente] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idEmailCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Email_empleado]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Email_empleado](
	[idEmailEmpleado] [int] IDENTITY(1,1) NOT NULL,
	[idEmail] [int] NULL,
	[idEmpleado] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idEmailEmpleado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Empleado]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Empleado](
	[idEmpleado] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](15) NOT NULL,
	[Apellido_Paterno] [varchar](15) NOT NULL,
	[Apellido_Materno] [varchar](15) NOT NULL,
	[Turno] [varchar](20) NOT NULL,
	[Estatus] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[idEmpleado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Envio]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Envio](
	[idEnvio] [int] IDENTITY(1,1) NOT NULL,
	[idPaquete] [int] NULL,
	[idCliente] [int] NULL,
	[Costos] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idEnvio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Estado]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Estado](
	[idEstado] [int] IDENTITY(1,1) NOT NULL,
	[Estado] [varchar](15) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idEstado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Localizacion]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Localizacion](
	[idLocalizacion] [int] IDENTITY(1,1) NOT NULL,
	[Localizacion] [varchar](15) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idLocalizacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Login]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Login](
	[idLogin] [int] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](255) NOT NULL,
	[Password] [varchar](255) NOT NULL,
	[CreatedAt] [datetime] NULL,
	[LastLogin] [datetime] NULL DEFAULT (NULL)
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Paquete]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Paquete](
	[idPaquete] [int] IDENTITY(1,1) NOT NULL,
	[Fragil] [varchar](2) NOT NULL,
	[Prioridad] [varchar](10) NOT NULL,
	[Peso] [varchar](10) NOT NULL,
	[Largo] [varchar](3) NOT NULL,
	[Ancho] [varchar](3) NOT NULL,
	[Alto] [varchar](3) NOT NULL,
	[Descripcion] [varchar](45) NOT NULL,
	[Estatus] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[idPaquete] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Rastreo]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Rastreo](
	[idRastreo] [int] IDENTITY(1,1) NOT NULL,
	[idPaquete] [int] NULL,
	[idCliente] [int] NULL,
	[idEmpleado] [int] NULL,
	[idLocalizacion] [int] NULL,
	[idTransporte] [int] NULL,
	[Folio] [varchar](22) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idRastreo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Telefono]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Telefono](
	[idTelefono] [int] IDENTITY(1,1) NOT NULL,
	[Numero] [varchar](10) NOT NULL,
	[Descripcion] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[idTelefono] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Transporte]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Transporte](
	[idTransporte] [int] IDENTITY(1,1) NOT NULL,
	[Tipo] [varchar](15) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idTransporte] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Zona_horaria]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Zona_horaria](
	[idZH] [int] IDENTITY(1,1) NOT NULL,
	[Zona_horaria] [varchar](15) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idZH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Det_cliente]  WITH CHECK ADD FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([idCliente])
GO
ALTER TABLE [dbo].[Det_cliente]  WITH CHECK ADD FOREIGN KEY([idTelefono])
REFERENCES [dbo].[Telefono] ([idTelefono])
GO
ALTER TABLE [dbo].[Det_domicilio]  WITH CHECK ADD FOREIGN KEY([idCiudad])
REFERENCES [dbo].[Ciudad] ([idCiudad])
GO
ALTER TABLE [dbo].[Det_domicilio]  WITH CHECK ADD FOREIGN KEY([idColonia])
REFERENCES [dbo].[Colonia] ([idColonia])
GO
ALTER TABLE [dbo].[Det_domicilio]  WITH CHECK ADD FOREIGN KEY([idDomicilio])
REFERENCES [dbo].[Domicilio] ([idDomicilio])
GO
ALTER TABLE [dbo].[Det_domicilio]  WITH CHECK ADD FOREIGN KEY([idEstado])
REFERENCES [dbo].[Estado] ([idEstado])
GO
ALTER TABLE [dbo].[Dir_origen_destino]  WITH CHECK ADD FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([idCliente])
GO
ALTER TABLE [dbo].[Dir_origen_destino]  WITH CHECK ADD  CONSTRAINT [FK__Dir_orige__idDom__208CD6FA] FOREIGN KEY([idDetDomicilio])
REFERENCES [dbo].[Det_domicilio] ([idDetDomicilio])
GO
ALTER TABLE [dbo].[Dir_origen_destino] CHECK CONSTRAINT [FK__Dir_orige__idDom__208CD6FA]
GO
ALTER TABLE [dbo].[Dir_origen_destino]  WITH CHECK ADD FOREIGN KEY([idPaquete])
REFERENCES [dbo].[Paquete] ([idPaquete])
GO
ALTER TABLE [dbo].[Dir_origen_destino]  WITH CHECK ADD FOREIGN KEY([idZH])
REFERENCES [dbo].[Zona_horaria] ([idZH])
GO
ALTER TABLE [dbo].[Email_cliente]  WITH CHECK ADD FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([idCliente])
GO
ALTER TABLE [dbo].[Email_cliente]  WITH CHECK ADD FOREIGN KEY([idEmail])
REFERENCES [dbo].[Email] ([idEmail])
GO
ALTER TABLE [dbo].[Email_empleado]  WITH CHECK ADD FOREIGN KEY([idEmail])
REFERENCES [dbo].[Email] ([idEmail])
GO
ALTER TABLE [dbo].[Email_empleado]  WITH CHECK ADD FOREIGN KEY([idEmpleado])
REFERENCES [dbo].[Empleado] ([idEmpleado])
GO
ALTER TABLE [dbo].[Envio]  WITH CHECK ADD FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([idCliente])
GO
ALTER TABLE [dbo].[Envio]  WITH CHECK ADD FOREIGN KEY([idPaquete])
REFERENCES [dbo].[Paquete] ([idPaquete])
GO
ALTER TABLE [dbo].[Rastreo]  WITH CHECK ADD FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([idCliente])
GO
ALTER TABLE [dbo].[Rastreo]  WITH CHECK ADD FOREIGN KEY([idEmpleado])
REFERENCES [dbo].[Empleado] ([idEmpleado])
GO
ALTER TABLE [dbo].[Rastreo]  WITH CHECK ADD FOREIGN KEY([idLocalizacion])
REFERENCES [dbo].[Localizacion] ([idLocalizacion])
GO
ALTER TABLE [dbo].[Rastreo]  WITH CHECK ADD FOREIGN KEY([idPaquete])
REFERENCES [dbo].[Paquete] ([idPaquete])
GO
ALTER TABLE [dbo].[Rastreo]  WITH CHECK ADD FOREIGN KEY([idTransporte])
REFERENCES [dbo].[Transporte] ([idTransporte])
GO
/****** Object:  StoredProcedure [dbo].[listLogin]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[listLogin]
AS
 BEGIN
  SELECT * FROM Login
 END
GO
/****** Object:  StoredProcedure [dbo].[spAddClientEmail]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spAddClientEmail]
    @ID               INT,
    @Email            VARCHAR(50),
    @EmailDescription VARCHAR(50)
AS
  BEGIN
    DECLARE @ClientID INT, @EmailID INT

    INSERT INTO Email VALUES (@Email, @EmailDescription)
    SET @ClientID = (SELECT TOP 1 idCliente
                     FROM Cliente
                     WHERE @ID = idCliente)
    SET @EmailID = (SELECT TOP 1 idEmail
                    FROM Email
                    ORDER BY idEmail DESC)
    INSERT INTO Email_cliente VALUES (@EmailID, @ClientID)
  END
GO
/****** Object:  StoredProcedure [dbo].[spAddClientPhone]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spAddClientPhone]
  @ID               INT,
  @PhoneNumber      VARCHAR(50),
  @PhoneDescription VARCHAR(50)
AS
BEGIN
  DECLARE @ClientID INT, @PhoneID INT

  INSERT INTO Telefono VALUES (@PhoneNumber, @PhoneDescription)
  SET @ClientID = (SELECT TOP 1 idCliente
                   FROM Cliente
                   WHERE @ID = idCliente)
  SET @PhoneID = (SELECT TOP 1 idTelefono
                  FROM Telefono
                  ORDER BY idTelefono DESC)
  INSERT INTO Det_cliente VALUES (@ClientID, @PhoneID)
END
GO
/****** Object:  StoredProcedure [dbo].[spAddEmployeeEmail]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spAddEmployeeEmail]
    @ID               INT,
    @Email            VARCHAR(50),
    @EmailDescription VARCHAR(50)
AS
  BEGIN
    DECLARE @EmployeeID INT, @EmailID INT

    INSERT INTO Email VALUES (@Email, @EmailDescription)
    SET @EmployeeID = (SELECT TOP 1 idEmpleado
                       FROM Empleado
                       WHERE @ID = idEmpleado
                       ORDER BY idEmpleado DESC)
    SET @EmailID = (SELECT TOP 1 idEmail
                    FROM Email
                    ORDER BY idEmail DESC)
    INSERT INTO Email_empleado VALUES (@EmailID, @EmployeeID)
  END
GO
/****** Object:  StoredProcedure [dbo].[spCreateService]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spCreateService]
  --  -- DATOS DEL CLIENTE
    @ClientNAME           VARCHAR(50),
    @CLIENTAPP            VARCHAR(50),
    @CLIENTAPM            VARCHAR(50),
    -- DATOS DEL PAQUETE
    @FRAGILE              VARCHAR(2),
    @PRIORITY             VARCHAR(10),
    @WEIGHT               VARCHAR(10),
    @ALTO                 VARCHAR(10),
    @LARGO                VARCHAR(10),
    @ANCHO                VARCHAR(10),
    @DESCRIPTION          VARCHAR(30),
    -- DATOS DEL EMPLEADO
    @EmployeeNAME         VARCHAR(50),
    @EmployeeAPP          VARCHAR(50),
    @EmployeeAPM          VARCHAR(50),
    -- DATOS DEL ORIGEN
    @STREET               VARCHAR(20),
    @STREETNUMBER         VARCHAR(5),
    @COLONY               VARCHAR(10),
    @CP                   VARCHAR(10),
    @CITY                 VARCHAR(20),
    @STATE                VARCHAR(20),
    @ORIGIN               VARCHAR(15),
    -- DATOS DEL DESTINO
    @STREET_DESTINY       VARCHAR(20),
    @STREETNUMBER_DESTINY VARCHAR(5),
    @COLONY_DESTINY       VARCHAR(10),
    @CP_DESTINY           VARCHAR(10),
    @CITY_DESTINY         VARCHAR(20),
    @STATE_DESTINY        VARCHAR(20),
    @DESTINY              VARCHAR(15),
    @FOILNUMBER           VARCHAR(22),
    -- COSTO TOTAL
    @COST                 VARCHAR(15),
    @TRANSPORT            VARCHAR(20)
AS
  BEGIN
    -- SE DECLARAN LAS VARIABLES PARA RECUPERAR SUS IDS
    DECLARE @CLIENTID INT,
    @EMPLOYEEID INT,
    @PACKAGEID INT,
    @ORIGEN_DOMICILIO INT,
    @ORIGEN_COLONIA INT,
    @ORIGEN_CIUDAD INT,
    @ORIGEN_ESTADO INT,
    @ORIGEN_DET_DOMICILIO INT,
    @ORIGEN_LOCALIZACION INT,
    @DESTINO_DOMICILIO INT,
    @DESTINO_COLONIA INT,
    @DESTINO_CIUDAD INT,
    @DESTINO_ESTADO INT,
    @DESTINO_DET_DOMICILIO INT,
    @DESTINO_LOCALIZACION INT,
    @TRANSPORTID INT

    -- ==================== EMPLEADO/CLIENTE ===================
    -- SELECIONA EL ID DEL CLIENTE COMPARANDO EL NOMBRE COMPLETO.
    SET @CLIENTID = (SELECT TOP 1 idCliente
                     FROM Cliente
                     WHERE Nombre = @ClientNAME AND Apeido_Paterno = @CLIENTAPP AND Apeido_Materno = @CLIENTAPM
                     ORDER BY idCliente DESC)
    -- SELECCIONA EL ID DEL EMPLEADO COMPARANDO EL NOMBRE COMPLETO.
    SET @EMPLOYEEID = (SELECT TOP 1 idEmpleado
                       FROM Empleado
                       WHERE Nombre = @EmployeeNAME AND Apellido_Paterno = @EmployeeAPP AND
                             Apellido_Materno = @EmployeeAPM
                       ORDER BY idEmpleado DESC)
    -- =================================================
    -- ========================== PAQUETE ==============
    -- SE INSERTA UN NUEVO PAQUETE
    INSERT INTO Paquete VALUES (@FRAGILE, @PRIORITY, @WEIGHT, @LARGO, @ANCHO, @ALTO, @DESCRIPTION, NULL)
    -- SELECCIONA EL ULTIMO ID QUE SE INSERTÓ EN EL PAQUETE
    SET @PACKAGEID = (SELECT TOP 1 idPaquete
                      FROM Paquete
                      ORDER BY idPaquete DESC)
    -- ==================================================
    -- ========================== ORIGEN ================
    INSERT INTO Domicilio VALUES (@STREET, @STREETNUMBER)
    INSERT INTO Colonia VALUES (@COLONY, @CP)
    INSERT INTO Ciudad VALUES (@CITY)
    INSERT INTO Estado VALUES (@STATE)
    SET @ORIGEN_DOMICILIO = (SELECT TOP 1 idDomicilio
                             FROM Domicilio
                             ORDER BY idDomicilio DESC)

    SET @ORIGEN_COLONIA = (SELECT TOP 1 idColonia
                           FROM Colonia
                           ORDER BY idColonia DESC)

    SET @ORIGEN_CIUDAD = (SELECT TOP 1 idCiudad
                          FROM Ciudad
                          ORDER BY idCiudad DESC)

    SET @ORIGEN_ESTADO = (SELECT TOP 1 idEstado
                          FROM Estado
                          ORDER BY idEstado DESC)

    INSERT INTO Det_domicilio VALUES (@ORIGEN_ESTADO, @ORIGEN_COLONIA, @ORIGEN_DOMICILIO, @ORIGEN_CIUDAD)

    SET @ORIGEN_DET_DOMICILIO = (SELECT TOP 1 idDetDomicilio
                                 FROM Det_domicilio
                                 ORDER BY idDetDomicilio DESC)

    INSERT INTO Dir_origen_destino
    VALUES (6, @ORIGEN_DET_DOMICILIO, @PACKAGEID, @CLIENTID, 'Origen')
    -- ==================== DESTINO =====================
    INSERT INTO Domicilio VALUES (@STREET_DESTINY, @STREETNUMBER_DESTINY)
    INSERT INTO Colonia VALUES (@COLONY_DESTINY, @CP_DESTINY)
    INSERT INTO Ciudad VALUES (@CITY_DESTINY)
    INSERT INTO Estado VALUES (@STATE_DESTINY)

    SET @DESTINO_DOMICILIO = (SELECT TOP 1 idDomicilio
                              FROM Domicilio
                              ORDER BY idDomicilio DESC)

    SET @DESTINO_COLONIA = (SELECT TOP 1 idColonia
                            FROM Colonia
                            ORDER BY idColonia DESC)

    SET @DESTINO_CIUDAD = (SELECT TOP 1 idCiudad
                           FROM Ciudad
                           ORDER BY idCiudad DESC)

    SET @DESTINO_ESTADO = (SELECT TOP 1 idEstado
                           FROM Estado
                           ORDER BY idEstado DESC)

    INSERT INTO Det_domicilio VALUES (@DESTINO_ESTADO, @DESTINO_COLONIA, @DESTINO_DOMICILIO, @DESTINO_CIUDAD)

    SET @DESTINO_DET_DOMICILIO = (SELECT TOP 1 idDetDomicilio
                                  FROM Det_domicilio
                                  ORDER BY idDetDomicilio DESC)
    INSERT INTO Dir_origen_destino
    VALUES (6, @DESTINO_DET_DOMICILIO, @PACKAGEID, @CLIENTID, 'Destino')
    -- ==================================================
    -- ========================== RASTREO ==============
    INSERT INTO Localizacion VALUES (@ORIGIN)
    INSERT INTO Transporte VALUES (@TRANSPORT)

    SET @TRANSPORTID = (SELECT TOP 1 idTransporte
                        FROM Transporte
                        ORDER BY idTransporte DESC)
    SET @ORIGEN_LOCALIZACION = (SELECT TOP 1 idLocalizacion
                                FROM Localizacion
                                ORDER BY idLocalizacion DESC)
    INSERT INTO Rastreo VALUES (@PACKAGEID, @CLIENTID, @EMPLOYEEID, @ORIGEN_LOCALIZACION, @TRANSPORTID, @FOILNUMBER)
  END
GO
/****** Object:  StoredProcedure [dbo].[spDelClient]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spDelClient]
  @delIDclient INT
AS
BEGIN
  DECLARE @ClientID INT, @PhoneID INT, @EmailID INT
  SET @ClientID = (SELECT TOP 1 idCliente
                   FROM Det_cliente
                   WHERE idCliente = @delIDclient)
  UPDATE cliente
  SET Estatus = CURRENT_TIMESTAMP
  WHERE idCliente = @ClientID;
END
GO
/****** Object:  StoredProcedure [dbo].[spDelEmail]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spDelEmail]
    @ID INT
AS
  BEGIN
    DELETE FROM Email_cliente
    WHERE @ID = idEmail
    DELETE FROM Email
    WHERE @ID = Email.idEmail
  END
GO
/****** Object:  StoredProcedure [dbo].[spDelEmployee]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spDelEmployee]
    @delID INT
AS
  BEGIN
    UPDATE Empleado
    SET Estatus = CURRENT_TIMESTAMP
    WHERE idEmpleado = @delID;
  END
GO
/****** Object:  StoredProcedure [dbo].[spDelEmployeeEmail]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spDelEmployeeEmail]
    @ID INT
AS
  BEGIN
    DELETE FROM Email_empleado
    WHERE @ID = idEmail
    DELETE FROM Email
    WHERE @ID = Email.idEmail
  END
GO
/****** Object:  StoredProcedure [dbo].[spDelPhone]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spDelPhone]
    @ID INT
AS
  BEGIN
    DELETE FROM Det_cliente
    WHERE @ID = idTelefono
    DELETE FROM Telefono
    WHERE @ID = Telefono.idTelefono
  END
GO
/****** Object:  StoredProcedure [dbo].[spDelService]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spDelService]
    @ID_PAQUETE INT
AS
  BEGIN
    UPDATE Paquete
    SET Estatus = CURRENT_TIMESTAMP
    WHERE idPaquete = @ID_PAQUETE;
  END
GO
/****** Object:  StoredProcedure [dbo].[spEditClient]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spEditClient]
    @ID         INT,
    @EditedName VARCHAR(50),
    @APP        VARCHAR(50),
    @APM        VARCHAR(50)
AS
  BEGIN
    UPDATE Cliente
    SET Nombre = @EditedName, Apeido_Paterno = @APP, Apeido_Materno = @APM
    WHERE @ID = idCliente
  END
GO
/****** Object:  StoredProcedure [dbo].[spEditEmail]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spEditEmail]
    @ID                     INT,
    @editedEmail            VARCHAR(50),
    @editedEmailDescription VARCHAR(50)
AS
  BEGIN
    UPDATE Email
    SET Correo = @editedEmail, Email.Descripcion = @editedEmailDescription
    WHERE idEmail = @ID
  END
GO
/****** Object:  StoredProcedure [dbo].[spEditEmployee]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spEditEmployee]
    @ID         INT,
    @EditedName VARCHAR(50),
    @APP        VARCHAR(50),
    @APM        VARCHAR(50),
    @EditedTurn VARCHAR(20)
AS
  BEGIN
    UPDATE Empleado
    SET Nombre = @EditedName, Apellido_Paterno = @APP, Apellido_Materno = @APM, Turno = @EditedTurn
    WHERE @ID = idEmpleado
  END
GO
/****** Object:  StoredProcedure [dbo].[spEditLocation]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spEditLocation]
    @ID_ARG      INT,
    @newLocation VARCHAR(50)
AS
  BEGIN
    UPDATE Localizacion
    SET Localizacion = @newLocation
    WHERE idLocalizacion = @ID_ARG;
  END
GO
/****** Object:  StoredProcedure [dbo].[spEditPhone]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spEditPhone]
    @ID                  INT,
    @NewPhone            VARCHAR(50),
    @NewPhoneDescription VARCHAR(50)
AS
  BEGIN
    UPDATE Telefono
    SET Numero = @NewPhone, Telefono.Descripcion = @NewPhoneDescription
    WHERE idTelefono = @ID
  END
GO
/****** Object:  StoredProcedure [dbo].[spFindTracking]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spFindTracking]
  @TRACKINGCODE VARCHAR(50)
AS
BEGIN
  DECLARE @LOCALIZACION_DESTINO VARCHAR(50)

  SET @LOCALIZACION_DESTINO = (SELECT TOP 1 Estado.Estado
                               FROM Cliente
                                 INNER JOIN Rastreo ON Cliente.idCliente = Rastreo.idCliente
                                 INNER JOIN Transporte ON Transporte.idTransporte = Rastreo.idTransporte
                                 INNER JOIN Localizacion ON Rastreo.idLocalizacion = Localizacion.idLocalizacion
                                 INNER JOIN Paquete ON Rastreo.idPaquete = Paquete.idPaquete
                                 INNER JOIN Empleado ON Rastreo.idEmpleado = Empleado.idEmpleado
                                 INNER JOIN Dir_origen_destino ON Cliente.idCliente = Dir_origen_destino.idCliente
                                 INNER JOIN Det_domicilio
                                   ON Dir_origen_destino.idDetDomicilio = Det_domicilio.idDetDomicilio
                                 INNER JOIN Estado ON Det_domicilio.idEstado = Estado.idEstado
                               WHERE Rastreo.Folio = @TRACKINGCODE AND Dir_origen_destino.od = 'Destino' AND
                                     Paquete.Estatus IS NULL)
  SELECT DISTINCT
    Rastreo.Folio,
    Estado.Estado,
    Localizacion.Localizacion,
    Cliente.Nombre,
    Paquete.Descripcion,
    Empleado.Nombre,
    @LOCALIZACION_DESTINO,
    Transporte.Tipo,
    Paquete.Prioridad,
    Paquete.Peso
  FROM Cliente
    INNER JOIN Rastreo ON Cliente.idCliente = Rastreo.idCliente
    INNER JOIN Transporte ON Transporte.idTransporte = Rastreo.idTransporte
    INNER JOIN Localizacion ON Rastreo.idLocalizacion = Localizacion.idLocalizacion
    INNER JOIN Paquete ON Rastreo.idPaquete = Paquete.idPaquete
    INNER JOIN Empleado ON Rastreo.idEmpleado = Empleado.idEmpleado
    INNER JOIN Dir_origen_destino ON Cliente.idCliente = Dir_origen_destino.idCliente
    INNER JOIN Det_domicilio ON Dir_origen_destino.idDetDomicilio = Det_domicilio.idDetDomicilio
    INNER JOIN Estado ON Det_domicilio.idEstado = Estado.idEstado
  WHERE Rastreo.Folio = @TRACKINGCODE AND Dir_origen_destino.od = 'Origen' AND Paquete.Estatus IS NULL
END
GO
/****** Object:  StoredProcedure [dbo].[spInsertClient]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spInsertClient]
  @NAME             VARCHAR(50),
  @APP              VARCHAR(50),
  @APM              VARCHAR(50),
  @PHONENUMBER      VARCHAR(50),
  @PHONEDESCRIPTION VARCHAR(50),
  @EMAILADDRESS     VARCHAR(50),
  @EMAILDESCRIPTION VARCHAR(50)
AS
BEGIN
  INSERT INTO Cliente VALUES (@NAME, @APP, @APM, NULL);
  INSERT INTO Telefono VALUES (@PHONENUMBER, @PHONEDESCRIPTION);
  INSERT INTO Email VALUES (@EMAILADDRESS, @EMAILDESCRIPTION)
  DECLARE @lastClientID INT, @lastPhoneID INT, @lastEmailID INT
  SET @lastClientID = (SELECT TOP 1 idCliente
                       FROM Cliente
                       ORDER BY idCliente DESC)
  SET @lastPhoneID = (SELECT TOP 1 idTelefono
                      FROM Telefono
                      ORDER BY idTelefono DESC)
  SET @lastEmailID = (SELECT TOP 1 idEmail
                      FROM Email
                      ORDER BY idEmail DESC)
  INSERT INTO Det_cliente VALUES (@lastClientID, @lastPhoneID);
  INSERT INTO Email_cliente VALUES (@lastEmailID, @lastClientID);
END
GO
/****** Object:  StoredProcedure [dbo].[spInsertEmployee]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spInsertEmployee]
    @NAME             VARCHAR(50),
    @APP              VARCHAR(50),
    @APM              VARCHAR(50),
    @EMAILADDRESS     VARCHAR(50),
    @EMAILDESCRIPTION VARCHAR(50),
    @TURN             VARCHAR(20)
AS
  BEGIN
    INSERT INTO Empleado VALUES (@NAME, @APP, @APM, @TURN, NULL);
    INSERT INTO Email VALUES (@EMAILADDRESS, @EMAILDESCRIPTION)
    DECLARE @lastEmployeeID INT, @lastEmailID INT
    SET @lastEmployeeID = (SELECT TOP 1 idEmpleado
                           FROM Empleado
                           ORDER BY idEmpleado DESC)
    SET @lastEmailID = (SELECT TOP 1 idEmail
                        FROM Email
                        ORDER BY idEmail DESC)
    INSERT INTO Email_empleado VALUES (@lastEmailID, @lastEmployeeID);
  END
GO
/****** Object:  StoredProcedure [dbo].[spListClient]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spListClient]
AS
BEGIN
  SELECT DISTINCT
    Cliente.idCliente,
    Nombre,
    Apeido_Paterno,
    Apeido_Materno
  FROM Cliente
  WHERE Estatus IS NULL
END
GO
/****** Object:  StoredProcedure [dbo].[spListClientEmails]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spListClientEmails]
    @ID_ARG INT
AS
  BEGIN
    SELECT
      Email.idEmail,
      Correo,
      Email.Descripcion
    FROM Cliente
      INNER JOIN Email_cliente
        ON Cliente.idCliente = Email_cliente.idCliente AND Estatus IS NULL AND Cliente.idCliente = @ID_ARG
      INNER JOIN Email ON Email_cliente.idEmail = Email.idEmail
  END
GO
/****** Object:  StoredProcedure [dbo].[spListClientPhones]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spListClientPhones]
  @ID_ARG INT
AS
BEGIN
  SELECT
    Telefono.idTelefono,
    Numero,
    Telefono.Descripcion
  FROM Cliente
    INNER JOIN Det_cliente
      ON Cliente.idCliente = Det_cliente.idCliente AND Estatus IS NULL AND Cliente.idCliente = @ID_ARG
    INNER JOIN Telefono ON Det_cliente.idTelefono = Telefono.idTelefono
END
GO
/****** Object:  StoredProcedure [dbo].[spListEmployee]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spListEmployee]
AS
BEGIN
  SELECT DISTINCT
    Empleado.idEmpleado,
    Empleado.Nombre,
    Empleado.Apellido_Paterno,
    Empleado.Apellido_Materno,
    Empleado.Turno
  FROM Empleado
  WHERE Estatus IS NULL
END
GO
/****** Object:  StoredProcedure [dbo].[spListEmployeeEmails]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spListEmployeeEmails]
    @ID_ARG INT
AS
  BEGIN
    SELECT
      Email.idEmail,
      Correo,
      Email.Descripcion
    FROM Empleado
      INNER JOIN Email_empleado
        ON Empleado.idEmpleado = Email_empleado.idEmpleado AND Estatus IS NULL AND Empleado.idEmpleado = @ID_ARG
      INNER JOIN Email ON Email_empleado.idEmail = Email.idEmail
  END
GO
/****** Object:  StoredProcedure [dbo].[spListServices]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spListServices]
AS
BEGIN
  SELECT DISTINCT
    Paquete.idPaquete,
    Paquete.Descripcion,
    Cliente.Nombre,
    Localizacion.Localizacion,
    Empleado.Nombre,
    Localizacion.idLocalizacion
  FROM Cliente
    INNER JOIN Rastreo ON Cliente.idCliente = Rastreo.idCliente
    INNER JOIN Transporte ON Transporte.idTransporte = Rastreo.idTransporte
    INNER JOIN Localizacion ON Rastreo.idLocalizacion = Localizacion.idLocalizacion
    INNER JOIN Paquete ON Rastreo.idPaquete = Paquete.idPaquete
    INNER JOIN Empleado ON Rastreo.idEmpleado = Empleado.idEmpleado
    INNER JOIN Dir_origen_destino ON Cliente.idCliente = Dir_origen_destino.idCliente
    INNER JOIN Det_domicilio ON Dir_origen_destino.idDetDomicilio = Det_domicilio.idDetDomicilio
    INNER JOIN Estado ON Det_domicilio.idEstado = Estado.idEstado
  WHERE Paquete.Estatus IS NULL
END
GO
/****** Object:  StoredProcedure [dbo].[spRepeatedClient]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spRepeatedClient]
    @NAME VARCHAR(50),
    @APP  VARCHAR(50),
    @APM  VARCHAR(50)
AS
  BEGIN
    SELECT
      Nombre,
      Apeido_Paterno,
      Apeido_Materno
    FROM Cliente
    WHERE Cliente.Nombre = @NAME AND Cliente.Apeido_Paterno = @APP AND Cliente.Apeido_Materno = @APM AND
          Cliente.Estatus IS NULL
  END
GO
/****** Object:  StoredProcedure [dbo].[spRepeatedEmployee]    Script Date: 06/12/2016 01:33:51 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[spRepeatedEmployee]
  @NAME VARCHAR(50),
  @APP  VARCHAR(50),
  @APM  VARCHAR(50)
AS
BEGIN
  SELECT
    Nombre,
    Apellido_Paterno,
    Apellido_Materno
  FROM Empleado
  WHERE Nombre = @NAME AND Apellido_Paterno = @APP AND Apellido_Materno = @APM AND
        Estatus IS NULL
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Login', @level2type=N'COLUMN',@level2name=N'CreatedAt'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Login', @level2type=N'COLUMN',@level2name=N'LastLogin'
GO

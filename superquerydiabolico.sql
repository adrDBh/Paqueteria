CREATE PROCEDURE spCreateService
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
    @FOILNUMBER           VARCHAR(20),
    -- COSTO TOTAL
    @COST                 VARCHAR(15)
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
    @DESTINO_LOCALIZACION INT

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

    INSERT INTO Localizacion VALUES (@ORIGEN_ESTADO)

    SET @ORIGEN_LOCALIZACION = (SELECT TOP 1 idLocalizacion
                                FROM Localizacion
                                ORDER BY idLocalizacion DESC)
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

    INSERT INTO Localizacion VALUES (@ORIGEN_ESTADO)

    SET @destino_LOCALIZACION = (SELECT TOP 1 idLocalizacion
                                 FROM Localizacion
                                 ORDER BY idLocalizacion DESC)
    INSERT INTO Dir_origen_destino
    VALUES (6, @DESTINO_DET_DOMICILIO, @PACKAGEID, @CLIENTID, 'Destino')
    -- ==================================================
    -- ========================== RASTREO ==============
    INSERT INTO Rastreo VALUES ()

  END
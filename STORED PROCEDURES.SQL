-- INSERTAR UN CLIENTE
CREATE PROCEDURE spInsertClient
  @NAME             VARCHAR(50),
  @APP              VARCHAR(50),
  @APM              VARCHAR(50),
  @PHONENUMBER      VARCHAR(50),
  @PHONEDESCRIPTION VARCHAR(50),
  @EMAILADDRESS     VARCHAR(50),
  @EMAILDESCRIPTION VARCHAR(50)
AS
BEGIN
  INSERT INTO Cliente VALUES (@NAME, @APP, @APM);
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
-- LISTAR CLIENTES
CREATE PROCEDURE spListClient
AS
BEGIN
  SELECT
    Cliente.idCliente,
    Nombre,
    Apeido_Paterno,
    Apeido_Materno,
    Numero,
    Telefono.Descripcion,
    Correo,
    Email.Descripcion
  FROM Cliente
    INNER JOIN Det_cliente ON Cliente.idCliente = Det_cliente.idCliente AND Estatus IS NULL
    INNER JOIN Telefono ON Det_cliente.idTelefono = Telefono.idTelefono
    INNER JOIN Email_cliente ON Cliente.idCliente = Email_cliente.idCliente
    INNER JOIN Email ON Email_cliente.idEmail = Email.idEmail
END
GO

-- EDITAR CLIENTE
CREATE PROCEDURE spEditClient
    @idCliente        INT,
    @NAME             VARCHAR(50),
    @APP              VARCHAR(50),
    @APM              VARCHAR(50),
    @PHONENUMBER      VARCHAR(50),
    @PHONEDESCRIPTION VARCHAR(50),
    @EMAILADDRESS     VARCHAR(50),
    @EMAILDESCRIPTION VARCHAR(50)
AS
  BEGIN
    DECLARE @ClientID INT, @PhoneID INT, @EmailID INT
    SET @ClientID = (SELECT idCliente
                     FROM Det_cliente
                     WHERE idCliente = @idCliente)
    SET @PhoneID = (SELECT idTelefono
                    FROM Det_cliente
                    WHERE idCliente = @idCliente)
    SET @EmailID = (SELECT idEmail
                    FROM Email_cliente
                    WHERE idCliente = @idCliente);
    UPDATE Cliente
    SET Nombre = @NAME, Apeido_Paterno = @APP, Apeido_Materno = @APM
    WHERE idCliente = @ClientID
    UPDATE Telefono
    SET Numero = @PHONENUMBER, Descripcion = @PHONEDESCRIPTION
    WHERE idTelefono = @PhoneID
    UPDATE Email
    SET Correo = @EMAILADDRESS, Descripcion = @EMAILDESCRIPTION
    WHERE idEmail = @EmailID
  END
 -- BORRAR LÓGICAMENTE UN CLIENTE
 CREATE PROCEDURE spDelClient
  @delIDclient INT
AS
BEGIN
  DECLARE @ClientID INT, @PhoneID INT, @EmailID INT
  SET @ClientID = (SELECT idCliente
                   FROM Det_cliente
                   WHERE idCliente = @delIDclient)
  SET @PhoneID = (SELECT idTelefono
                  FROM Det_cliente
                  WHERE idCliente = @delIDclient)
  SET @EmailID = (SELECT idEmail
                  FROM Email_cliente
                  WHERE idCliente = @delIDclient);
  UPDATE cliente
  SET Estatus = CURRENT_TIMESTAMP
  WHERE idCliente = @ClientID;
END
GO


-- Seleccionar datos de rastreo..
SELECT
  Nombre,
  Apeido_Paterno,
  Apeido_Materno,
  Numero,
  Telefono.Descripcion,
  Paquete.Descripcion,
  Email.Correo,
  Email.Descripcion,
  Fragil,
  Prioridad,
  Peso,
  Alto,
  Ancho,
  Largo,
  Localizacion,
  Zona_horaria,
  od,
  Calle,
  No_Int,
  No_Ext,
  Colonia,
  Ciudad,
  Estado,
  CP
FROM Cliente
  INNER JOIN Dir_origen_destino ON Dir_origen_destino.idCliente = Cliente.idCliente
  INNER JOIN Paquete ON Dir_origen_destino.idPaquete = Paquete.idPaquete
  INNER JOIN Localizacion ON Dir_origen_destino.idLocalizacion = Localizacion.idLocalizacion
  INNER JOIN Zona_horaria ON Dir_origen_destino.idZH = Zona_horaria.idZH
  INNER JOIN Det_domicilio ON Dir_origen_destino.idDetDomicilio = Det_domicilio.idDetDomicilio
  INNER JOIN Domicilio ON Det_domicilio.idDomicilio = Domicilio.idDomicilio
  INNER JOIN Colonia ON Det_domicilio.idColonia = Colonia.idColonia
  INNER JOIN Ciudad ON Det_domicilio.idCiudad = Ciudad.idCiudad
  INNER JOIN estado ON Det_domicilio.idEstado = Estado.idEstado
  INNER JOIN Det_cliente ON Cliente.idCliente = Det_cliente.idCliente
  INNER JOIN Telefono ON Det_cliente.idTelefono = Telefono.idTelefono
  INNER JOIN Email_cliente ON Cliente.idCliente = Email_cliente.idCliente
  INNER JOIN Email ON Email_cliente.idEmail = Email.idEmail;

  -- seleccionar un cliente
  SELECT
  Nombre,
  Apeido_Paterno,
  Apeido_Materno,
  Numero,
  Telefono.Descripcion,
  Correo,
  Email.Descripcion
FROM Cliente
  INNER JOIN Det_cliente ON Cliente.idCliente = Det_cliente.idCliente
  INNER JOIN Telefono ON Det_cliente.idTelefono = Telefono.idTelefono
  INNER JOIN Email_cliente ON Cliente.idCliente = Email_cliente.idCliente
  INNER JOIN Email ON Email_cliente.idEmail = Email.idEmail
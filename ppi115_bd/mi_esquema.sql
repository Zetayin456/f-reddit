-- Initial schema matching the mapped Cafefe JPA entities.
-- Application code supplies UUID primary keys.
CREATE TABLE IF NOT EXISTS caja (id_caja uuid PRIMARY KEY, nombre varchar(155), activo boolean, observaciones text);
CREATE TABLE IF NOT EXISTS empleado (id_empleado uuid PRIMARY KEY, nombre varchar(255), apellido varchar(255), activo boolean, comentarios text);
CREATE TABLE IF NOT EXISTS rol (id_rol uuid PRIMARY KEY, nombre varchar(155), observaciones text, activo boolean);
CREATE TABLE IF NOT EXISTS tipo_caracteristica (id_tipo_caracteristica uuid PRIMARY KEY, nombre varchar(155), expresion_regular text, activo boolean, observaciones text);
CREATE TABLE IF NOT EXISTS tipo_descuento (id_tipo_descuento uuid PRIMARY KEY, nombre text, activo boolean, descuento_maximo integer, observaciones text);
CREATE TABLE IF NOT EXISTS tipo_producto (id_tipo_producto uuid PRIMARY KEY, nombre varchar(155), observaciones text, activo boolean);
CREATE TABLE IF NOT EXISTS producto (id_producto uuid PRIMARY KEY, nombre text, precio_sugerido numeric(8,2) NOT NULL, activo boolean, comentarios text);
CREATE TABLE IF NOT EXISTS caracteristica (id_caracteristica uuid PRIMARY KEY, nombre varchar(155), activo boolean, observaciones text, id_tipo_caracteristica uuid REFERENCES tipo_caracteristica(id_tipo_caracteristica));
CREATE TABLE IF NOT EXISTS descuento (id_descuento uuid PRIMARY KEY, id_tipo_descuento uuid REFERENCES tipo_descuento(id_tipo_descuento), nombre varchar(155), fecha_desde timestamp, fecha_hasta timestamp, observaciones text);
CREATE TABLE IF NOT EXISTS empleado_rol (id_empleado_rol uuid PRIMARY KEY, id_empleado uuid REFERENCES empleado(id_empleado), id_rol uuid REFERENCES rol(id_rol), activo boolean, observaciones text);
CREATE TABLE IF NOT EXISTS producto_caracteristica (id_producto_caracteristica uuid PRIMARY KEY, id_caracteristica uuid REFERENCES caracteristica(id_caracteristica), id_producto uuid REFERENCES producto(id_producto), valor text);
CREATE TABLE IF NOT EXISTS producto_tipo_producto (id_producto_tipo_producto uuid PRIMARY KEY, id_producto uuid REFERENCES producto(id_producto), id_tipo_producto uuid REFERENCES tipo_producto(id_tipo_producto), fecha_creacion timestamp, observaciones text);
CREATE TABLE IF NOT EXISTS descuento_producto (id_descuento_producto uuid PRIMARY KEY, fecha_desde timestamp, fecha_hasta timestamp, valor integer, observaciones text, id_descuento uuid REFERENCES descuento(id_descuento), id_producto uuid REFERENCES producto(id_producto));
CREATE TABLE IF NOT EXISTS orden (id_orden uuid PRIMARY KEY, fecha_creacion timestamp, id_empleado_rol uuid REFERENCES empleado_rol(id_empleado_rol));
CREATE TABLE IF NOT EXISTS orden_producto (id_orden_producto uuid PRIMARY KEY, observaciones text, precio numeric(12,2), id_orden uuid REFERENCES orden(id_orden), id_producto uuid REFERENCES producto(id_producto));
CREATE TABLE IF NOT EXISTS factura (id_factura uuid PRIMARY KEY, cliente text, estado text, observaciones text, fecha_facturacion timestamp, id_caja uuid REFERENCES caja(id_caja), id_empleado_rol uuid REFERENCES empleado_rol(id_empleado_rol));
CREATE TABLE IF NOT EXISTS factura_orden_producto (id_factura_orden_producto uuid PRIMARY KEY, observaciones text, precio numeric(12,2), id_factura uuid REFERENCES factura(id_factura), id_orden_producto uuid REFERENCES orden_producto(id_orden_producto));
CREATE TABLE IF NOT EXISTS pago (id_pago uuid PRIMARY KEY, estado text, observaciones text, id_factura uuid REFERENCES factura(id_factura));
CREATE TABLE IF NOT EXISTS pago_detalle (id_pago_detalle uuid PRIMARY KEY, tipo_pago text, observaciones text, referencia_externa text, monto numeric(12,2), id_pago uuid REFERENCES pago(id_pago));

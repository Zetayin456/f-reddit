# Pruebas del cliente frontend

Las librerías de navegador están vendorizadas en `test/js/lib/` para poder
ejecutar los runners sin CDN ni `node_modules` dentro de la aplicación.

## Prueba unitaria

Abre `http://localhost:9080/cafeteria_pos/test/caja_test.html` con la aplicación
desplegada. Mocha usa la interfaz TDD y Sinon sustituye `window.fetch` con una
respuesta JSON de ejemplo que incluye `total-registros`.

## Prueba de integración

Abre `http://localhost:9080/cafeteria_pos/test/caja_it.html` con Open Liberty y
la base de datos disponibles. La prueba usa `fetch` real contra
`/resources/v1/cajas`; el endpoint pagina registros y expone el total mediante
la cabecera `total-registros`.

Si el servidor usa otro host, puerto o contexto, se puede indicar el prefijo de
la API con el parámetro `api`, por ejemplo:
`caja_it.html?api=http://localhost:9080/cafeteria_pos/resources/v1/`.

Versiones de las librerías: Mocha 10.8.2, Chai 4.5.0 y Sinon 17.0.1. Cada
directorio incluye el archivo de licencia correspondiente.

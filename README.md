# Cafefe - Jakarta EE 11 POS System

## English

Cafefe is a keyboard-focused point-of-sale system for coffee shops, designed for fast cashier workflows and informed by the KLM-GOMS keystroke-level model. The project uses Java 21, PrimeFaces 14, PostgreSQL 16, and Open Liberty. **Compatibility note:** the current `pom.xml` and Liberty configuration target Jakarta EE 10; the title reflects the requested project direction, not the current platform level.

### Quick Start

Requirements: Java 21, Maven, and Docker Compose.

1. Start the database and pgAdmin:

   ```sh
   cd ppi115_bd && docker compose up -d
   ```

2. The schema is mounted as a PostgreSQL initialization script and is applied automatically when the database volume is first created. To apply it manually to an existing empty database:

   ```sh
   docker exec -i postgres_ppi115 psql -U postgres -d pos_ppi115 < ppi115_bd/mi_esquema.sql
   ```

3. From the project root, start the application:

   ```sh
   mvn liberty:dev
   ```

   Open <http://localhost:9080/cafeteria_pos/>.

Database demo settings are `postgres` / `postgrespassword`, database `pos_ppi115`, port `5432`. These values are for local development only. Liberty connection values can be supplied through environment variables; see `server.env.example`.

### Feedback for the Reddit community

We would appreciate feedback on:

- Jakarta EE architecture and a path to Jakarta EE 11 compatibility.
- UI/UX improvements for high-volume cashier workflows.
- Keyboard shortcuts and PrimeFaces `<p:hotkey>` patterns that work well in production.

## Español

Cafefe es un sistema de punto de venta enfocado en el uso del teclado para cafeterías, diseñado para agilizar el trabajo de caja y basado en el modelo de pulsaciones KLM-GOMS. El proyecto utiliza Java 21, PrimeFaces 14, PostgreSQL 16 y Open Liberty. **Nota de compatibilidad:** el `pom.xml` y la configuración actual de Liberty usan Jakarta EE 10; el título refleja la dirección solicitada, no el nivel de plataforma configurado actualmente.

### Guía de Inicio Rápido

Requisitos: Java 21, Maven y Docker Compose.

1. Iniciar la base de datos y pgAdmin:

   ```sh
   cd ppi115_bd && docker compose up -d
   ```

2. El esquema se monta como script de inicialización y PostgreSQL lo aplica automáticamente al crear el volumen por primera vez. Para cargarlo manualmente en una base existente y vacía:

   ```sh
   docker exec -i postgres_ppi115 psql -U postgres -d pos_ppi115 < ppi115_bd/mi_esquema.sql
   ```

3. Desde la raíz del proyecto, iniciar la aplicación:

   ```sh
   mvn liberty:dev
   ```

   Abrir <http://localhost:9080/cafeteria_pos/>.

La configuración de demostración de la base de datos es `postgres` / `postgrespassword`, base `pos_ppi115`, puerto `5432`. Estos valores son solo para desarrollo local. Las variables de conexión de Liberty se pueden definir por entorno; consulta `server.env.example`.

### Comentarios para la comunidad de Reddit

Nos interesa recibir comentarios sobre:

- La arquitectura Jakarta EE y una ruta de actualización a Jakarta EE 11.
- Mejoras de UI/UX para operaciones de caja de alto volumen.
- Atajos de teclado y patrones de PrimeFaces `<p:hotkey>` adecuados para producción.

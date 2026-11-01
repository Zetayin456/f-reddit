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

#### English
We would love to get your feedback and opinions on the following areas:

1. **Full UI/UX & Visual Design:**
   * Review of **all views and forms** across the app (not just the cashier screen).
   * Visual layout, usability, and suggestions to make the interface cleaner, more intuitive, and comfortable for daily use.

2. **Code Quality & Architecture:**
   * General review of the codebase (Managed Beans, Controllers, Services, Entities).
   * Best practices, code structure, readability, and overall maintainability.

3. **User Efficiency & Keyboard Navigation:**
   * Effective use of keyboard shortcuts (`p:hotkey`) and PrimeFaces component patterns in production.

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

#### Español
Nos encantaría recibir tus comentarios e impresiones sobre los siguientes puntos:

1. **Diseño Visual y UI/UX (Todas las Vistas):**
   * Opinión sobre **todas las pantallas y formularios** del sistema (no solo la caja).
   * Distribución visual, comodidad de uso y sugerencias para hacer la interfaz más intuitiva, limpia y ágil.

2. **Calidad del Código:**
   * Revisión general de la estructura del código (Beans, Controladores, Servicios, Entidades).
   * Buenas prácticas en Java/Jakarta EE, legibilidad y sugerencias para mejorar la mantenibilidad.

3. **Eficiencia y Atajos de Teclado:**
   * Uso de atajos (`p:hotkey`) y patrones de componentes de PrimeFaces para mejorar la experiencia de usuario.

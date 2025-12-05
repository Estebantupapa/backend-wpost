# Backend WPost - API REST

API REST para gestión de productos con autenticación JWT.

## Tecnologías
- Java 21
- Spring Boot 3.5.8
- Spring Security con JWT
- Spring Data JPA
- PostgreSQL 18
- Swagger/OpenAPI 3

## Instalación
1. Clonar repositorio.
2. Crear base de datos PostgreSQL: `backend_wpost`
3. Configurar `application.yml` con credenciales
4. Ejecutar.

## Endpoints principales

### Autenticación
- `POST /api/auth/register` - Registrar usuario
- `POST /api/auth/login` - Login (obtener JWT)

### Productos
- `POST /api/products` - Crear producto (Requiere JWT)
- `GET /api/products/public/all` - Listar productos (Público)
- `GET /api/products/public/{id}` - Obtener producto por ID (Público)
- `PUT /api/products/{id}` - Actualizar producto (Requiere JWT)
- `DELETE /api/products/{id}` - Eliminar producto (Requiere JWT)

### Nota
- Probar Endpoints con Postman, Swagger no funcionó.

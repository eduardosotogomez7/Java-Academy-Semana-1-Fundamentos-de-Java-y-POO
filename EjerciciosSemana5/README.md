# EjerciciosSemana5 – Spring Boot API

## Descripción

Este proyecto es una API REST desarrollada con **Spring Boot** como parte de un ejercicio académico para practicar el desarrollo de servicios backend con Java.
La aplicación permite gestionar **clientes, órdenes y productos**, utilizando **Spring Data JPA** y una base de datos **H2 en memoria**.

El objetivo principal fue practicar:

* Modelado de entidades con JPA
* Relaciones entre entidades
* Creación de repositorios con Spring Data
* Implementación de lógica de negocio en servicios
* Exposición de endpoints REST
* Validaciones con Bean Validation
* Manejo global de excepciones
* Pruebas unitarias con JUnit y Mockito
* Pruebas de la API usando Postman

---

## Tecnologías utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* H2 Database
* Maven
* JUnit 5
* Mockito
* Postman

---

## Cómo ejecutar el proyecto

1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/tu-repo.git
```

2. Entrar al proyecto

```bash
cd EjerciciosSemana5
```

3. Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La API se iniciará en:

```
http://localhost:8080
```

---

## Consola de base de datos H2

La consola H2 está disponible en:

```
http://localhost:8080/h2-console
```

Configuración:

| Campo    | Valor              |
| -------- | ------------------ |
| JDBC URL | jdbc:h2:mem:testdb |
| User     | sa                 |
| Password | (vacío)            |

---

## Endpoints principales

### Customers

| Método | Endpoint            | Descripción                |
| ------ | ------------------- | -------------------------- |
| GET    | /api/customers      | Obtener todos los clientes |
| GET    | /api/customers/{id} | Obtener un cliente por ID  |
| POST   | /api/customers      | Crear un nuevo cliente     |
| DELETE | /api/customers/{id} | Eliminar un cliente        |

Ejemplo de request para crear cliente:

```json
{
  "name": "Carlos",
  "email": "carlos@email.com"
}
```

---

### Orders

| Método | Endpoint         | Descripción               |
| ------ | ---------------- | ------------------------- |
| GET    | /api/orders      | Obtener todas las órdenes |
| GET    | /api/orders/{id} | Obtener una orden por ID  |
| POST   | /api/orders      | Crear una nueva orden     |
| DELETE | /api/orders/{id} | Eliminar una orden        |

---

### Products

| Método | Endpoint           | Descripción                 |
| ------ | ------------------ | --------------------------- |
| GET    | /api/products      | Obtener todos los productos |
| GET    | /api/products/{id} | Obtener un producto por ID  |
| POST   | /api/products      | Crear un producto           |
| DELETE | /api/products/{id} | Eliminar un producto        |

---

## Manejo de errores

El proyecto incluye un **GlobalExceptionHandler** que maneja errores comunes de la API:

| Código | Descripción                               |
| ------ | ----------------------------------------- |
| 400    | Error de validación en los datos enviados |
| 404    | Recurso no encontrado                     |
| 500    | Error interno del servidor                |

Ejemplo de respuesta de error:

```json
{
  "error": "Customer not found"
}
```

---

## Tests

El proyecto incluye **pruebas unitarias** para servicios y controladores utilizando:

* JUnit 5
* Mockito

Para ejecutar los tests:

```bash
mvn test
```

---

## Pruebas con Postman

La colección de Postman utilizada para probar los endpoints se encuentra en:

```
/postman/EjerciciosSemana5.postman_collection.json
```

Esta colección incluye ejemplos de requests para probar todos los endpoints principales de la API.

---



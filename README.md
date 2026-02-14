# Academia Java Semana 1 Eduardo Soto Gómez

# Ejercicios prácticos



Repositorio personal de ejercicios realizados durante la primera semana de JAva Academy,
enfocados en 
**reforzar fundamentos de Java y Programación Orientada a Objetos (POO)**

---

## Temas Cubiertos

En este proyecto se abordan los siguientes temas

1. **Java class structure, packages, imports**
2. **Tipos primitivos vs referencia, operadores, control de flujo**
3. **String, acces modifiers**
4. **StringBuilder, arrays, ArrayList, wrapper classes**
5. **Constructores, encapsulamiento, herencia**
6. **Clases abstractas, interfaces, polimorfismo**
7. **equals(), hashCode(), toString(), instanceOf**

## Estructura del Proyecto

Este poryecto sigue una estructura organizada por **paquetes** dentro de 'src/com/eduardo/ejerciciosSemanaUno'

Cada paquete corresponde a cada ejercicio realizado y cada uno de estos tiene su propio método main para probar el código de cada ejercicio por separado


## Objetivo del proyecto

EL objetivo de este proyecto es reforzar conceptos fundamentales de Java y POO y aplicarlos de manera adecuada, a travez de una organización clara del proyecto

## Como ejecutar

1. Abrir el proyecto en un IDE compatible
2. Navegar al paquete del ejercicio que se desea ejecutar
3. Ejecutar la clase que contenga el método main
4. Revisar resultados en la consola


# Proyecto CRUD de Álbumes de Música con Spring Boot

Este proyecto es un ejemplo de una **API REST** para gestionar álbumes de música, usando **Spring Boot**, **Spring Data JPA** y **MySQL**. Permite realizar operaciones CRUD: Crear, Leer, Actualizar y Eliminar álbumes.

---

## 1. Descripción de la entidad

La entidad principal es **Album**, con los siguientes atributos:

- `id` (Long) – identificador único, autogenerado
- `artista` (String) – nombre del artista o banda
- `anioLanzamiento` (int) – año de lanzamiento
- `cantidadCanciones` (int) – número de canciones del álbum
- `duracionTotal` (int) – duración total en minutos

---

## 2. Estructura del proyecto

El proyecto sigue la arquitectura de **4 capas**:

- **Entity** – clases que representan las tablas de la base de datos (`Album.java`)
- **Repository** – interfaces que extienden `JpaRepository` (`AlbumRepository.java`)
- **Service** – lógica de negocio y llamadas al repositorio (`AlbumService.java`)
- **Controller** – endpoints REST para interactuar con los álbumes (`AlbumController.java`)

El paquete principal es `com.academia.restSpringMysqlAlbumes`.

---

## 3. Configuración de MySQL

El proyecto utiliza **Docker** para correr MySQL:

```bash
docker run --name mysql-academia -e MYSQL_ROOT_PASSWORD=root123 -p 3306:3306 -d mysql:8
docker start mysql-academia
```


La base de datos debe contener la tabla albumes con las columnas mencionadas.

## 4. Compilar y Ejecutar el Proyecto

Desde la carpeta del proyecto


```bash
mvn clean compile
mvn spring-boot:run
```

la aplicación se ejecuta en 

```bash
http://localhost:8080
```

## 5. Endpoints disponibles

Todos los endpoints están bajo la ruta base `/api/albumes`.

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| **GET** | `/api/albumes` | Listar todos los álbumes |
| **GET** | `/api/albumes/{id}` | Buscar un álbum por ID |
| **POST** | `/api/albumes` | Crear un nuevo álbum |
| **PUT** | `/api/albumes/{id}` | Actualizar un álbum existente |
| **DELETE** | `/api/albumes/{id}` | Eliminar un álbum |

> **Nota:** Los datos se envían en formato **JSON** para las peticiones **POST** y **PUT**.

## 6. Ejemplo de JSON para crear un álbum

```json
{
  "artista": "Pink Floyd",
  "anioLanzamiento": 1973,
  "cantidadCanciones": 10,
  "duracionTotal": 43
}
```



## 7. Ver los datos en la base de datos

Se puede consultar directamente en MySQL desde la terminal:

```bash
# Acceder al contenedor de MySQL
docker exec -it mysql-academia mysql -uroot -p

# Comandos dentro de la consola de MySQL
USE nombre_de_la_base;
SELECT * FROM albumes;
```

## 8. Notas importantes

* **Requisitos:** La aplicación requiere **Java 17** y **Maven**.
* **Persistencia:** Todo lo que se hace desde Postman modifica la base de datos real en MySQL.
* **Infraestructura:** Asegúrate de que el contenedor MySQL esté corriendo antes de iniciar la aplicación.
* **Códigos de respuesta:** Los endpoints devuelven códigos HTTP estándar:
    * `200 OK`: Petición exitosa.
    * `201 Created`: Recurso creado con éxito (POST).
    * `204 No Content`: Eliminación exitosa (DELETE).
    * `404 Not Found`: El ID buscado no existe.




# TechShop Ecommerce 

**TechShop** es una aplicación de comercio electrónico para la venta de productos tecnológicos (laptops, smartphones, tablets, etc.), desarrollada con **Spring Boot** y Java 17.

---

##  Funcionalidades Principales

- **Gestión de Productos**: CRUD completo de productos del catálogo
- **Gestión de Categorías**: Organización de productos por categorías con atributos dinámicos
- **Carrito de Compras**: Agregar, modificar y eliminar productos del carrito
- **Órdenes de Compra**: Creación y gestión de pedidos
- **Gestión de Usuarios**: Registro y administración de clientes
- **Carga**: Importación de productos desde archivos CSV usando Spring Batch
- **API REST**: Endpoints documentados con Swagger/OpenAPI

---

## Arquitectura del Proyecto

El proyecto se realizó con la siguiente arquitectura de Spring Boot:

```
├── controlador/    → Endpoints REST (capa de presentación)
├── servicio/       → Lógica de negocio
├── repositorio/    → Acceso a datos (JPA y MongoDB)
├── modelo/         → Entidades del dominio
├── config/         → Configuraciones de Spring
└── batch/          → Procesamiento por lotes
```

---

---

## Tecnologías Utilizadas

| Tecnología | Propósito                           |
|--------|-------------------------------------|
| **Spring Boot** | Framework principal                 |
| **Spring Data JPA** | Acceso a MySQL                      |
| **Spring Data MongoDB** | Acceso a MongoDB                    |
| **Spring Batch** | Carga desde CSV                     |
| **MySQL** | Base de datos relacional            |
| **MongoDB** | Base de datos NoSQL                 |
| **Swagger/OpenAPI** | Documentación de API                |
| **JUnit 5** | Framework de testing                |
| **Mockito** | Mocks para pruebas                  |
| **H2** | Base de datos en memoria para tests |
| **Maven** | Gestión de dependencias             |

---

## Bases de Datos Utilizadas

En este proyecto utilizamos **dos bases de datos diferentes**, cada una para un propósito:

###  **MySQL** (Base de Datos Relacional)
**¿Para qué sirve?**
MySQL es una base de datos relacional que organiza los datos en tablas con relaciones estrictas entre ellas. Nos ayuda cuando necesitamos garantizar la integridad de los datos y realizar transacciones complejas.

**¿Qué almacena en este proyecto?**
- **Usuarios** (`usuarios`): Información de los clientes
- **Órdenes** (`ordenes`): Pedidos de compra
- **Detalles de Órdenes** (`orden_detalle`): Productos incluidos en cada pedido
- **Carrito de Compras** (`carrito_items`): Items temporales en el carrito
- **Datos de Spring Batch**: Control de ejecución de jobs de importación

**¿Por qué usamos MySQL para estos datos?**
- Como mensionamos necesitamos **integridad referencial** es decir: Una orden debe pertenecer a un usuario válido
- Requierimos de **transacciones ACID**: Si falla una orden, todo debe revertirse
- Las relaciones son **fijas y estructuradas**: Usuario → Orden → DetalleOrden



###  **MongoDB** (Base de Datos NoSQL)
**¿Para qué sirve?**
MongoDB es una base de datos NoSQL orientada a documentos. Nos ayuda a almacenar datos en formato JSON flexible, es decir, sin necesidad de un esquema rígido. Nos ayuda para datos que pueden variar su estructura.

**¿Qué almacena en este proyecto?**
- **Productos** (colección `productos`): Catálogo de productos
- **Categorías** (colección `categorias`): Clasificación de productos

**¿Por qué usamos MongoDB para el catálogo?**
- **Coomo se mencionó, MongoDB nos va a permitir un esquema flexible**: Cada categoría de producto tiene atributos diferentes por ejemplo:
  - Laptops: `{ram: "16GB", procesador: "i7", pantalla: "15 pulgadas"}`
  - Smartphones: `{camara: "48MP", bateria: "5000mAh", pantalla: "6.5 pulgadas"}`
  - Tablets: `{almacenamiento: "256GB", pantalla: "10 pulgadas"}`
- **Necesitamos tener un buen rendimiento en lectura**: El catálogo se consulta frecuentemente
- **Nos ofrece escalabilidad**: Fácil de distribuir cuando el catálogo crece



### **Estrategia Híbrida**
Para nuestr proyecto cada tipo de dato usa la tecnología más adecuada a sus necesidades. Los datos transaccionales van a MySQL, y los datos del catálogo a MongoDB.

---

##  Spring Framework 

**Spring Boot** es un framework que nos va a ayudar a simplificar el desarrollo de neustra aplicación ya que nos proporciona una estructura organizada y elimina configuraciones repetitivas.

### Como utilizamos Spring en TechShop:

#### 1. **Inyección de Dependencias**
Spring nos ayuda a gestionar de manera automática la creación de objetos y sus dependencias.


#### 2. **Anotaciones**
Spring también identifica los componentes gracias a las anotaciones por ejemplo:

- `@SpringBootApplication`: Clase principal que arranca la aplicación
- `@RestController`: Define un controlador REST que maneja peticiones HTTP
- `@Service`: Marca la clase como lógica de negocio
- `@Repository`: Marca la clase como acceso a datos
- `@Configuration`: Clase con configuraciones personalizadas

#### 3. **Spring Data JPA para MySQL y para MongoDB**
Nos proporciona acceso a la base de datos sin necesidad de escribir SQL manualmente.

#### 4. **Spring Data MongoDB**
Similar a JPA, pero para MongoDB.


#### 5. **Autoconfiguración de Spring Boot**
Spring Boot detecta las dependencias en el archivo `pom.xml` y configura automáticamente:
- Servidor web embebido (Tomcat)
- Conexiones a MySQL y MongoDB
- Jackson para JSON
- Swagger para documentación

#### 6. **Spring Batch**
Este Framework nos ayuda a procesar grandes cantidades de datos de forma eficiente.

**¿Para qué lo usamos**
Nos permite cargar muchos productos desde un archivo CSV a MongoDB.

**Se hace de la siguiente manera:**
1. **Reader**: Lee el archivo `productos.csv`
2. **Processor**: Valida cada producto
3. **Writer**: Guarda los productos válidos en MongoDB

---

## Testing - JUnit y Mockito

En este proyecto implementamos pruebas automatizadas para garantizar la calidad del código.

### **JUnit 5**
JUnit nos permite escribir y ejecutar pruebas automatizadas.

**¿Cómo lo usamos?**
- Define los casos de prueba con la anotación `@Test`
- Verifica resultados con aserciones: `assertEquals()`, `assertTrue()`, etc.
- Organiza la preparación de datos con `@BeforeEach`


### **Mockito**
Mockito es una librería que utilizamos para crear "simulaciones" de objetos. Nos permite probar una clase de forma aislada, sin depender de bases de datos u otros servicios.

**¿Cómo la usamos?**

#### **1. Tests Unitarios de Servicios** 
Prueban la lógica de negocio sin acceder a la base de datos real al hacer esto podemos hacer pruebas más ráidas, aisladas y tener un control sobre todos los datos de prueba.


#### **2. Tests de Integración de Controladores** 

Estos prueban los endpoints REST simulando el servicio pero usando MockMvc real.


**¿Por qué usamos mocks?**
- De esta manera no necesitamos MongoDB ni MySQL corriendo durante las pruebas
- Controlamos exactamente qué devuelven los métodos simulados


### **Base de Datos H2 para Tests**
Para tests que requieren persistencia real, se usa **H2** la cual es una base de datos en memoria temporal que se crea al iniciar el test y se destruye al terminar.
Esto es muy bueno para nuestras pruebas porque es rápida, limpia y compatible con MySQL ya que tiene la misma sintaxis SQL.










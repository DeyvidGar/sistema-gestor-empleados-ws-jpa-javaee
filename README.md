# sistema-gestor-empleados-ws-jpa-javaee
Backend de Sistema gestor de empleados, Web service de empleados utilizando JavaEE con Java 8, Java Persistence Api como motor de persistencia en la base de datos.
## funcion:
Estos servicios web Crean, Consultan, Actualizan y Elimiana informacion de la base de datos, mediante la arquitectura ApiRest se establecieron los siguientes endpoints:
#### Consultar 
* Url: http://localhost:8080/personas
* Method: GET
* Descripcion: Lista todos los registros de la base de datos.
#### Consultar Por id 
* Url: http://localhost:8080/personas/{id}
* Method: GET
* Descripcion: Obtiene solo el registro con el id especificado en el path.
#### Guardar  
* Url: http://localhost:8080/personas
* Method: POST
* Descripcion: Guarda en la base de datos un nuevo registro mediante el cuerpo de la aplicacion en formato Json.
#### Actualizar
* Url: http://localhost:8080/personas/actualizar/{id}
* Method: PUT
* Descripcion: Encuentra por id, si el registro existe para posteriormente actualizar el registro.
#### Eliminar
* Url: http://localhost:8080/personas/eliminar/{id}
* Method: DELETE
* Descripcion: Busca el registro por su id, si el registro existe el registro es eliminado.
## Como se realizo:
Aplicando el sistema de capas en estos servicios:
* Capa de datos: cuenta con los patrones de diseño Dao, Dto, ademas de java beans, Entidades
* Capa de servicio: la capa de negocio o servicio establece el RestService de nuestra entidad, rutas, metodos, tipo de peticiones y recursos que puede generar y consumir.

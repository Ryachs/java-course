# java-course

Ejercicios Simples para familiarizarse con SPRING BOOT

## Etiquetas (Beans)

###### @Data:
Es una anotacion de atajo que agrupa las caracteristicas de `@ToString`, `@EqualsAndHashCode`, `@Getter/@Setter` y `@RequiredArgsConstructor`, Basicamente genera todo el modelo que se asocia normalmente a una clase POJO.
Si necesita establecer valores no predeterminados para cualquiera de estos parámetros, simplemente agregue esas anotaciones explícitamente es lo suficientemente inteligente como para diferir esas anotaciones. `@Setter` `@ToString` `@EqualsAndHashCode` `@RequiredArgsConstructorcallSuperincludeFieldNamesexclude` `@Data`.

###### @Controller
Es una especializacion de la clase `@Component`, que nos permite detectar de forma automatica las clases de implementacion a través del escaneo de classpath.

###### Ej:
```java
@Controller
@RequestMapping("movie")
public class MovieController {

    @GetMapping("/{id}", produces = "application/json")
    public @ResponseBody Movie getMovie(@PathVariable int id) {
        return findMovieById(id);
    }

    private Book findMovieById(int id) {
        // ...
    }
}
```
Anotamos el método de manejo de solicitudes con `@ResponseBody`. Esta anotación permite la serialización automática del objeto devuelto en HttpResponse .

###### @RestController()
 Esta es la otra version. incluye las anotaciones `@Controller` y `@ResponseBody`. Fasilitando la implementacion en el controller.
 
 ###### Ej:
```java
@RestController
@RequestMapping("")
public class MovieRestController {
    
    @GetMapping("/{id}", produces = "application/json")
    public Movie getMovie(@PathVariable int id) {
        return findMovieById(id);
    }

    private Movie findMovieById(int id) {
        // ...
    }
}
```
###### @RequestMapping()
la anotación se usa para asignar solicitudes web a los métodos de Spring Controller.

 ###### Ej:
```java 
@RestController
@RequestMapping("/api/movie")
public class MovieRestController {
    
    @GetMapping("/{id}", produces = "application/json")
    public Movie getMovie(@PathVariable int id) {
        return findMovieById(id);
    }

    private Movie findMovieById(int id) {
        // ...
    }
}
```
para pegarle al metodo getMovie necesitariamos generar la siguiente ruta en postman
```
http://localhost:8080/api/movie/{id}
http://localhost:8080/api/movie/85
```

###### @GetMapping()
Esta anotacion nos permite asignar el tipo de solicitud http a los metodos del controller, existen varias variantes como
`@PostMapping`, `@Putmapping`, `@DeleteMapping`.

###### @Service()
anota clases en la capa de servicio.
Marcamos beans con @Service para indicar que mantienen la lógica de negocio. Además de usarse en la capa de servicio, no hay ningún otro uso especial para esta anotación.

###### @Component()
es un estereotipo genérico para cualquier componente administrado por Spring.

###### @Repository
anota las clases en la capa de persistencia, que actuará como repositorio de la base de datos.
El trabajo de `@Repository` es capturar excepciones específicas de persistencia y volver a lanzarlas como una de las excepciones no verificadas unificadas de Spring.

###### @Entity
Indica que la clase es una entidad

###### @Table(name = "Contactos")
Indica que esta asociada a la tabla en database

###### @id
Indica que es un atributo id

###### @GeneratedValue(strategy=GenerationType.IDENTY)
estrategia de generacion de claves
cuando se inserten objetos en base de datos, lo identifica como que se genera automaticamente y no se debe incluir

###### @Async
anotar un método de un bean con `@Async` hará que se ejecute en un hilo separado. Esto quiere decir que el usuario que llama al servicio no esperará a que se complete el método llamado.

###### ResponseEntity<T>
ResponseEntity representa la respuesta HTTP completa: código de estado, encabezados y cuerpo . Como resultado, podemos usarlo para configurar completamente la respuesta HTTP.

###### @Email
Anotacion para definir un campo de un objeto como email, nos permite realizar vilidaciones del campo de texto
 ```java 
 Public Class Usuario() {
    private String name;
    private String lastName;
    private int phone;
    @Email(message = "formato incorrecto")
    private String email;
 }
 ```
 
 ###### @Size()
 Anotacion nos permite definir un rango de digitos 
  ```java 
 Public Class Usuario() {
    private String name;
    private String lastName;
    @Size(min = 3, max = 8)
    private int phone;
    @Email(message = "formato incorrecto")
    private String email;
 }
  ```
 
 ###### @Pattern()
 nos permite realizar validaciones de expresiones regulares
 [0-9], lo utilizamos para decir que los caracteres permitidos son en ese rango.
 {2}, lo utilizamos para decir que solo se utilizaron en 2 combinaciones como maximo ej: 18, 29, 15. 
 [.], lo utilizamos para decir que luego ira un .
 
```java 
 Public Class Usuario() {
    @Pattern(regexp = "[ 0-9 ]{2}[.][ 0-9 ]{3}[.][ 0-9 ]{3}[.][-][a-z A-Z]{1}")
    private int rut;
    private String name;
    private String lastName;
    @Size(min = 3, max = 8)
    private int phone;
    @Email(message = "formato incorrecto")
    private String email;
 }
  ```
 @NotBlank
 valida que un campo no sea null y que no contenga espacios en blanco
 
 ```java 
 Public Class Usuario() {
    @Pattern(regexp = "[ 0-9 ]{2}[.][ 0-9 ]{3}[.][ 0-9 ]{3}[.][-][a-z A-Z]{1}")
    private int rut;
    private String name;
    private String lastName;
    @NotBlanke
    @Size(min = 3, max = 8)
    private int phone;
    @Email(message = "formato incorrecto")
    private String email;
 }
  ```
    
 @Min and @Max
 valida que un campo posea un valor minimo y uno maximo
 
 ```java 
 Public Class Usuario() {
    @Pattern(regexp = "[ 0-9 ]{2}[.][ 0-9 ]{3}[.][ 0-9 ]{3}[.][-][a-z A-Z]{1}")
    private int rut;
    private String name;
    private String lastName;
    @NotBlanke
    @Size(min = 3, max = 8)
    private int phone;
    @Email(message = "formato incorrecto")
    private String email;
    @Min(5)
    @Max(100000)
    private int cuenta;
 }
  ```
    
  @DateTimeFormat
  Se utiliza para definir el formato de los campos de fecha
 
 ```java 
 Public Class Usuario() {
    @Pattern(regexp = "[ 0-9 ]{2}[.][ 0-9 ]{3}[.][ 0-9 ]{3}[.][-][a-z A-Z]{1}")
    private int rut;
    private String name;
    private String lastName;
    @NotBlanke
    @Size(min = 3, max = 8)
    private int phone;
    @Email(message = "formato incorrecto")
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date register;
 }
  ```
    
   @Past
  Se utiliza para definir que el ingreso de la fecha debe ser pasada a la actual
 
 ```java 
 Public Class Usuario() {
    @Pattern(regexp = "[ 0-9 ]{2}[.][ 0-9 ]{3}[.][ 0-9 ]{3}[.][-][a-z A-Z]{1}")
    private int rut;
    private String name;
    private String lastName;
    @NotBlanke
    @Size(min = 3, max = 8)
    private int phone;
    @Email(message = "formato incorrecto")
    private String email;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date register;
 }
  ```
    
   @Future
  Se utiliza para definir que el ingreso de la fecha debe ser futura
 
 ```java 
 Public Class Usuario() {
    @Pattern(regexp = "[ 0-9 ]{2}[.][ 0-9 ]{3}[.][ 0-9 ]{3}[.][-][a-z A-Z]{1}")
    private int rut;
    private String name;
    private String lastName;
    @NotBlanke
    @Size(min = 3, max = 8)
    private int phone;
    @Email(message = "formato incorrecto")
    private String email;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date register;
 }
  ```
  
### CREACION DATABASE

###### Movie
```
CREATE TABLE `movies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_movie` varchar(100) NOT NULL,
  `director_movie` varchar(100) NOT NULL,
  `year_movie` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
    
###### Contacto

```
CREATE TABLE `contactos` (
  `id_Contacto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `edad` int NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id_Contacto`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

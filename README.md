# java-course

Ejercicios Simples para familiarizarse con SPRING BOOT

## Etiquetas (Beans)

###### @Data:
Es una anotacion de atajo que agrupa las caracteristicas de `@ToString`, `@EqualsAndHashCode`, `@Getter/@Setter` y `@RequiredArgsConstructor`, Basicamente genera todo el modelo que se asocia normalmente a una clase POJO.
Si necesita establecer valores no predeterminados para cualquiera de estos parámetros, simplemente agregue esas anotaciones explícitamente es lo suficientemente inteligente como para diferir esas anotaciones. `@Setter` `@ToString` `@EqualsAndHashCode` `@RequiredArgsConstructorcallSuperincludeFieldNamesexclude` `@Data`.

###### @Controller
Es una especializacion de la clase @Component, que nos permite detectar de forma automatica las clases de implementacion a través del escaneo de classpath.

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
Anotamos el método de manejo de solicitudes con @ResponseBody . Esta anotación permite la serialización automática del objeto devuelto en HttpResponse .

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
http://localhost:8080/api/movie/{id}
http://localhost:8080/api/movie/85

###### @GetMapping()
Esta anotacion nos permite asignar el tipo de solicitud http a los metodos del controller, existen varias variantes como
@PostMapping, @Putmapping, DeleteMapping

###### @Service()
anota clases en la capa de servicio.
Marcamos beans con @Service para indicar que mantienen la lógica de negocio. Además de usarse en la capa de servicio, no hay ningún otro uso especial para esta anotación.

###### @Component()
es un estereotipo genérico para cualquier componente administrado por Spring.

###### @Repository
anota las clases en la capa de persistencia, que actuará como repositorio de la base de datos.
El trabajo de @Repository es capturar excepciones específicas de persistencia y volver a lanzarlas como una de las excepciones no verificadas unificadas de Spring.

###### @Entity
Indica que la clase es una entidad

###### @Table(name = "Contactos")
Indica que esta asociada a la tabla en database

###### @NamedQuery()

###### @id
Indica que es un atributo id

###### @GeneratedValue(strategy=GenerationType.IDENTY)
estrategia de generacion de claves
cuando se inserten objetos en base de datos, lo identifica como que se genera automaticamente y no se debe incluir

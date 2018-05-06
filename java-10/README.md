Las nuevas caracteristicas de Java 10

# [JEP-286](http://openjdk.java.net/jeps/286) Inferencia de tipos en variables locales

La inferencia de tipos se realiza sobre variables locales con una inicializacion.

Ejemplo de uso:
```java
var list = new ArrayList<String>();  // infers ArrayList<String>
var stream = list.stream();          // infers Stream<String>
```
Esta inferencia esta limitada a las variables locales con una inicializacion, indices usados en las sentencias de ciclo, y las variales declaradas dentro de los ciclos.

Esta declaracion no podria usarse en
- los metodos formales
- contructores
- en el retorno de los metodos
- variables miembro de las clases
- en `catchs`

A continuacion algunos ejemplos de inferencia de tipos en diferentes lenguajes:

- `var x = expr only` (like C#)
- `var, plus val` for immutable locals (like Scala, Kotlin)
- `var, plus let` for immutable locals (like Swift)
- `auto x = expr` (like C++)
- `const x = expr` (already a reserved word)
- `final x = expr` (already a reserved word)
- `let x = expr`
- `def x = expr` (like Groovy)
- `x := expr` (like Go)

Algunos riegos de su uso

R1: Actualmente Java 8 ya tiene una inferencia de tipos en sus expresiones lambda. Es posible que se quiera usar `var` sobre una expresion lambda dando mensajes de error dificiles de entender.

```
Main.java:81: error: cannot infer type for local
variable x
        var x;
            ^
  (cannot use 'val' on variable without initializer)

Main.java:82: error: cannot infer type for local
variable f
        var f = () -> { };
            ^
  (lambda expression needs an explicit target-type)

Main.java:83: error: cannot infer type for local
variable g
        var g = null;
            ^
  (variable initializer is 'null')

Main.java:84: error: cannot infer type for local
variable c
        var c = l();
            ^
  (inferred type is non denotable)

Main.java:195: error: cannot infer type for local variable m
        var m = this::l;
            ^
  (method reference needs an explicit target-type)

Main.java:199: error: cannot infer type for local variable k
        var k = { 1 , 2 };
            ^
  (array initializer needs an explicit target-type)
```

R2: Ahora `var` pasa a ser una palabra reservada y es posible que se tengan errores con codigos heredados.

R3: Es posible reducir la legibilidad del codigo.

# [JEP-296](http://openjdk.java.net/jeps/296) Se consolidan los repositorios jdk

Se combinan los diferentes proyectos incluidos en la jdk en un solo repositorio.

> el codigo fuente de Java Fx no forma parte de esta mejora

Es posible acceder al prototipo del nuevo repositorio en: http://hg.openjdk.java.net/jdk10/consol-proto/


Para comprender este proceso de consolidacion se puede observar el siguiente ejemplo:
Actualmente la organizacion para los directorios de los modules se tiene la siguiente estructura:
```
$ROOT/jdk/src/java.base
...
$ROOT/langtools/src/java.compiler
...
```
En el proyecto consilidado, el codigo a sido organizado de la siguiente manera:
```
$ROOT/src/java.base
$ROOT/src/java.compiler
...
```

# [JEP-204](http://openjdk.java.net/jeps/204) Se mejoro el acceso a la tecnologia javaFx

Se mejoro el acceso de esta tecnologia a mas sistemas operativos para ayudas a usuarios con capacidades o necesidades diferentes. Por ejemplo, si un usuario no puede ver una pantalla, es posible usar un lector que describa la pantalla.


# [JEP-307](http://openjdk.java.net/jeps/307) Se mejoro el garbage collector G1

El garbage collector G1 es el utilizado por defecto desde java 9. Se mejoro el proceso de 'limpieza' agregandole soporte para que sea completamente concurrente y se minimize el impacto en la experiencia de usuario.  

# [JEP-301](http://openjdk.java.net/jeps/301) Se mejoraron los enumerados

# [JEP-312](http://openjdk.java.net/jeps/312) Se mejora la comunicacion de thread localles

# [JEP-313](http://openjdk.java.net/jeps/313) Se quita la herramienta `javah`

# [JEP-314](http://openjdk.java.net/jeps/314) Se agregan extenciones en el soporte de lenguajes

# [JEP-316](http://openjdk.java.net/jeps/316) Soporte para usar heap sobre dispositivos alternativos de memoria

# [JEP-317](http://openjdk.java.net/jeps/317) Se habilita el compilador java-based JIT

# [JEP-319](http://openjdk.java.net/jeps/319) Root Certificates

# [JEP-322](http://openjdk.java.net/jeps/322) Actualizacion del versionado de release

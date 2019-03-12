# Bienvenidos a mi proyecto

## Trabaja con mi proyecto
 Para trabajar con mi proyecto deberás hacer una copia local. Para ello puedes usar:
 
 `git clone https://github.com/PacoBocanegra/Tienda.git`
 
 `svn checkout https://github.com/PacoBocanegra/Tienda.git` 

### En que consiste
Consiste en registrar las compras de los clientes de una tienda que tiene sus propios productos. Los registros de las compras tendrán persistencia de datos y los almacenarán en una base de datos o en un fichero de texto o en un fichero binario o en un servidor redis. También incluyo una clase para poder leer los datos almacenados en el fichero binario.


### Requisitos para mi programa
- Tener java instalado:
  - Linux:
  
      `sudo apt install default-jdk`
      
  - Window:
  
      - Descargar java y javac por la página de oracle [here](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
      - Encontrar el directorio bin dentro del directorio de java (por defecto: C:\archivos de programas\java\jdk\bin)
      - Copiar la ruta completa del directorio bin
      - Añadimos la ruta en el PATH en la configuración de variables de entornos
      - Iniciamos una nueva terminal y probamos que funciona
      

- Tener el jar de sqlite3:

sqlite-jdbc-3.25.2.jar [here](http://central.maven.org/maven2/org/xerial/sqlite-jdbc/3.25.2/sqlite-jdbc-3.25.2.jar)

- Tener el jar de redis:

jedis-2.10.0.jar [here](http://central.maven.org/maven2/redis/clients/jedis/2.10.0/jedis-2.10.0.jar)


### Cómo ejecutar el programa
En Linux:
- Compilamos:

`javac -cp ruta_jar/*:. Tienda.java`

- Ejecutamos:

`java -cp ruta_jar/*:. Tienda`

En window:
- Compilamos:

`javac -cp ruta_jar/*:. Tienda.java`

- Ejecutamos:

`java -cp ruta_jar/*:. Tienda`

### Resultado de la ejecución
Mostramos una posible salida del programa para ver su funcionamiento:
~~~
usuario@usuario:~/Escritorio/tp7Ev2$ java -cp ../misjar/*:. Tienda
Bienvenido a Muebles S.A...
Lista de productos: (nombre:marca:precio)
Mesa:KENZO:69.99
Libreria:Kallax:399.99
Cajonera:Malm:49.85
Cama-d:Galia:249.60
Cama-i:Galia:199.90
Sofa-cama:Caleb:229.99
Silla:Amelia:55.00
Butaca:Charlotte:239.50

Quieres registrar una compra? (s/n)
s
Nombre del cliente: ? 
Pepito
Que producto ha comprado: ? 
Mesa
Cantidad de Mesa: ? 
2
Otro producto para el cliente Pepito? (s/n)
s
Que producto ha comprado: ? 
Butaca
Cantidad de Butaca: ? 
1
Otro producto para el cliente Pepito? (s/n)
n
Quieres registrar otra compra? (s/n)
s
Nombre del cliente: ? 
Juanito
Que producto ha comprado: ? 
Silla
Cantidad de Silla: ? 
2
Otro producto para el cliente Juanito? (s/n)
s
Que producto ha comprado: ? 
Libreria 
Cantidad de Libreria: ? 
2
Otro producto para el cliente Juanito? (s/n)
n
Quieres registrar otra compra? (s/n)
n

Lista de compras:
Pepito ha comprado 2 Mesa marca KENZO ------ 139.98€
Pepito ha comprado 1 Butaca marca Charlotte ------ 239.5€
Juanito ha comprado 2 Silla marca Amelia ------ 110.0€
Juanito ha comprado 2 Libreria marca Kallax ------ 799.98€
~~~


Después de acabar la ejecución, si tenemos descomentado la parte del codigo que graba en los diferentes ficheros o base de datos, nos grabará los registros donde hayamos dicho en el programa.

### Grabar datos

La parte del código que se encarga de grabar los registros es el siguiente:
~~~
//DAOCompra daocompra = new DAOImpCompraRedis();
DAOCompra daobin = new DAOImpCompraFileBin();
DAOCompra daotxt = new DAOImpCompraFileText();
DAOCompra daosql = new DAOImpCompraSQL();
...
...
...
//daocompra.grabar(una_compra);
daobin.grabar(una_compra); 
daotxt.grabar(una_compra);
daosql.grabar(una_compra); 
~~~
  

Por defecto solo está comentado grabar en un seridor redis. Si no queremos grabar en algún otro solo bastaria con comentar las lineas correspondiente. Por ejemplo, si no queremos grabar en un fichero de texto, comentamos estas lineas:

~~~
//DAOCompra daotxt = new DAOImpCompraFileText();
//daotxt.grabar(una_compra);
~~~

### Base de datos
En el proyecto se usa la base de datos sqlite3. Para instalar sqlite3:
- Linux:

` sudo apt install sqlite3 `

- Window:
 - Descargar SQLite3 [here](https://sqlite.org/2019/sqlite-dll-win32-x86-3270200.zip)
 - Creamos el directorio C:\sqlite
 - Extraemos el zip dentro del directorio y los ficheros dentro de la carpeta extraida los movemos al directorio sqlite
 - Entramos a la ruta C:\sqlite y ejecutamos sqlite3
 - Podemos borrar el zip y el directorio sobrante


Por defecto en el programa creamos la tabla "compras". Podemos modificar el nombre de la tabla dentro del fichero DAOImpComprasSQL en la siguiente línea:

` final String SQL = "CREATE TABLE IF NOT EXISTS compras (cliente text, nombre text, marca text, cant integer, precio double, fecha text primary key);"; `

Para abrir nuestra base de datos con sqlite3 ejecutamos lo siguiente:

` sqlite3 datos/compras.bd `

Para ver todos los registros añadidos a nuestra BD usamos esta consulta:

` select * from compras; `

Aquí tenemos una salida de ejemplo:

~~~
usuario@usuario:~/Escritorio/tp7Ev2$ sqlite3 datos/compras.db 
SQLite version 3.22.0 2018-01-22 18:45:57
Enter ".help" for usage hints.
sqlite> select * from compras;
Pepito|Mesa|KENZO|2|139.98|Mon Mar 11 11:23:13 CET 2019
Pepito|Butaca|Charlotte|1|239.5|Mon Mar 11 11:23:19 CET 2019
Juanito|Silla|Amelia|2|110.0|Mon Mar 11 11:23:32 CET 2019
Juanito|Libreria|Kallax|2|799.98|Mon Mar 11 11:23:48 CET 2019

~~~

### Autores 
Francisco Bocanegra Rodríguez y Maria Felix Wyns

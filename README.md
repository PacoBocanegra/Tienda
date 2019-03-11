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
  
      ``

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

` 
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
`

Después de acabar la ejecución, si tenemos descomentado la parte del codigo que graba en los diferentes ficheros o base de datos, nos grabará los registros donde hayamos dicho en el programa.

### Grabar datos

La parte del código que se encarga de grabar los registros es el siguiente:

` //DAOCompra daocompra = new DAOImpCompraRedis();
  DAOCompra daobin = new DAOImpCompraFileBin();
  DAOCompra daotxt = new DAOImpCompraFileText();
  DAOCompra daosql = new DAOImpCompraSQL();
  ...
  ...
  ...
  //daocompra.grabar(una_compra);
  daobin.grabar(una_compra); 
  daotxt.grabar(una_compra);
  daosql.grabar(una_compra); `
  

Por defecto solo está comentado grabar en un seridor redis. Si no queremos grabar en algún otro solo bastaria con comentar las lineas correspondiente. Por ejemplo, si no queremos grabar en un fichero de texto, comentamos estas lineas:

`
//DAOCompra daotxt = new DAOImpCompraFileText(); 
//daotxt.grabar(una_compra);
`

### Autores 
Francisco Bocanegra Rodríguez y Maria Felix Wyns

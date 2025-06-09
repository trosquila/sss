#  Instrucciones de Instalación y Consejos de Uso del Proyecto

## 📂 Base de Datos  
Se adjunta un archivo llamado **`proyectoSSSBaseDatos.sql`**, que contiene tablas con datos preinsertados para facilitar su uso.  
En la tabla **`owners`**, encontrarás relaciones entre coches y usuarios, aunque inicialmente no haya usuarios creados.  
Cuando se generen usuarios de prueba, **los primeros tres** tendrán vehículos asignados con sus respectivos gastos. Con importar el archivo se debería crear la base de datos correctamente.

---

## ⚙ Instalación del Programa  
Para ejecutar el proyecto correctamente, asegúrate de contar con los siguientes componentes instalados:

| Componente          | Versión              |
|---------------------|----------------------|
| **Servidor Tomcat** | `apache-tomcat-10.1.41` |
| **Encriptación**    | `Jasypt 1.9.2`        |
| **Conector MySQL**  | `mysql-connector-j-9.2.0` |
| **JDK**            | `JDK 23.0.1`          |

---

## ⚠ Notas y Consejos sobre el Proyecto  

### 🔹 Errores con Jasypt y MySQL  
Si, a pesar de instalar Jasypt y MySQL en el `PATH`, siguen generando errores, incluyelos también en la siguiente ruta: /proyectoFinalSSS/src/main/webapp/WEB-INF/lib  

### 🔹 Ubicación de Dependencias  
Tanto la carpeta de **Tomcat** (probablemte de problemas, más adelante muestro como lo solucione en mi caso) como las **librerías necesarias** se encuentran en la siguiente ruta dentro del directorio raíz:  C:\libs 


### 🔹 Posibles Errores con Variables de Sesión  
Hasta la fecha de redacción de este documento, **no se han detectado fallos significativos**, excepto en el manejo de variables de sesión.  
Si surgen errores inesperados, **reinicia el programa**, ya que en la mayoría de los casos, esto restablecerá su funcionamiento.


### 🔹 Archivo `.env`

Por accidente, este archivo fue incluido en un commit. Para hacer todo más rapido y no tener que buscarlo aquí tienes un ejemplo de como deberia ser (es obligatorio que tenga contraseña sino es probable que el programa falle):

```env
DB_HOST=localhost
DB_PORT=3306 o el puerto que uses
DB_USERNAME=tuNombreDeUsuario
DB_PASSWORD=tuContraseña
DB_DATABASE=proyectoSSSBaseDatos
```
### 🔹 Problema al cargar el archivo `.env`
Un posible fallo que se puede encontrar (casi seguro que pasa porque no sabia donde meter el tomcat y se complico la cosa) es que no se encuentre el archivo .env, en mi caso me lo cogia en una carpeta de eclipse, para solucionarlo tenemos que ir a Run > Run Configurations, dentro a la izquierda le daremos al tomcat en mi caso se llama Tomcat v10.1 Server at localhost, entramos en el apartado de Arguments, si nos iremos al último apartado que se llama Working diretory y ponemos la ruta del directorio en mi caso fue C:/Users/salin/Desktop/sss/proyectoFinalSSS, con esto en un principio ya debería funcionar.

No tiene por que dar estos fallos, muchos surguieron por ser la primera vez que hacia un proyecto de este tipo y no sabía muy bien donde colocar los archivos, pero se comentan para que en caso de que surga alguno, se tenga una primera opción que probar para solucionar el problema
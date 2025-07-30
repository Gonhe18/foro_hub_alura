# ** DESAFIO FORO HUB ALURA **
## Challenge incluido en el curso de Java del grupo G8 - ONE. Alura Latam

El desafío se realizó utilizando Spring Boot y MySQL. Con validaciones correspondiente y la utilización mediante token de JWT

En las migraciones se agregó la sentencia para generar un usuario por defecto, el mismo es:
#### USER: admin@admin.com - PASS: 123456

### LOGIN
La primera ruta que podemos ingresar es "/login", la cual nos permite iniciar sesión. Además, si ingresamos correctamente los datos, nos brindará el token para acceder a las rutas del CRUD

<img width="1539" height="265" alt="login" src="https://github.com/user-attachments/assets/428c3d09-5cae-4deb-b74d-17d1e72a2c44" />

### CREAR TOPICO
Mediante un POST a la ruta "/topicos" nos permitirá realizar la creación de topicos, la misma debe contar con una estructura determinada.
<img width="1184" height="329" alt="crear" src="https://github.com/user-attachments/assets/018e16a7-b1f5-469a-9631-8e53b361fc7f" />

Además de contar con algunas validaciones: 
#### ** No pueden existir tópicos duplicados **
<img width="1331" height="301" alt="duplicado" src="https://github.com/user-attachments/assets/47f83c92-b155-4681-98a5-539213f88ad0" />

#### ** Campos obligatorios **
<img width="1241" height="316" alt="faltaValores" src="https://github.com/user-attachments/assets/cb3dfc2a-acfd-434a-99ee-49c1203f0f14" />

### LISTAR TOPICOS
Mediante un GET a la ruta "/topicos", nos permitirá listar todos los curso creados.
<img width="751" height="927" alt="listar" src="https://github.com/user-attachments/assets/64dcc9ec-40db-4a58-bfda-04f38972d103" />

### MOSTRAR TOPICO
Además, mediante un GET a la ruta "/topicos/{id}" podremos buscar un topico en particular
<img width="1222" height="278" alt="consultar" src="https://github.com/user-attachments/assets/435fc0ea-b363-4141-8ccf-ecec7c7782a1" />

En caso de buscar un tópico inexistente nos arrojará el error correspondiente avisando de lo sucedido.
<img width="462" height="241" alt="inexistente" src="https://github.com/user-attachments/assets/d9fc3cfd-18c7-4af4-9e5c-b2d8c69dbddd" />

### EDITAR TOPICO
Mediante un PUT a la ruta "/topicos/{id}" tendremos la posibilidad de editar cualquier tópico existente
<img width="1390" height="289" alt="edit" src="https://github.com/user-attachments/assets/16d4d502-97d9-41db-b848-50c569db9906" />

La edición cuenta con las misma validaciones que el crear, son campos obligatorios y no debe existir otro tópico con el mismo título y mensaje. Además de que si no encuentra el id del tópico mostrará el error correspondiente.

## ELIMINAR TOPICO
A través de DELETE a la ruta "/topicos/{id}" vamos a tener la posibilidad de eliminar cualquier tópico existente, en caso de no encontrar el id se informará lo sucedido.
<img width="1203" height="86" alt="delete" src="https://github.com/user-attachments/assets/8aa65355-da64-4a0f-9808-b83aa3187fa2" />









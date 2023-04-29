# springboot-crud-reactive-app-with-mysql

<h2>SpringBoot Reactive Application to Perform CRUD operations for Users With MYSQL + Flyway.</h2>

Technology Used
---------------
1. Java
2. Spring Boot
3. Spring WebFlux
4. Spring Data R2DBC
5. MySQL
6. FlyWay
7. Docker


Install MySQL Using Docker
--------------------------------
>docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=mysecretpassword -d mysql:latest
>docker exec -it bash {container_id}
>mysql -u root -p -----> <enter password>
>show databases;
>create database testdb;

Operations
----------
1. Create User
2. Fetch User By ID
3. Fetch All User
4. Update User By Id
5. Delete User By Id
6. Delete All Users
  


API Endpoints
--------------
1. Create User (http://{HOST}:8080/user-app/api/v1/users  <b>POST</b>)
2. Get All Users (http://{HOST}:8080/user-app/api/v1/users  <b>GET</b>)
3. Get User By Id (http://{HOST}:8080/user-app/api/v1/users/{ID}  <b>GET</b>)
4. Update User By Id (http://{HOST}:8080/user-app/api/v1/users/{ID}  <b>PUT</b>)
5. Delete User By Id (http://{HOST}:8080/user-app/api/v1/users/{ID}  <b>DELETE</b>)
6. Delete All Users (http://{HOST}:8080/user-app/api/v1/users  <b>DELETE</b>)

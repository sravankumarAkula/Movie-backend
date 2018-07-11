# SuperGroupAssignment - Backend

## Screenshots :

[link **Screenshots**](https://github.com/sravankumarAkula/SuperGroupAssignment-backend/wiki)


## Video
[link **Video**](https://www.youtube.com/watch?v=1zsEslAe8Wk)


Projects exposes rest services to be consumed by front end angular app.

## Available API
```
REST API:
1. POST /postMovie
2. PUT /putMovie
3. GET /getMovies
4. DELETE /deleteMovie?id={id}
```

### architecture

Project backend built in Spring boot, JDBC, MYSQL , Mockito , Maven

### Prerequisites
1. Java 8
2. IDE
3. MYSQL
4. Maven
5. GIT

## Steps

1. Clone the application
```
https://github.com/sravankumarAkula/SuperGroupAssignment-backend.git
```

2. Create tables in Database
```
CREATE TABLE Movies (
    ID int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    director varchar(255) NOT NULL,
    genre varchar(255) NOT NULL,
    budget varchar(255) NOT NULL,
    PRIMARY KEY (ID)
);
```

3. Update mysql host, username, password in DBConnection.java (Source Packages -> com.movies.dbconnection)

4. Build and run the app using ide.

5. project runs at http://localhost:8080



# SuperGroupAssignment - frontend

front end UI built in angular and consumes the rest api using ajax

### architecture

Project Frontend built in Angular

## Steps

1. Clone the application
```
https://github.com/sravankumarAkula/SuperGroupAssignment-frontend.git
```

2. Open index.html in chrome

3. Login Details : 
```
  username : admin
  password : pass
```
  
4. Once logged in, you can access the application.  




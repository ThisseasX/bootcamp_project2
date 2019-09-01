# bootcamp_project2
Advanced implementation of the Coding Bootcamp 8 `individual_project_part_b` exercise.

# Notable Features
* Spring Boot
* Spring Data
* Reflection with Generics
* Project Lombok
* Hibernate ORM
* Custom Entity Mappings to allow for complex relationships
* Emphasis on Declarative and Functional Programming
* Absolute minimalism

# Database Setup

Open a new terminal, and `cd` all the way to this path (where the `bootcamp_project2.sql` resides).

```
$ path\to\project\bootcamp_project2\database
```

Type the following:
```
$ mysql -u {username} -p < bootcamp_project2.sql
```
Replace `{username}` with your actual database username, and type your password when prompted.

*(Optional)* Log into the database with your super user, make a new user `bootcamper@localhost` with password `111`, and grant him all privileges on the new database:
```
$ mysql -u {username} -p
$ CREATE USER bootcamper@localhost IDENTIFIED BY '111';
$ GRANT ALL PRIVILEGES ON bootcamp_project2.* TO bootcamper@localhost;
```

You can skip the above step, and run the app directly with your super user, by changing the username and password in the `application.properties` file residing in `bootcamp_project2\src\main\resources`.

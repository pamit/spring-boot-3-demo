# Spring Boot: Getting Started

## Students

For this resource, we have `StudentsController`, `StudentSpringDataJPA`, `StudentService`.

```
curl http://localhost:8080/students/query?email=A@a.A -u "user:67ffac77-5a43-4bee-a759-7ca10032d79d"
curl http://localhost:8080/students -u "user:67ffac77-5a43-4bee-a759-7ca10032d79d"

curl -i -XPUT http://localhost:8080/students -H 'Content-Type: application/json' -d '{"id":10, "firstName":"P2", "email":"e2"}' -u "user:67ffac77-5a43-4bee-a759-7ca10032d79d"
```

## Employee

This resource was created directly by Spring Data REST as the package searches for all implementations of JpaRepository 
like `EmployeeSpringDataJPA` and generates CRUD APIs:

```
curl localhost:8080/v10/employees -u "user:67ffac77-5a43-4bee-a759-7ca10032d79d"

curl -i -XPOST http://localhost:8080/v10/employees -H 'Content-Type: application/json' -d '{"firstName":"P1", "email":"e1"}' -u "user:67ffac77-5a43-4bee-a759-7ca10032d79d"
```

In `application.properties`, we have:

```
spring.data.rest.base-path=/v10
```

## Security

`spring-boot-starter-security` is used to provide authentication / authorization.

`SpringSecurityConfig` provides methods to disable CSRF and also build users with roles.

`public UserDetailsManager userDetailsManager(DataSource dataSource)` handles user authentication and authorization 
based on default table names that Spring Security understands: `users` and `authorities (roles)`.



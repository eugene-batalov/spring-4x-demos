## The Spring Framework 4.x and JPA 2.x integration

A simple JPA 2.x based application demonstrates how to use the Spring Framework and the [@Transactional][Transactional] annotation for declarative 
transaction demarcation. 

The application has three main parts:

 * Entity `MyEntity` - a simple JPA entity, there are two fields, `ID` and `NAME`, inside the entity.
 * Service `JPASimpleService` - contains the business logic of the application. The business logic is encapsulated in the `persistme` method
   annotated with [@Transactional][Transactional]. An `EntityManager` instance is injected into the class using the [@PersistenceContext][PersistenceContext]
   annotation.
 * Spring Framework configuration class `SpringCommonConfiguration` - is annotated with [@Configuration][Configuration] and 
   [@EnableTransactionManagement][EnableTransactionManagement]. The following beans: `EntityManagerFactory`, `JPASimpleService`, and `TransactionManager`
   are defined in the configuration class.

[Transactional]: https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/transaction/annotation/Transactional.html
[Configuration]: http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Configuration.html
[EnableTransactionManagement]: http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/transaction/annotation/EnableTransactionManagement.html
[PersistenceContext]: http://docs.oracle.com/javaee/7/api/javax/persistence/PersistenceContext.html

Because the application is just an example, the business logic is very simple. An entity is being persisted into a database table using JPA `EntityManager`:

```java
@Override
@Transactional
public void persistme() {       
    em.persist(new MyEntity(Thread.currentThread().getName()));
}
```

### How to build

Please, use [Apache Maven](https://maven.apache.org/) to build the projects.

```bash
$ git clone https://github.com/samolisov/spring-4x-demos.git
$ cd spring-4x-demos/jpa-integration
$ mvn clean compile
```

### How to run

The Maven project is configured to automaticaly start the main class of the application on the `verify` build phase. The 
[`main class`](src/main/java/psamolysov/demo/spring/jpaintegration/Main.java) contains three parts: firstly, using a spring application context,
a record is persisted into an embedded database, secondly, using an unwrapped database connection, the persisted record is checked, thirdly,
the embedded database is shutdown.

```bash
$ cd spring-4x-demos/jpa-integration
$ mvn verify
```

Once the main class is running, the following lines will be sent on the console:

```
[INFO] --- exec-maven-plugin:1.4.0:java (test-application) @ jpa-integration ---
25, 2016 2:17:55 PM org.springframework.context.annotation.AnnotationConfigApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@488b4bd2: startup date [Mon Apr 25 14:17:55 MSK 2016]; 
root of context hierarchy
[EL Warning]: 2016-04-25 14:17:58.908--ServerSession(382005913)--Exception [EclipseLink-4002] (Eclipse Persistence Services - 2.6.2.v20151217-774c696): 
org.eclipse.persistence.exceptions.DatabaseException
Internal Exception: java.sql.SQLSyntaxErrorException: 'DROP MYENTITY_SEQ' cannot be performed on 'MYENTITY_SEQ' because it does not exist.
Error Code: 30000
Call: DROP SEQUENCE MYENTITY_SEQ RESTRICT
Query: DataModifyQuery(sql="DROP SEQUENCE MYENTITY_SEQ RESTRICT")
[EL Warning]: 2016-04-25 14:17:58.941--ServerSession(382005913)--Exception [EclipseLink-4002] (Eclipse Persistence Services - 2.6.2.v20151217-774c696): 
org.eclipse.persistence.exceptions.DatabaseException
Internal Exception: java.sql.SQLSyntaxErrorException: SEQUENCE 'APP.MYENTITY_SEQ' does not exist.
Error Code: 30000
Call: VALUES(NEXT VALUE FOR MYENTITY_SEQ)
Query: ValueReadQuery(sql="VALUES(NEXT VALUE FOR MYENTITY_SEQ)")
A record has been inserted
ID: 100, NAME: psamolysov.demo.spring.jpaintegration.Main.main()
Derby has been successfully shutdown
```
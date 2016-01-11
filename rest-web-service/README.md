## A siple RESTFul Web Service based on the Spring Web MVC framework

A simple application just contains [a controller](src/main/java/psamolysov/demo/spring/restws/controller/MessageController.java) which provides three methods:

 * `textMessage()` - returns a simple text message getted from a service-class.
 * `jsonMessage()` - returns a JSON message that is the result of simple POJO's [content conversion][message-conversion].
 * `xmlMessage()` - returns an XML message that is the result of simple POJO's [content conversion][message-conversion]. Using JAXB annotations with
 Jackson is shown.

The methods are mapped on a common path: `/api/message`. The `Accept` HTTP header is important for method dispatch.

[message-conversion]: http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#rest-message-conversion

### How to build

Please, use [Apache Maven](https://maven.apache.org/) to build the project.

```
# git clone https://github.com/samolisov/spring-4x-demos.git
# cd spring-4x-demos/rest-web-service
# mvn clean package
```

### How to run

You can just deploy the projects in your favourite application server or servlet container, e.g. *Apache Tomcat*, *Jetty* or *WebSphere Application Server 
Liberty*

### How to get a result

You can call a controller just using the following code snippet:

```java
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class SimpleInvokator {

    public static void main(String[] args) {
        WebTarget target = ClientBuilder.newClient().target(
                "http://localhost:9082/rest-web-service");
        
        String restext = target
                .path("/api/message")                
                .request()
                .accept("text/plain")
                .get(String.class);                
        System.out.println(restext);
        
        String resjson = target
                .path("/api/message")              
                .request()
                .accept("application/json")
                .get(String.class);                
        System.out.println(resjson);
        
        String resxml = target
                .path("/api/message")                
                .request()
                .accept("text/xml")
                .get(String.class);                
        System.out.println(resxml);
    }
}
```

*Jersey 2* should be [downloaded](https://jersey.java.net/download.html) for the invokator.

A result example looks like the following:

```
Message#1452523665973
{"orderName":"IBM zShop","orderCount":441}
<zshop orderName="IBM zShop" orderCount="648" xmlns="http://ibm.com/ru/spring-integration/demo/workspace"></zshop>
```

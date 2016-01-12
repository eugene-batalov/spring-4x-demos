## Spring Framework 4.x Demos

A bunch of [Spring Framework 4.x][spring] using demo projects.

 * `rest-web-service` - the example of a simple RESTful web-service based on the [Spring Web MVC][spring-mvc] framework.

[spring-mvc]: http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc
[spring]: https://projects.spring.io/spring-framework/

### How to build

Please, use [Apache Maven](https://maven.apache.org/) to build the projects.

```bash
$ git clone https://github.com/samolisov/spring-4x-demos.git
$ cd spring-4x-demos
$ mvn clean package
```

### How to run

The projects use [Liberty Maven Plug-in][] to automatically download and install WebSphere Liberty profile runtime from the 
[Liberty repository](https://developer.ibm.com/wasdev/downloads/). Liberty Maven Plug-in is also used to create, configure, and run the application on 
the Liberty server.

[Liberty Maven Plug-in]: https://github.com/WASdev/ci.maven

### License

```text
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

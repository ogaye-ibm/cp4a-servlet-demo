# Branch master
RUN on gretty, the embedded http server
```bash 
gradle wrapper --gradle-version=6.4.1
./gradlew appRun
 http://localhost:8080/HelloServlet/hello
```
BUILD WAR
```bash 
./gradlew clean build
```
War file will be generated under buid/libs
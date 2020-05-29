# Branch master
RUN on gretty, the embedded http server
```bash 
gradle wrapper --gradle-version=6.4.1
./gradlew appRun
 http://localhost:8080/cp4a-servlet-demo/hello
```
BUILD WAR
```bash 
./gradlew clean build
```
War file will be generated under buid/libs

# Branch data-access
This version of the Servlet accesses a data base and fetches a table to display data.
This version requires configuration of a datasource
# Branch data-access-annotation (WIP)
Same as branch data-access just using annotation instead of xml descriptor files
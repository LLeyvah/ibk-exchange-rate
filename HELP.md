# API IBK EXCHANGE RATE


### Health Endpoint
* Open http://localhost:9090/actuator/health in browser

### H2 Database Console
* http://localhost:9090/h2-console

### Run api in docker
Build docker image
1. Generate JAR
```
Win
.\mvnw clean package
Linux
./mvnw clean package
```
2. Run  docker image
```
docker build -t exchange-rate-api .
```
2. Run api
```
docker run -e "SPRING_PROFILES_ACTIVE=local" -p 9090:9090 -t exchange-rate-api
```

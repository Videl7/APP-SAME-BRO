FROM maven:3.8.4-openjdk-11 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package

FROM tomcat:8.5-jdk11-openjdk-slim
COPY --from=builder /app/target/api.war /usr/local/tomcat/webapps/
EXPOSE 8080

CMD ["catalina.sh", "run"]
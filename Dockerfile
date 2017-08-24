FROM openjdk:9-b181-jdk-slim
RUN apt-get -y update && apt-get install -y sqlite3
RUN mkdir /db
RUN /usr/bin/sqlite3 /db/gamify9dotcom.db
RUN mkdir -p /app
ADD target/app.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

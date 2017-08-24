FROM openjdk:9-b181-jdk-slim
RUN apt-get -y update && apt-get -y upgrade && apt-get install -y sqlite3 libsqlite3-dev
RUN mkdir /db
RUN /usr/bin/sqlite3 /db/gamify9dotcom.db
RUN mkdir -p /app
ADD app.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Description
Gamify9.com = Java 9 + Spring boot + Angular

## Docker
### Build
mvn clean package

### Pull
docker pull r3kdotio/gamify9dotcom

## Run
sudo docker create -p 443:8443 --name=website -v /etc/letsencrypt/live/gamify9.com:/etc/certs/ -e "SPRING_PROFILES_ACTIVE=production" r3kdotio/gamify9dotcom:1.0.1





## Palindrom backend

### Kjøre i Docker

Bygge prosjektet: `mvn clean install`

Klargjør deploy til Docker: `docker build -t palindrom-api .`

Installere container: `docker-compose -f ../docker-compose-file.yml up`

Installere container inkludert frontend: `docker-compose -f ../docker-compose-file.yml up`

### Kjøre db lokalt

`docker run -d --name mysql-local -p 3306:3306 -e MYSQL_ROOT_PASSWORD=testdb -v ./db:/var/lib/mysql mysql`# palindrom-api

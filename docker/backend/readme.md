1. Build Image
   ```shell
    docker build -t rupesh1997/backend:1.0.2 \
       --build-arg ACTIVE_PROFILE=docker \
       --build-arg PROJECT_VERSION=1.0.2 \
       -f ../docker/backend/Dockerfile .
    ```

2. Run container
   ```shell
    docker run -d \
    -p 8181:8181 \
    --name backend-svc \
    -e SPRING_PROFILES_ACTIVE=docker \
    --network devops \
    rupesh1997/backend:1.0.2
    ```

   ```shell
    docker run -d \
    -p 8181:8181 \
    --name backend-svc \
    --network devops \
    -e SPRING_PROFILES_ACTIVE=docker \
    -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/devops \
    -e SPRING_DATASOURCE_PASSWORD=root \
    rupesh1997/backend:1.0.2
    ```


```shell
    docker network inspect devops >/dev/null 2>&1 \
    || docker network create devops --driver bridge
    
    docker run -d -p 3306:3306 \
     --name mysql --network devops \
     -e MYSQL_ROOT_PASSWORD=root \
     -e MYSQL_DATABASE=devops \
     mysql:8.0
       
    docker stop backend-svc && 
    docker rm backend-svc && 
    docker system prune -f && 
    clear
``` 
   
1. Build Image
   ```shell
    docker build -t rupesh1997/devops-day-05:1.0.0 \
       --build-arg ACTIVE_PROFILE=docker \
       --build-arg PROJECT_VERSION=1.0.0 \
       -f ../docker/backend/Dockerfile .
    ```

2. Run Product Service Container
   ```shell
    docker network create devops --driver bridge && 
    docker run -d \
    -p 8181:8181 \
    --name devops-day-05 \
    -e SPRING_PROFILES_ACTIVE=docker \
    --network devops \
    rupesh1997/devops-day-05:1.0.0
    ```

   ```shell
    #With mysql database dependency
    #network - check if it is already created
    docker network inspect devops >/dev/null 2>&1 \
    || docker network create devops --driver bridge
    docker system prune -f &&
    clear &&
    docker run -d \
    -p 8181:8181 \
    --name devops-day-05 \
    --network devops \
    -e SPRING_PROFILES_ACTIVE=docker \
    -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/devops \
    -e SPRING_DATASOURCE_PASSWORD=root \
    rupesh1997/devops-day-05:1.0.0
    ```


```shell
    docker stop devops-day-05 && 
    docker rm devops-day-05 && 
    docker system prune -f && 
    clear
``` 
   
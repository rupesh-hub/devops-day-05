1. Build docker image
   ```shell
   # build docker 
   docker build \
   -t rupesh1997/frontend:1.0.0 \
   --build-arg CONFIGURATION=docker \
   -f ../docker/frontend/Dockerfile .  
   
   # Run container
   docker run -d \
   --name frontend \
   --network devops \
   -p 4200:8080 \
   rupesh1997/frontend:1.0.0
   ```

   ```shell
   docker kill frontend backend-svc mysql && docker system prune -f && clear && docker ps
   docker network connect devops mysql
   ```
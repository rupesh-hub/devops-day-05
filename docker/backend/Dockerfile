# 1. Build stage
FROM maven:3.8.7-openjdk-18 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

#2. Runtime stage
FROM amazoncorretto:17
ARG PROFILE=dev
ARG APP_VERSION=1.0.0

WORKDIR /app
COPY --from=build /build/target/devops-day-05-*.jar /app/

EXPOSE 8181
ENV ACTIVE_PROFILE=${PROFILE}
ENV JAR_VERSION=${APP_VERSION}

CMD java -jar -Dspring.profiles.active=${ACTIVE_PROFILE} devops-day-05-${JAR_VERSION}.jar
# docker build -t rupesh1997/devops-day-05:1.0.0 -f ../docker/backend/Dockerfile .
# docker run -p 8181:8181 --name devops-day-05 rupesh1997/devops-day-05:1.0.0
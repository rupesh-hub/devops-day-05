# 1. Build stage
FROM maven:3.8.7-openjdk-18 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

#2. Runtime stage
FROM amazoncorretto:17
ARG ACTIVE_PROFILE=default
ARG PROJECT_VERSION=1.0.0

WORKDIR /app
COPY --from=build /build/target/devops-day-05-*.jar /app/

EXPOSE 8181
ENV PROFILE=${ACTIVE_PROFILE}
ENV JAR_VERSION=${PROJECT_VERSION}

CMD java -jar -Dspring.profiles.active=${PROFILE} devops-day-05-${JAR_VERSION}.jar
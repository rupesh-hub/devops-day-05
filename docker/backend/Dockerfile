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
COPY --from=build /build/target/backend-*.jar /app/

EXPOSE 8181
ENV PROFILE=${ACTIVE_PROFILE}
ENV JAR_VERSION=${PROJECT_VERSION}
ENV DATABASE_URL="jdbc:mysql://mysql:3306/devops"

CMD java -jar -Dspring.profiles.active=${PROFILE} -Dspring.datasource.url=${DATABASE_URL} backend-${JAR_VERSION}.jar
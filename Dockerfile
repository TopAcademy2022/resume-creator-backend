FROM gradle:8.12-jdk23 AS build

WORKDIR /app

COPY build.gradle settings.gradle ./
COPY src ./src

RUN chmod +x build-core.sh && ./build-core.sh
RUN gradle build --no-daemon



FROM openjdk:24-ea-23-oracle

EXPOSE 8080

WORKDIR /app

COPY --from=build /app/build/libs/*.jar top-0.0.1-plain.jar

ENTRYPOINT ["java", "-jar", "top-0.0.1-plain.jar"]

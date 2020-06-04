FROM alpine AS build

ARG COMMIT_SHA=<not-specified>
ARG BUILD_FILE_NAME=springboot-template-0.1.0-SNAPSHOT

WORKDIR /build

COPY ./target/${BUILD_FILE_NAME}.jar ./application.jar
COPY LICENSE .

RUN echo "service-name: $COMMIT_SHA" >> ./commit.sha

FROM openjdk:8-jre-slim

LABEL maintainer="%CUSTOM_PLUGIN_CREATOR_USERNAME%" \
      name="mia_template_service_name_placeholder" \
      description="mia_template_service_name_placeholder" \
      eu.mia-platform.url="https://www.mia-platform.eu" \
      eu.mia-platform.version="0.1.0" \
      eu.mia-platform.language="java" \
      eu.mia-platform.framework="Spring Boot"

# set deployment directory
WORKDIR /home/java/app

COPY --from=build /build .

USER 1000

CMD ["java", "-jar", "./application.jar"]

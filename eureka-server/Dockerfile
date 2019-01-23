FROM openjdk:8
MAINTAINER wanli <wanlinus@qq.com>
WORKDIR /data
COPY target/eureka-server-0.0.1-SNAPSHOT.jar server.jar
ENTRYPOINT ["java", "-jar", "-Xmx128m", "-Xms128m", "server.jar"]
EXPOSE 8000
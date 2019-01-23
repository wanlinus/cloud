FROM openjdk:8
MAINTAINER wanli <wanlinus@qq.com>
WORKDIR /data
COPY target/eureka-client-0.0.1-SNAPSHOT.jar client.jar
ENTRYPOINT ["java", "-jar", "-Xmx128m", "-Xms128m", "client.jar"]
EXPOSE 9000
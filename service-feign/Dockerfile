FROM openjdk:8
MAINTAINER wanli <wanlinus@qq.com>
WORKDIR /data
COPY target/service-feign-1.0.0.RELEASE.jar feign.jar
ENTRYPOINT ["java", "-jar", "-Xms128m", "-Xmx128m", "feign.jar"]
EXPOSE 9200
FROM openjdk:8
MAINTAINER wanli <wanlinus@qq.com>
WORKDIR /data
COPY target/service-ribbon-1.0.0.RELEASE.jar ribbon.jar
ENTRYPOINT ["java", "-jar", "-Xms128m", "-Xmx128m", "ribbon.jar"]
EXPOSE 9100

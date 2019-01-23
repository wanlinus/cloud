FROM openjdk:8
MAINTAINER wanli <wanlinus@qq.com>
WORKDIR /data
COPY target/service-zuul-0.0.1-SNAPSHOT.jar zuul.jar
ENTRYPOINT ["java", "-jar", "-Xmx128m", "-Xms128m", "zuul.jar"]
EXPOSE 9300
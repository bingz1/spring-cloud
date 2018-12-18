FROM openjdk:8-jre

ENV jarName=spring-cloud-server-0.0.1-SNAPSHOT.jar

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/TZ /etc/localtime && echo TZ /etc/localtime && echo TZ > /etc/timezone

ADD ./target/$jarName /

WORKDIR /

ENTRYPOINT  java $JAVA_OPTS -jar $jarName
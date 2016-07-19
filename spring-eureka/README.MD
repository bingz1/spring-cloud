#单个服务器模式

```
## 服务端口
server:
  port: 8079

##应用名称
spring:
  application:
    name: eureka-server
## eureka server 相关配置
eureka:
  instance:
    hostname: localhost
  client:
    register-with-eureka: false
    fetch-registry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
  server:
    ##解决网页上展示警告信息
    enable-self-preservation: false

```

#多服务器模式

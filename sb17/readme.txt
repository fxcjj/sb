1. 此项目为admin-client服务
2. 引入相关依赖
<!-- admin client -->
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-starter-client</artifactId>
    <version>2.3.1</version>
</dependency>

<!-- actuator -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

3. 配置要注册的admin地址
spring:
  boot:
    admin:
      client:
        url: http://localhost:1916 # 要注册到SBA的地址
  application:
    name: sb17(admin-client)

4. SecurityPermitAllConfig
安全性配置

5. 启动admin服务和admin client服务，登录admin地址，即可看到效果

6. 此项目为直接注册方式，另外有注册中心方式（zookeeper,Eureka）

7. 修改了配置后，重启此项目即可，不用重启SBA
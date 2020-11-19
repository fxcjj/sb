1. SBA(Spring Boot Admin)
1.1 引入依赖
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-starter-server</artifactId>
    <version>2.3.1</version>
</dependency>

1.2 在启动类添加注解
@EnableAdminServer 开启AdminServer的功能

1.3 访问地址
http://localhost:1916

2. sb17为SBA client，需配合一起演示demo


Reference
https://www.cnblogs.com/youngdeng/p/12883878.html
https://www.cnblogs.com/huanchupkblog/p/10563629.html
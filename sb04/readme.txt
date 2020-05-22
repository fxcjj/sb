
Digest
1. spring boot默认使用commons-logging实现日志
2. slf4j-api是接口，实现有多个，如：log4j,logback等
3. logback是直接实现，推荐使用。
pom文件中未引入logback依赖，是因为 spring-boot-starter-test包含了slf4j-api, spring-boot-starter-web（依赖spring-boot-starter）包含了logback-classic。
log4j要有adapter，不推荐使用
4. logback配置放在在resources目录下，名称为logback-spring.xml时spring boot会自动找到，可以不用在application.properties中配置路径


References
//SpringBoot | 第三章：springboot配置详解
https://blog.lqdev.cn/2018/07/14/springboot/chapter-third/
https://logback.qos.ch/manual/appenders.html#TimeBasedRollingPolicy
https://www.cnblogs.com/warking/p/5710303.html
note/log/log4j/log4j的使用.txt
note/log/logback
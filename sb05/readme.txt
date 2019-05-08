
多环境配置
1. 在配置文件中指定环境
application.yml
# 指定环境，dev,test,prod
spring:
  profiles:
    active: dev
2. @Profile("dev")注解可以指明某个bean在指定环境有效
3. 格式application-${profile}.yml，其中${profile}为变量
4. 可在对应的配置文件中声明不同配置，如数据库连接信息


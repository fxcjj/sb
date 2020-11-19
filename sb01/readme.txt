

1. 目录结构说明
- src
    -main
        -java
            -com.vic.sb01
                #主函数，启动类，运行它如果运行了 Tomcat、Jetty、Undertow 等容器
                -Sb01Application
        -resouces
            #存放静态资源 js/css/images 等
            - statics
            #存放 html 模板文件
            - templates
            #主要的配置文件，SpringBoot启动时候会自动加载application.properties/bootstrap.properties
            - application.properties
    #测试文件存放目录
    -test
 # pom.xml 文件是Maven构建的基础，里面包含了我们所依赖JAR和Plugin的信息
- pom

2. spring boot, spring cloud版本说明
https://www.jianshu.com/p/99c45499fb6e

References
//SpringBoot | 第一章：第一个SpringBoot应用
https://blog.lqdev.cn/2018/07/11/springboot/chapter-one/

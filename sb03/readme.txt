

Digest
1. @ConfigurationProperties
2. 查找顺序先resources/config后resources
3. 声明是一个配置使用@Component或@Configuration
4. 引入配置文件使用@PropertySource
    使用.properties或.yml文件配置属性时，可以使用中划线-或者下划线_，例如配置my-name或者my_name，属性为myName是可以注入进来的
5. @RequestHeader注解和@RequestParam注解的使用
6. 使用@Value可绑定在配置文件中定义的属性
7. 使用${random}产生随机int/long/string值
8. 约定优于配置
springboot默认的全局配置文件名为application.properties或者application.yml(spring官方推荐使用的格式是.yml格式
除此之外还有一个 bootstrap 的全局文件，它的加载顺序在application配置文件之前，主要是用于在应用程序上下文的引导阶段
9. 配置提示
additional-spring-configuration-metadata.json属性元文件


References
//SpringBoot | 第三章：springboot配置详解
https://blog.lqdev.cn/2018/07/14/springboot/chapter-third/
package com.vic.sb03.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component //加上此annotation才能找到，@Configuration也可以
//@EnableConfigurationProperties({Shaver.class}) //启动时找不到bean
@ConfigurationProperties(prefix = "shaver")
/*
1. 此注解默认在resources目录下找指定文件，找不到报错
2. 如果将对应properties文件放在resources/conf目录，需要配置classpath:config/shaver.properties
 */
@PropertySource("classpath:shaver.properties")
public class Shaver {

    private String name;

    private String size;

}

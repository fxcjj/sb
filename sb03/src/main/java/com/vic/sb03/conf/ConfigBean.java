package com.vic.sb03.conf;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Component
/*

@ConfigurationProperties(prefix = "com.vic")
默认查找classpath下的application.properties文件

查找顺序
1. src/main/resources/config
2. src/main/resources

注意：优先使用路径最短的文件，属性不存在，则继续往下找，有点合并的意味。
 */
@Slf4j
@Data
@ConfigurationProperties(prefix = "com.vic")
public class ConfigBean {

    private String myName;

    private List<String> hobby1;
    private List<String> hobby2;

    private String[] array1;

    private Map<String, String> priceMap1;
    private Map<String, String> priceMap2;

    @PostConstruct
    public void init() {
        log.info("init ConfigBean: {}", this);
    }

}

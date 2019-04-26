package com.vic.sb03.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
/*

@ConfigurationProperties(prefix = "com.vic")
默认查找application.properties文件

查找顺序
1. src/main/resources/config
2. src/main/resources

注意：优先使用路径最短的文件，属性不存在，则继续往下找，有点合并的意味。
 */
@Data
@ConfigurationProperties(prefix = "com.vic")
public class ConfigBean {

    private String name;

    private String want;

    private List<String> hobby;

    private Map<String, String> priceMap;

}

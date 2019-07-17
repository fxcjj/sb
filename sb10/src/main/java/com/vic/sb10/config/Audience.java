package com.vic.sb10.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "audience")
public class Audience {

    private String clientId;
    private String base64Secret;
    private String name;
    private int expiresSecond;

}

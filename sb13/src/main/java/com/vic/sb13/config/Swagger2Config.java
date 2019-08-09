package com.vic.sb13.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2配置
 * @author 罗利华
 * date: 2019/5/16 15:19
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {

    /**
     * 版本号
     */
    private final String version = "1.0.0";

    /**
     * 是否开启swagger，正式环境一般关闭，可根据springboot的多环境配置进行设置
     */
    @Value("${swagger2.enabled}")
    private Boolean swagger2Enabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                // 是否开启
                .enable(swagger2Enabled).select()
                // 扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.vic.sb09")) ////多路径扫描，之间用逗号分隔
                // 指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any()).build().pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot-Swagger2集成和使用-demo示例")
                .description("这是描述")
                //设置作者、Website、email
//                .contact(new Contact("victor", "www.baidu.com", "123@qq.com"))
                .version(version)
                .build();
    }


}

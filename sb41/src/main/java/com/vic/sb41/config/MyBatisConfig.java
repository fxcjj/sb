package com.vic.sb41.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
@MapperScan(value = {"com.vic.sb41.dao.orders", "com.vic.sb41.dao.uesrs"})
public class MyBatisConfig {
}

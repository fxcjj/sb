package com.vic.sb43.config;

import org.mybatis.spring.annotation.MapperScan;

//@Configuration
@MapperScan(value = {"com.vic.sb43.dao.orders", "com.vic.sb43.dao.uesrs"})
public class MyBatisConfig {
}

package com.vic.sb42.config;

import org.mybatis.spring.annotation.MapperScan;

//@Configuration
@MapperScan(value = {"com.vic.sb42.dao.orders", "com.vic.sb42.dao.uesrs"})
public class MyBatisConfig {
}

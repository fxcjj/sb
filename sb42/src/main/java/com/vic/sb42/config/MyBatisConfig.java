package com.vic.sb42.config;

import org.mybatis.spring.annotation.MapperScan;

//@Configuration
@MapperScan(value = {"com.vic.sb41.dao.orders", "com.vic.sb41.dao.uesrs"})
public class MyBatisConfig {
}

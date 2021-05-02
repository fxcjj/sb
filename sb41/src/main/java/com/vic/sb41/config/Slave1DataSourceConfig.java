package com.vic.sb41.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = Slave1DataSourceConfig.PACKAGE, sqlSessionTemplateRef = "slave1SqlSessionTemplate")
// 指定分库扫描的 dao包，并给 dao层注入指定的 SqlSessionTemplate
public class Slave1DataSourceConfig {

    static final String PACKAGE = "com.vic.sb40.dao.slave1";
    static final String MAPPER_LOCATION = "classpath:mapper/slave1/*.xml";

    // 首先创建 DataSource
    @Bean //(name = "slave1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave1")
    public DataSource slave1DataSource() {
        return DataSourceBuilder.create().build();
    }

    // 然后创建 SqlSessionFactory
    @Bean //(name = "slave1SqlSessionFactory")
    public SqlSessionFactory slave1SqlSessionFactory(@Qualifier("slave1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return bean.getObject();
    }

    // 再创建事务
    @Bean //(name = "slave1TransactionManager")
    public DataSourceTransactionManager slave1TransactionManager(@Qualifier("slave1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    // 最后包装到 SqlSessionTemplate 中
    @Bean //(name = "slave1SqlSessionTemplate")
    public SqlSessionTemplate slave1SqlSessionTemplate(@Qualifier("slave1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
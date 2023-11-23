package com.example.springbootdemo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = "com.example.springbootdemo.mapper.prod", sqlSessionTemplateRef = "prodSessionTemplate")
@MapperScan(basePackages = "com.example.springbootdemo.mapper.ccard", sqlSessionTemplateRef = "ccardSessionTemplate")
public class MyBatisConfig {
    public static final String PROD_DATASOURCE = "prodds";
    public static final String CCARD_DATASOURCE = "ccardds";
    public static final String PROD_SESSION_FACTORY = "prodSessionFactory";
    public static final String CCARD_SESSION_FACTORY = "ccardSessionFactory";

    @Bean(name = PROD_DATASOURCE, destroyMethod = "")
    @ConfigurationProperties(prefix = "spring.prod.datasource")
    @Primary
    public DataSource dataSourcePROD() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = PROD_SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactoryPROD(@Qualifier(PROD_DATASOURCE) DataSource dataSource) throws Exception {
        var factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }

    @Bean(name = "prodSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplatePROD(@Qualifier(PROD_SESSION_FACTORY) SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = CCARD_DATASOURCE, destroyMethod = "")
    @ConfigurationProperties(prefix = "spring.ccard.datasource")
    public DataSource dataSourceCCARD() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = CCARD_SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactoryCCARD(@Qualifier(CCARD_DATASOURCE) DataSource dataSource) throws Exception {
        var factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }

    @Bean(name = "ccardSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplateCCARD(@Qualifier(CCARD_SESSION_FACTORY) SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

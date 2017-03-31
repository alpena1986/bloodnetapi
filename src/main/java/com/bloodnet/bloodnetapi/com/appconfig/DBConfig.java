package com.bloodnet.bloodnetapi.com.appconfig;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.bloodnet.bloodnetapi.com.consts.Consts;

@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:properties\\" + Consts.PROPERTY_FILE_JDBC})
public class DBConfig  extends WebMvcConfigurationSupport  implements TransactionManagementConfigurer{

    @Autowired
    private Environment env;
    
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setInitialSize(20);
        return dataSource;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        return sessionFactory.getObject();
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
    
    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return txManager();
    }
}
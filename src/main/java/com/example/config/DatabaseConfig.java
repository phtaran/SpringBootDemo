package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("com.example.repository")
@EnableTransactionManagement
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    String datasourceUrl;

    @Value("${spring.datasource.username}")
    String datasourceName;

    @Value("${spring.datasource.password}")
    String datasourcePassword;

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(datasourceUrl, datasourceName, datasourcePassword);
    }
}

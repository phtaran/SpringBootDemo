package com.example.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("com.example.repository")
@EnableTransactionManagement
@PropertySource("classpath:liquibase.properties")
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    String datasourceUrl;

    @Value("${spring.datasource.username}")
    String datasourceName;

    @Value("${spring.datasource.password}")
    String datasourcePassword;

    @Autowired
    Environment env;

    @Bean
    public DataSource getDataSource() {
        return new DriverManagerDataSource(datasourceUrl, datasourceName, datasourcePassword);
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(env.getProperty("changeLogFile"));
        liquibase.setContexts(env.getProperty("contexts"));
        liquibase.setDataSource(this.getDataSource());
        liquibase.setDropFirst(Boolean.parseBoolean(env.getProperty("dropFirst")));
        return liquibase;
    }
}

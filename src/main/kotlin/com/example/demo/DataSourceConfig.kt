package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.TransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
class DataSourceConfig {


    @Bean("datasource")
    @Primary
    @ConfigurationProperties("spring.datasource")
    fun primaryDataSource(): DataSource {
        return DataSourceBuilder.create().build();
    }

    @Bean("datasource2")
    @ConfigurationProperties("secondary.datasource")
    fun secondaryDataSource(): DataSource {
        return DataSourceBuilder.create().build();
    }

    @Bean("transactionManager")
    @Primary
    @Autowired
    fun transactionManager(@Qualifier("datasource") datasource: DataSource): TransactionManager {
        return DataSourceTransactionManager(datasource);
    }

    @Bean("transactionManager2")
    @Autowired
    fun transactionManager2(@Qualifier("datasource2") datasource: DataSource): TransactionManager {
        return DataSourceTransactionManager(datasource);
    }
}


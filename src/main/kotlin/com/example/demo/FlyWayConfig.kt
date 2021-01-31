package com.example.demo

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FlyWayConfig {

    @Bean
    fun flywayMigrationStrategy(): FlywayMigrationStrategy {
        System.out.println("********************** running flyway migration ")
        return FlywayMigrationStrategy {
            flyway ->
                flyway.migrate()
        }

    }

}
package com.behzad.spring.reactive.app;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConnectionFactoryConfiguration {
    @Bean
    public ConnectionFactory connectionFactory() {
        PostgresqlConnectionConfiguration config =
                PostgresqlConnectionConfiguration.builder()
                        .database("heroko_spring_db")
                        .password("@777zzz@behzad@123456")
                        .username("postgres")
                        .host("localhost")
                        .port(5432)
                        .build();
        return new PostgresqlConnectionFactory(config);
    }
}


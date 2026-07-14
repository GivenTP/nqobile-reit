package com.afrosoft.nqobile.onboardingandkyc.config;

import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.reactive.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class HibernateReactiveConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    private EntityManagerFactory emf;

    @Bean
    public Stage.SessionFactory sessionFactory() {
        Map<String, String> props = new HashMap<>();

        // Converts a standard jdbc:postgresql URL format to something Hibernate Reactive understands
        props.put("jakarta.persistence.jdbc.url", dbUrl);
        props.put("jakarta.persistence.jdbc.user", dbUser);
        props.put("jakarta.persistence.jdbc.password", dbPassword);
        props.put("hibernate.connection.provider_class", "org.hibernate.reactive.provider.impl.ReactiveConnectionProviderImpl");

        this.emf = Persistence.createEntityManagerFactory("postgres-reactive-unit", props);
        return emf.unwrap(Stage.SessionFactory.class);
    }

    @PreDestroy
    public void closeConnections() {
        if (this.emf != null && this.emf.isOpen()) {
            this.emf.close(); // Clean teardown when Spring shuts down
        }
    }
}


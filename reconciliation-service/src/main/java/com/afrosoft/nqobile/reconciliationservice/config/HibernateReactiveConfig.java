package com.afrosoft.nqobile.reconciliationservice.config;

import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.reactive.provider.ReactiveServiceRegistryBuilder;
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

    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;

    @Value("${hibernate.format_sql}")
    private String hibernateFormatSql;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;

    private EntityManagerFactory emf;

    @Bean
    public Stage.SessionFactory sessionFactory() {
        Map<String, Object> props = new HashMap<>();

        // 3. Define your connection parameters using standard property fields
        props.put("hibernate.connection.url", dbUrl);
        props.put("hibernate.connection.username", dbUser);
        props.put("hibernate.connection.password", dbPassword);

        // 4. Schema Generation and Query log formatting
        props.put("hibernate.show_sql", hibernateShowSql);
        props.put("hibernate.format_sql", hibernateFormatSql);
        props.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);

        // 5. Build Registry using the native Reactive engine
        StandardServiceRegistry registry = new ReactiveServiceRegistryBuilder()
                .applySettings(props)
                .build();

        // 6. Explicitly register your domain model entities
        MetadataSources metadataSources = new MetadataSources(registry);
        metadataSources.addAnnotatedClass(com.afrosoft.nqobile.reconciliationservice.model.ReconciliationLedger.class);
//        metadataSources.addAnnotatedClass(com.afrosoft.nqobile.onboardingandkyc.model.KycApplication.class);

        Metadata metadata = metadataSources.buildMetadata();

        this.emf = metadata.getSessionFactoryBuilder().build();

        return emf.unwrap(Stage.SessionFactory.class);
    }


    @PreDestroy
    public void closeConnections() {
        if (this.emf != null && this.emf.isOpen()) {
            this.emf.close();
        }
    }
}

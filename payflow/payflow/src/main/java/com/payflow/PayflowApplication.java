package com.payflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the PayFlow application.
 *
 * @SpringBootApplication is itself a combination of three annotations:
 *   - @Configuration      -> this class can define beans
 *   - @EnableAutoConfiguration -> Spring Boot inspects the classpath (it sees
 *     spring-boot-starter-web, spring-boot-starter-data-jpa and h2 as
 *     dependencies) and auto-configures an embedded Tomcat server, a
 *     DataSource pointing at an in-memory H2 database, and a JPA
 *     EntityManagerFactory / transaction manager - all without a single
 *     line of manual config.
 *   - @ComponentScan      -> Spring scans com.payflow and all sub-packages
 *     (entity, repository, service, controller) for classes annotated with
 *     @Component, @Service, @Repository, @RestController and registers them
 *     as beans in the ApplicationContext.
 */
@SpringBootApplication
public class PayflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayflowApplication.class, args);
    }

}

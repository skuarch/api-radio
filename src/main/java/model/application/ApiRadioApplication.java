package model.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * starter class, this class contains the main method.
 * @author skuarch
 */
@Configuration
@EnableScheduling
@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(value = { "model.persistence" })
@ComponentScan({ "controller", "model" })
@EnableJpaRepositories("model.repository")
@PropertySource(value = "file:application.properties", ignoreResourceNotFound = false)
public class ApiRadioApplication {

    // =========================================================================
    /**
     * run application.
     *
     * @param args String
     */
    public static void main(final String[] args) {
        SpringApplication.run(ApiRadioApplication.class, args);
    }

}

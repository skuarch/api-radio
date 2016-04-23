package model.application.configuration;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Configuration.
 * @author skuarch
 */
@Configuration
@Profile("development")
public class DevelopmentConfiguration {

    private static final Logger LOGGER = Logger.getLogger(DevelopmentConfiguration.class);

    //==========================================================================
    /**
     * development configuration constructor.
     */
    public DevelopmentConfiguration() {
        LOGGER.info("running with profile development");
    }

}

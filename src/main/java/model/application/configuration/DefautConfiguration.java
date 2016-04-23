package model.application.configuration;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author skuarch
 */
@Configuration
@Profile("default")
public class DefautConfiguration {

    private static final Logger LOGGER = Logger.getLogger(DefautConfiguration.class);

    //==========================================================================
    /**
     * default configuration constructor.
     */
    public DefautConfiguration() {
        LOGGER.info("running with profile default");
    }

}

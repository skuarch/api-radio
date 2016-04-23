package model.application.configuration;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author skuarch
 */
@Configuration
@Profile("production")
public class ProductionConfiguration {

    private static final Logger LOGGER = Logger.getLogger(ProductionConfiguration.class);

    //==========================================================================
    /**
     * production configuration constructor.
     */
    public ProductionConfiguration() {
        LOGGER.info("running with profile production");
    }

}

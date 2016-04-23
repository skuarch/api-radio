package model.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import interceptor.RequestInterceptor;
import model.bean.GenericMessage;
import model.bean.RequestBean;

/**
 * Configuration.
 * @author skuarch
 */
@Configuration
public class BeanConfiguration {

    //==========================================================================
    /**
     * configuration of @Autowired.
     * @return GenericMessage
     */
    @Bean
    public GenericMessage genericMessage() {
        return new GenericMessage();
    }

    //==========================================================================
    /**
     * configuration of @Autowired.
     * @return RequestBean
     */
    @Bean
    public RequestBean requestBean() {
        return new RequestBean();
    }

    //==========================================================================
    /**
     * configuration of @Autowired.
     * @return RequestInterceptor
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor();
    }

}

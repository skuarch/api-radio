package model.application.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import interceptor.RequestInterceptor;

/**
 * Configuration.
 * @author skuarch
 */
@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private RequestInterceptor requestInterceptor;

    // =========================================================================
    @Override
    public void addInterceptors(final InterceptorRegistry registry) {

        registry.addInterceptor(requestInterceptor).addPathPatterns("/**");
    }

}

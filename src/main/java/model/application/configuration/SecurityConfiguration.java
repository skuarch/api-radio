package model.application.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Configuration.
 * @author skuarch
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String SQL_LOGIN = "SELECT user_email AS username, user_password AS PASSWORD, user_is_active AS enabled FROM user WHERE user_email = ?";
    private static final String SQL_AUTHORIZATION = "SELECT u.user_email as username, r.role_name AS authority FROM user u, user_role ur, role r WHERE (u.user_id = ur.user_id) AND (ur.role_id = r.role_id) AND (u.user_email = ?);";

    @Autowired
    private DataSource dataSource;

    // ==============================================================================
    /**
     * configureGlobal.
     * @param amb AuthenticationManagerBuilder
     * @throws Exception if any error occurs
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder amb) throws Exception {
        amb.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(SQL_LOGIN)
                .authoritiesByUsernameQuery(SQL_AUTHORIZATION);

    }

    // ==============================================================================
    /**
     * configure.
     * @param http HttpSecurity
     * @throws Exception if any error occurs
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().csrf().disable().httpBasic();
    }
}

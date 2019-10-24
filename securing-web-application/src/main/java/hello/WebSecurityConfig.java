/**
 * security configuration that ensures that only authenticated users can see the secret greeting:
 * <p>
 * The WebSecurityConfig class is annotated with @EnableWebSecurity to enable Spring Security’s web security support and provide the Spring MVC integration.
 * It also extends WebSecurityConfigurerAdapter and overrides a couple of its methods to set some specifics of the web security configuration.
 **/

package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
/**
 * @Name configure
 * @Description defines which URL paths should be secured and which should not.
 * Specifically, the "/" and "/home" paths are configured to not require any authentication. All other paths must be authenticated.
 *
 * When a user successfully logs in, they will be redirected to the previously requested page that required authentication.
 * There is a custom "/login" page specified by loginPage(), and everyone is allowed to view it.
 **/
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll().anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }

    @Bean
    @Override
    /**
     * @Name userDetailsService
     * @Description As for the userDetailsService() method, it sets up an in-memory user store with a single user.
     * That user is given a username of "user", a password of "password", and a role of "USER".
     *
     **/
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user").password("password").roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
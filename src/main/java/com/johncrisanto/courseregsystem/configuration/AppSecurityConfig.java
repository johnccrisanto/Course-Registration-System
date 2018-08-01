package com.johncrisanto.courseregsystem.configuration;

import com.johncrisanto.courseregsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    // Security data source
    @Autowired
    private UserService userService;

    private static final String[] PUBLIC_MATCHERS = {"/login", "/logout"};

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // In memory authentication (demo purposes only)
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser(users.username("john").password("test123").roles("STUDENT"))
//                .withUser(users.username("mary").password("test123").roles("STUDENT","INSTRUCTOR"))
//                .withUser(users.username("susan").password("test123").roles("STUDENT","ADMIN"));

        // JDBC Authentication configuration
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Configure the security of the web paths such as custom login form, etc
        http
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .antMatchers("/").hasRole("STUDENT")
                .antMatchers("/instructor/**").hasRole("INSTRUCTOR")
                .antMatchers("/admin/**").hasRole("ADMIN");

        http
                .formLogin().loginPage("/loginPage").loginProcessingUrl("/authenticateTheUser").permitAll()
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedPage("/accessDeniedPage");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
}

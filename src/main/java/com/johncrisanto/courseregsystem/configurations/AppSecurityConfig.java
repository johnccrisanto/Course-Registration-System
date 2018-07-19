package com.johncrisanto.courseregsystem.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        // In memory authentication (demo purposes only)
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("john").password("test123").roles("STUDENT"))
                .withUser(users.username("mary").password("test123").roles("STUDENT","INSTRUCTOR"))
                .withUser(users.username("susan").password("test123").roles("STUDENT","ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Configure the security of the web paths such as custom login form, etc
        http
                .authorizeRequests()
                .antMatchers("/").hasRole("STUDENT")
                .antMatchers("/instructor/**").hasRole("INSTRUCTOR")
                .antMatchers("/admin/**").hasRole("ADMIN");


        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/loginPage").loginProcessingUrl("/authenticateTheUser").permitAll()
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedPage("/accessDeniedPage");
    }
}

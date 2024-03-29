package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
/*import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;*/
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

        // add support for JDBC ... no more hardcoded users :-)

        @Bean  //DataSource is autoconfigured by SB
        public UserDetailsManager userDetailsManager(DataSource dataSource){

            /*only return statement is required for "Default Database Support in Spring Security both for noop, bcrypt
            for "users" and "authorities" tables"
            return new JdbcUserDetailsManager(dataSource);*/



            /*rest code is when we create our custom table for security for "members" and "roles" tables*/
            JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

            // define query to retrieve a user by username (how to find users)
            jdbcUserDetailsManager.setUsersByUsernameQuery(
                    "select user_id, pw, active from members where user_id=?");

            // define query to retrieve the authorities/roles by username (how to find roles)
            jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                    "select user_id, role from roles where user_id=?");

            return jdbcUserDetailsManager;
        }


        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

            http.authorizeHttpRequests(configurer ->
                    configurer
                            .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                            .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                            .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
            );

            // use HTTP Basic authentication
            http.httpBasic();

            //disable Cross Site Request Forgery (CSRF)
            // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
            http.csrf().disable();

            return http.build();
        }

        /* Commenting out the hard coded user details
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
        //Since we defined our users here, SpringBoot will not use user/pswd from application.properties file
    } */
}












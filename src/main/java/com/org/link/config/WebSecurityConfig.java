package com.org.link.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.org.link.idx.jwt.ResourceServerConfig;

@Configuration
@EnableResourceServer
public class WebSecurityConfig extends ResourceServerConfig {
    @Value("${security.user.name:link}")
    private String username;

    @Value("${security.user.password:l1nk3d1n}")
    private String password;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .inMemoryAuthentication()
            .withUser(username).password(password).roles("ACTUATOR");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
    http
        .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
        .authorizeRequests()
            .antMatchers("/", "/manage/health", "/manage/hystrix.stream").permitAll()
            .antMatchers("/manage/**").hasRole("ACTUATOR")
            .anyRequest().authenticated()
            .and()
        .httpBasic();
    }
}


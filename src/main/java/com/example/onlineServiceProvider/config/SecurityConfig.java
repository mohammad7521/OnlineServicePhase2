package com.example.onlineServiceProvider.config;


import com.example.onlineServiceProvider.service.jwt.Jwt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private Jwt jwt;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    public SecurityConfig(Jwt jwt) {
        this.jwt = jwt;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .cors().and()
                .authorizeRequests()
                .antMatchers("/customer/**", "/expert/**","/").permitAll()
                .anyRequest().authenticated();
    }
}

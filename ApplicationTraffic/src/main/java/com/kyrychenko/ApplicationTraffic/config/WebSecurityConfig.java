package com.kyrychenko.ApplicationTraffic.config;

import com.kyrychenko.ApplicationTraffic.Repository.UserDetailsRepository;
import com.kyrychenko.ApplicationTraffic.domain.User;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.time.LocalDateTime;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**", "/js/**", "/error**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().logout().logoutSuccessUrl("/").permitAll()
                .and()
                .csrf().disable();
    }

    @Bean
    public PrincipalExtractor principalExtractor(UserDetailsRepository userDetailsRepository) {
        return map -> {
            String id = (String) map.get("sub");
            User user = userDetailsRepository.findById(id).orElseGet(() -> {
               User newuser = new User();

               newuser.setId(id);
               newuser.setName((String) map.get("name"));
               newuser.setEmail((String) map.get("email"));
               newuser.setGender((String) map.get("gender"));
               newuser.setLocale((String) map.get("locale"));
               newuser.setUserpic((String) map.get("picture"));

               return newuser;
            });

            user.setLastVisit(LocalDateTime.now());

            return userDetailsRepository.save(user);
        };
    }
}

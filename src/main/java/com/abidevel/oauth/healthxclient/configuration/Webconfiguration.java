// package com.abidevel.oauth.healthxclient.configuration;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @Configuration
// public class Webconfiguration  extends WebSecurityConfigurerAdapter{

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.oauth2Client().and().csrf((c) -> c.ignoringAntMatchers("/data"));
//         http.authorizeRequests().anyRequest().permitAll().and().build();
//     }
    
    
// }

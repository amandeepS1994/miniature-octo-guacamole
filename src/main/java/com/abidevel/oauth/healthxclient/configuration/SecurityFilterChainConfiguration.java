package com.abidevel.oauth.healthxclient.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;
@Configuration
public class SecurityFilterChainConfiguration {
    
    @Bean
    SecurityFilterChain configureFilterChain (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf((c) -> c.ignoringAntMatchers("/data"));
        return httpSecurity.authorizeRequests().anyRequest().permitAll().and().build();
    }

    // For remote calls.
    @Bean
    RestTemplate configureRestTemplate () {
        return new RestTemplate();
    }

    // For authenticating and getting access tokens.
    @Bean
    OAuth2AuthorizedClientManager authorizedClientManager (ClientRegistrationRepository clientRegistrationRepository, OAuth2AuthorizedClientRepository authorizedClientRepository) {
        DefaultOAuth2AuthorizedClientManager authorizedClientManager = new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository, authorizedClientRepository);
        authorizedClientManager.setAuthorizedClientProvider(OAuth2AuthorizedClientProviderBuilder.builder()
        .clientCredentials()
        .build());
        return authorizedClientManager;
    }
}

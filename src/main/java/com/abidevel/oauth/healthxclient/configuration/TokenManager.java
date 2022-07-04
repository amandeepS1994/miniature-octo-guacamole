package com.abidevel.oauth.healthxclient.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

@Configuration
public class TokenManager {

    private final String clientRegistrationName;

    private final String clientId;

    private final OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;

    public TokenManager (@Value("app") String clientRegistrationName, @Value("advicegenerator") String clientId, OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager) {
        this.clientRegistrationName = clientRegistrationName;
        this.clientId = clientId;
        this.oAuth2AuthorizedClientManager = oAuth2AuthorizedClientManager;
    }   
    
    public String getAccessToken () {
        OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest.withClientRegistrationId(this.clientRegistrationName)
            .principal(clientId)
            .build();
        return this.oAuth2AuthorizedClientManager.authorize(authorizeRequest).getAccessToken().getTokenValue();
    }
    
}

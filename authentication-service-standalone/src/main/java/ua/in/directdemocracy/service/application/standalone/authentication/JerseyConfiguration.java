package ua.in.directdemocracy.service.application.standalone.authentication;

import java.util.List;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.in.directdemocracy.service.api.rest.authentication.PasswordAuthenticationREST;
import ua.in.directdemocracy.service.web.authentication.WebAuthenticationService;
import ua.in.directdemocracy.service.web.authentication.WebAuthenticationServiceComponent;

@Configuration
public class JerseyConfiguration {

    @Autowired
    PasswordAuthenticationREST passwordAuthenticationService;
    
    @Autowired
    List<WebAuthenticationServiceComponent> authenticationServices; 
    
    @Bean
    public ResourceConfig config() {
        ResourceConfig config = new ResourceConfig();
        authenticationServices.forEach(service->config.register(service));
        return config;
    }
    
}

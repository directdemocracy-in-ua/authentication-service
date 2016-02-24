package ua.in.directdemocracy.service.application.standalone.authentication.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.in.directdemocracy.service.api.rest.authentication.PasswordAuthenticationREST;
import ua.in.directdemocracy.service.web.authentication.AuthenticationService;

@Configuration
public class JerseyConfiguration {

    @Autowired
    PasswordAuthenticationREST passwordAuthenticationService;
    
    @Bean
    public ResourceConfig config() {
        return new ResourceConfig().register(AuthenticationService.class);
    }
    
}

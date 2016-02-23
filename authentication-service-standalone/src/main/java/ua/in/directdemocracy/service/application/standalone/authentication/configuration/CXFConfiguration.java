package ua.in.directdemocracy.service.application.standalone.authentication.configuration;

import org.apache.cxf.jaxrs.spring.JaxRsConfig;
import org.apache.cxf.jaxrs.spring.SpringComponentScanServer;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ua.in.directdemocracy.service.web.authentication.AuthenticationService;

@Configuration
@Import({SpringComponentScanServer.class, JaxRsConfig.class})
public class CXFConfiguration {

    @Autowired
    @Qualifier("authenticationService")
    AuthenticationService authenticationService;
    
    @Value("${authentication-service.contextPath}/*")
    String contextPath;
    
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new CXFServlet(), contextPath);
    }

    @Bean(name="authenticationServiceREST")
    public AuthenticationService authenticate() {
        return authenticationService;
    }
}

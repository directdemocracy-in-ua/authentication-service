package ua.in.directdemocracy.service.application.standalone.authentication.configuration;

import org.apache.cxf.jaxrs.spring.JaxRsConfig;
import org.apache.cxf.jaxrs.spring.SpringComponentScanServer;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ua.in.directdemocracy.service.web.authentication.AuthenticationServiceController;

@Configuration
@Import({SpringComponentScanServer.class, JaxRsConfig.class})
public class CXFConfiguration {

    
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new CXFServlet(), "/authentication/api/*");
    }

    @Bean
    public AuthenticationServiceController authenticate() {
        return new AuthenticationServiceController();
    }
}

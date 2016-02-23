package ua.in.directdemocracy.service.application.standalone.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import ua.in.directdemocracy.service.application.standalone.authentication.configuration.CXFConfiguration;

@EnableAutoConfiguration
@Import(CXFConfiguration.class)
@ComponentScan("ua.in.directdemocracy.service.web.authentication")
public class SpringBootApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootApplication.class, args);
    }
}

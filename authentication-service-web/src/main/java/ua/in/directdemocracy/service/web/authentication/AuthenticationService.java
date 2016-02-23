package ua.in.directdemocracy.service.web.authentication;

import org.springframework.stereotype.Component;

import ua.in.directdemocracy.service.api.rest.authentication.PasswordAuthenticationREST;
import ua.in.directdemocracy.service.api.rest.authentication.UserDto;
import ua.in.directdemocracy.service.api.rest.authentication.UserPasswordDto;

@Component("authenticationService")
public class AuthenticationService implements PasswordAuthenticationREST {

    @Override
    public UserDto authenticate(UserPasswordDto userPassword) {
        UserDto user = new UserDto();
        user.setId(userPassword.getLogin());
        return user;
    }

    @Override
    public UserDto test() {
        UserDto user = new UserDto();
        user.setId("test");
        return user;
    }
    
    
}

package ua.in.directdemocracy.service.web.authentication;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import ua.in.directdemocracy.service.api.rest.authentication.PasswordAuthenticationREST;
import ua.in.directdemocracy.service.api.rest.authentication.UserDto;
import ua.in.directdemocracy.service.api.rest.authentication.UserPasswordDto;

@Component("authenticationService")
public class AuthenticationService implements PasswordAuthenticationREST, AuthenticationServiceComponent {

    private Map<String, String> passwords = new HashMap<>();
    
    @Override
    public UserDto authenticateTextPassword(UserPasswordDto userPassword) {
        if (!passwords.containsKey(userPassword.getLogin())) {
            return null;
        }
        String password = passwords.get(userPassword.getLogin());
        if (password.equals(userPassword.getPassword())) {
            UserDto user = new UserDto();
            user.setId(userPassword.getLogin());
            return user;
        }
        return null;
    }
    
    @Override
    public UserDto authenticateByPasswordHash(String hashType, UserPasswordDto userPassword) {
        return authenticateTextPassword(userPassword);
    }

    @Override
    public void createPassword(UserPasswordDto newUserPassword) {
        if (!passwords.containsKey(newUserPassword.getLogin())) {
            passwords.put(newUserPassword.getLogin(), newUserPassword.getPassword());
        }
    }

    @Override
    public void changePassword(UserPasswordDto newUserPassword) {
        if (passwords.containsKey(newUserPassword.getLogin())) {
            passwords.put(newUserPassword.getLogin(), newUserPassword.getPassword());
        }
    }

    
    
    
}

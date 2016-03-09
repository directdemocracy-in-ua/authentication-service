package ua.in.directdemocracy.service.web.authentication;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import ua.in.directdemocracy.service.api.rest.authentication.AuthenticationResultDto;
import ua.in.directdemocracy.service.api.rest.authentication.AuthenticationStatus;
import ua.in.directdemocracy.service.api.rest.authentication.PasswordAuthenticationREST;
import ua.in.directdemocracy.service.api.rest.authentication.UserDto;
import ua.in.directdemocracy.service.api.rest.authentication.UserPasswordDto;

@Component("authenticationService")
public class AuthenticationService implements PasswordAuthenticationREST, AuthenticationServiceComponent {

    private Map<String, String> passwords = new HashMap<>();
    
    @Override
    public AuthenticationResultDto authenticateTextPassword(UserPasswordDto userPassword) {
        AuthenticationResultDto result = new AuthenticationResultDto();
        if (!passwords.containsKey(userPassword.getLogin())) {
            result.setStatus(AuthenticationStatus.USER_NOT_FOUND);
            return result;
        }
        String password = passwords.get(userPassword.getLogin());
        if (password.equals(userPassword.getPassword())) {
            UserDto user = new UserDto();
            user.setId(userPassword.getLogin());
            result.setUser(user);
            result.setStatus(AuthenticationStatus.AUTHENTICATED);
            return result;
        }
        result.setStatus(AuthenticationStatus.WRONG_PASSWORD);
        return result;
    }
    
    @Override
    public AuthenticationResultDto authenticateByPasswordHash(String hashType, UserPasswordDto userPassword) {
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

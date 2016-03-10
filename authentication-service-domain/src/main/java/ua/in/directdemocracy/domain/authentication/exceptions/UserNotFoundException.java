package ua.in.directdemocracy.domain.authentication.exceptions;

public class UserNotFoundException extends Exception {

    private String login;
    
    public UserNotFoundException(String login) {
        super("User not found exception: " + login);
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    
}

package ua.in.directdemocracy.domain.authentication.exceptions;

public class UserAlreadyExistException extends Exception {

    private String login;
    
    public UserAlreadyExistException(String login) {
        super("User already exists: " + login);
        this.login = login;
    }
    

    public String getLogin() {
        return login;
    }
    
    
}

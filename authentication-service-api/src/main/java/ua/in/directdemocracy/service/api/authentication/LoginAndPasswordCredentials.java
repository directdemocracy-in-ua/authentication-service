package ua.in.directdemocracy.service.api.authentication;

public class LoginAndPasswordCredentials {

    private String login;
    private Password password;
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public Password getPassword() {
        return password;
    }
    
    public void setPassword(Password password) {
        this.password = password;
    }
    
}

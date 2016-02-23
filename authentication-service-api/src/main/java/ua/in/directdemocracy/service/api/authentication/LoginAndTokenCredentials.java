package ua.in.directdemocracy.service.api.authentication;

public class LoginAndTokenCredentials {

    private String login;
    private Token token;
    private DigitalSignature signature;
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public Token getToken() {
        return token;
    }
    
    public void setToken(Token token) {
        this.token = token;
    }
    
    public DigitalSignature getSignature() {
        return signature;
    }
    
    public void setSignature(DigitalSignature signature) {
        this.signature = signature;
    }
    
}

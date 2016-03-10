package ua.in.directdemocracy.domain.authentication.model.user;

public class User {

    private String id;
    private String loginHash;
    private String passwordId;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswordId() {
        return passwordId;
    }

    public void setPasswordId(String passwordId) {
        this.passwordId = passwordId;
    }

    public String getLoginHash() {
        return loginHash;
    }

    public void setLoginHash(String loginHash) {
        this.loginHash = loginHash;
    }
    
    
}

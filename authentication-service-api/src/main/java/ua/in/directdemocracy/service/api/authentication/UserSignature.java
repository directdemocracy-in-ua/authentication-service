package ua.in.directdemocracy.service.api.authentication;

public class UserSignature {

    private String login;
    private Digest digest;
    private DigitalSignature signature;
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Digest getDigest() {
        return digest;
    }
    
    public void setDigest(Digest digest) {
        this.digest = digest;
    }
    
    public DigitalSignature getSignature() {
        return signature;
    }
    
    public void setSignature(DigitalSignature signature) {
        this.signature = signature;
    }
    
}

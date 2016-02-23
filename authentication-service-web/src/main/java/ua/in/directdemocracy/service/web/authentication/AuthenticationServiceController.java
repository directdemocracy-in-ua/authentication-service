package ua.in.directdemocracy.service.web.authentication;

import ua.in.directdemocracy.service.api.authentication.AuthenticationService;
import ua.in.directdemocracy.service.api.authentication.LoginAndPasswordCredentials;
import ua.in.directdemocracy.service.api.authentication.LoginAndTokenCredentials;
import ua.in.directdemocracy.service.api.authentication.Token;
import ua.in.directdemocracy.service.api.authentication.UserCertificate;
import ua.in.directdemocracy.service.api.authentication.UserId;
import ua.in.directdemocracy.service.api.authentication.UserSignature;

public class AuthenticationServiceController implements AuthenticationService {

    public UserId authenticateByLoginAndPassword(LoginAndPasswordCredentials credentials) {
        return null;
    }

    public Token createAuthenticationToken() {
        return new Token("token");
    }

    public UserId authenticateByLoginAndToken(LoginAndTokenCredentials credentials) {
        return null;
    }

    public UserCertificate authenticateBySignature(UserSignature signature) {
        return null;
    }

}

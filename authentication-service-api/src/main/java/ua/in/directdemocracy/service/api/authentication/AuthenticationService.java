package ua.in.directdemocracy.service.api.authentication;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/authenticate")
public interface AuthenticationService {

    @POST
    @Path("/user")
    UserId authenticateByLoginAndPassword(LoginAndPasswordCredentials credentials);
    
    @GET
    @Path("/token")
    Token createAuthenticationToken();
    
    @POST
    @Path("/token")
    UserId authenticateByLoginAndToken(LoginAndTokenCredentials credentials);
    
    @POST
    @Path("/signature")
    UserCertificate authenticateBySignature(UserSignature signature);
}

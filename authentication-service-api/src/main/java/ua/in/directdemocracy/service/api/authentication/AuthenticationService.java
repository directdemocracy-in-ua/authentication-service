package ua.in.directdemocracy.service.api.authentication;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/authenticate")
@Consumes
public interface AuthenticationService {

    @POST
    @Path("/by/password")
    UserId authenticateByLoginAndPassword(LoginAndPasswordCredentials credentials);
    
    @GET
    @Path("/by/token")
    Token createAuthenticationToken();
    
}

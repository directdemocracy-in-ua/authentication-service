package ua.in.directdemocracy.service.api.rest.authentication;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/password")
@Consumes("application/json")
@Produces("application/json")
public interface PasswordAuthenticationREST {

    @POST
    UserDto authenticate(UserPasswordDto userPassword);
    
    @GET
    UserDto test();
}

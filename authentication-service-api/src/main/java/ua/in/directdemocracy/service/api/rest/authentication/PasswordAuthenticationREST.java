package ua.in.directdemocracy.service.api.rest.authentication;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/password")
@Consumes("application/json")
@Produces("application/json")
public interface PasswordAuthenticationREST {

    @POST
    UserDto authenticateTextPassword(UserPasswordDto userPassword);
    
    @POST
    @Path("/hash/{type}")
    UserDto authenticateByPasswordHash(@PathParam("type") String hashType, UserPasswordDto userPassword);
    
    @POST
    @Path("/create")
    void createPassword(UserPasswordDto newUserPassword);
    
    @PUT
    @Path("/update")
    void changePassword(UserPasswordDto newUserPassword);
  
}

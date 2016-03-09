package ua.in.directdemocracy.service.api.rest.authentication;

public class AuthenticationResultDto {
    
    private AuthenticationStatus status;
    private UserDto user;
    
    public AuthenticationStatus getStatus() {
        return status;
    }
    
    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }
    
    public UserDto getUser() {
        return user;
    }
    
    public void setUser(UserDto user) {
        this.user = user;
    }
    
}

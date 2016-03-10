package ua.in.directdemocracy.domain.authentication.model.userpassword;

public interface UserPasswordRepository {

    UserPassword findById(String id);
    
    UserPassword findByPasswordHash(String hash);
    
    UserPassword save(UserPassword newPassword);
}

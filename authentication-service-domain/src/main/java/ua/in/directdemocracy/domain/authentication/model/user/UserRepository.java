package ua.in.directdemocracy.domain.authentication.model.user;

public interface UserRepository {

    User findById(String id);
    User findByLoginHash(String loginHash);
    
    User save(User user);
}

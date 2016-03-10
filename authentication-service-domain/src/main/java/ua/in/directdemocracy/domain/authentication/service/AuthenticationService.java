package ua.in.directdemocracy.domain.authentication.service;

import javax.annotation.Resource;

import ua.in.directdemocracy.domain.authentication.model.user.User;
import ua.in.directdemocracy.domain.authentication.model.user.UserRepository;
import ua.in.directdemocracy.domain.authentication.model.userpassword.UserPassword;
import ua.in.directdemocracy.domain.authentication.model.userpassword.UserPasswordRepository;

public class AuthenticationService {

    @Resource
    UserRepository usersRepository;
    
    @Resource
    UserPasswordRepository passwordsRepository;
    
    @Resource
    HashService hashService;
    
    public boolean authenticateUserByPassword(String login, String password) {
        return authenticateUserByPasswordHash(login, hashService.fromString(password));
    }
    
    public boolean authenticateUserByPasswordHash(String login, String passwordHash) {
        UserPassword userPassword = fetchUserPassword(login);
        return userPassword != null && passwordHash.equals(userPassword.getPasswordHash());
    }

    public boolean authenticateUserByPasswordHashAndSid(String login, String passwordAndSidHash, String sid) {
        UserPassword userPassword = fetchUserPassword(login);
        if (userPassword == null) {
            return false;
        }
        String expectedPaswordAndSidHash = hashService.fromString(userPassword.getPasswordHash() + sid);
        return expectedPaswordAndSidHash.equals(passwordAndSidHash);
        
    }
    
    private UserPassword fetchUserPassword(String login) {
        String loginHash = hashService.fromString(login);
        User user = usersRepository.findByLoginHash(loginHash);
        if (user == null) {
            return null;
        }
        UserPassword userPassword = passwordsRepository.findById(user.getPasswordId());
        return userPassword;
    }

}

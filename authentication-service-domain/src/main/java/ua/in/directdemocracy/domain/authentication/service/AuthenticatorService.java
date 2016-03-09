package ua.in.directdemocracy.domain.authentication.service;

import javax.annotation.Resource;

import ua.in.directdemocracy.domain.authentication.model.user.User;
import ua.in.directdemocracy.domain.authentication.model.user.UserRepository;
import ua.in.directdemocracy.domain.authentication.model.userpassword.UserPassword;
import ua.in.directdemocracy.domain.authentication.model.userpassword.UserPasswordRepository;

public class AuthenticatorService {

    @Resource
    UserRepository usersRepository;
    
    @Resource
    UserPasswordRepository passwordsRepository;
    
    @Resource
    HashService hashService;
    
    public boolean authenticateUserByPassword(String login, String password) {
        String passwordhash = hashService.createHash(login, password);
        UserPassword userPassword = passwordsRepository.findByPasswordHash(passwordhash);
        if (userPassword == null) {
            return false;
        }
        User user = usersRepository.findById(userPassword.getId());
        if (user.getPasswordId().equals(userPassword.getId())) {
            return false;
        }
        return true;
    }
}

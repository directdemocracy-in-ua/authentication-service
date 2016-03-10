package ua.in.directdemocracy.domain.authentication.service;

import javax.annotation.Resource;

import ua.in.directdemocracy.domain.authentication.exceptions.UserAlreadyExistException;
import ua.in.directdemocracy.domain.authentication.exceptions.UserNotFoundException;
import ua.in.directdemocracy.domain.authentication.model.user.User;
import ua.in.directdemocracy.domain.authentication.model.user.UserRepository;
import ua.in.directdemocracy.domain.authentication.model.userpassword.UserPassword;
import ua.in.directdemocracy.domain.authentication.model.userpassword.UserPasswordRepository;

public class AdministionService {


    @Resource
    UserRepository usersRepository;
    
    @Resource
    UserPasswordRepository passwordsRepository;
    
    @Resource
    HashService hashService;
    
    public void createNewUser(String login, String password) throws UserAlreadyExistException {
        String loginHash = hashService.fromString(login);
        if (usersRepository.findByLoginHash(loginHash) != null) {
            throw new UserAlreadyExistException(login);
        }
        User user = createNewUser(loginHash);
        UserPassword userPassword = createNewUserPassword(password);
        
        user.setPasswordId(userPassword.getId());
        usersRepository.save(user);
        
        userPassword.setUserId(user.getId());
        passwordsRepository.save(userPassword);
        
    }
    
    public void changeUserPassword(String login, String newPassword) throws UserNotFoundException {
        String loginHash = hashService.fromString(login);
        User user = usersRepository.findByLoginHash(loginHash);
        if (user == null) {
            throw new UserNotFoundException(login);
        }
        UserPassword userPassword = createNewUserPassword(newPassword);
        user.setPasswordId(userPassword.getId());
        usersRepository.save(user);
    }

    private UserPassword createNewUserPassword(String password) {
        UserPassword newPassword = new UserPassword();
        newPassword.setPasswordHash(hashService.fromString(password));
        UserPassword userPassword = passwordsRepository.save(newPassword);
        return userPassword;
    }

    private User createNewUser(String loginHash) {
        User newUser = new User();
        newUser.setLoginHash(loginHash);
        User user = usersRepository.save(newUser);
        return user;
    }
    
    
}

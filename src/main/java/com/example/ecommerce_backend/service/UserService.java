package com.example.ecommerce_backend.service;


import com.example.ecommerce_backend.api.exception.UserAlreadyExistsException;
import com.example.ecommerce_backend.api.model.LoginBody;
import com.example.ecommerce_backend.api.model.RegistrationBody;
import com.example.ecommerce_backend.model.User;
import com.example.ecommerce_backend.model.dao.UserDAO;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;
import java.util.Optional;

@Service
public class UserService {

    private UserDAO userDAO;
    private EncryptionService encryptionService;
    private JWTService jwtService;

    public UserService(UserDAO userDAO, EncryptionService encryptionService, JWTService jwtService) {
        this.userDAO = userDAO;
        this.encryptionService = encryptionService;
        this.jwtService = jwtService;

    }

    public User registerUser(RegistrationBody registrationBody)throws UserAlreadyExistsException
    {
        if(userDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent() ||
                userDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()){
            throw new UserAlreadyExistsException("User with email " + registrationBody.getEmail() + " already exists.");
        }
        User user = new User();
        user.setUsername(registrationBody.getFirstName());
        user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        return userDAO.save(user);
    }

    public String loginUser(LoginBody loginBody){
        Optional<User> opUser = userDAO.findByUsernameIgnoreCase(loginBody.getUsername());
        if(opUser.isPresent()){
            User user = opUser.get();
            if(encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())){
                return jwtService.generateJWT(user);
            }
        }
        return null;
    }


}

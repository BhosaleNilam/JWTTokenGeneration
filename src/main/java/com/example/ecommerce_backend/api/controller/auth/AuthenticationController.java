package com.example.ecommerce_backend.api.controller.auth;


import com.example.ecommerce_backend.api.exception.UserAlreadyExistsException;
import com.example.ecommerce_backend.api.exception.dto.ErrorResponse;
import com.example.ecommerce_backend.api.exception.dto.SuccessResponse;
import com.example.ecommerce_backend.api.model.LoginBody;
import com.example.ecommerce_backend.api.model.LoginResponseBody;
import com.example.ecommerce_backend.api.model.RegistrationBody;
import com.example.ecommerce_backend.model.User;
import com.example.ecommerce_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController
{
    private UserService userService;

    private SuccessResponse successResponse;
    public AuthenticationController(UserService userService, SuccessResponse successResponse){
        this.userService = userService;
        this.successResponse = successResponse;
    }
    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody){
        try{
            userService.registerUser(registrationBody);
            successResponse.setMessage("UserRegistration is Successful.");
            return ResponseEntity.status(HttpStatus.OK).body(successResponse);

        }catch (UserAlreadyExistsException ex){
            ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT.value());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        }
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginBody loginBody){

        String jwt = userService.loginUser(loginBody);
        if(jwt == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else{
            LoginResponseBody loginResponse = new LoginResponseBody();
            loginResponse.setJwt(jwt);
            return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
        }
    }

    @GetMapping("/me")
    public User getLoggedInUser(@AuthenticationPrincipal User user){
        return user;
    }
}

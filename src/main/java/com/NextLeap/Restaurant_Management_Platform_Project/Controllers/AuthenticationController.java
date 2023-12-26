package com.NextLeap.Restaurant_Management_Platform_Project.Controllers;

import com.NextLeap.Restaurant_Management_Platform_Project.Exceptions.UserAlreadyExistException;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Authentication.DTO.AuthenticationResponse;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Authentication.DTO.SignInRequest;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Authentication.DTO.SignUpRequest;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Enitity.User;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant-platform/v1/")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> userSignUpRequest(@RequestBody SignUpRequest signUpReq){
        try{
            User userAdded = authenticationService.registerUserToDB(signUpReq);
            return ResponseEntity.ok().body(userAdded);
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> userSignInRequest(@RequestBody SignInRequest signInReq){
        try{
            AuthenticationResponse authenticationResponse = authenticationService.authenticateSignInRequest(signInReq);
            return ResponseEntity.ok().body(authenticationResponse);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/checkout")
    public ResponseEntity<?> checkoutCart(){
        return ResponseEntity.ok().body("This is your cart, customer can only see this");

    }

}

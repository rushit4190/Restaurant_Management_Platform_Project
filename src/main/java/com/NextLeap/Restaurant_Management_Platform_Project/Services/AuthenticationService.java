package com.NextLeap.Restaurant_Management_Platform_Project.Services;

import com.NextLeap.Restaurant_Management_Platform_Project.Exceptions.UserAlreadyExistException;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Authentication.DTO.AuthenticationResponse;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Authentication.DTO.SignInRequest;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Authentication.DTO.SignUpRequest;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Enitity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthenticationService {

    User registerUserToDB(SignUpRequest userSignUpRequest) throws UserAlreadyExistException;

    Boolean checkIfUserExists(String email);

    User fetchUserByEmail(String email);

    AuthenticationResponse authenticateSignInRequest(SignInRequest userSignInRequest) throws UsernameNotFoundException;
}

package com.NextLeap.Restaurant_Management_Platform_Project.Services.Impl;

import com.NextLeap.Restaurant_Management_Platform_Project.Exceptions.UserAlreadyExistException;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Authentication.DTO.AuthenticationResponse;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Authentication.DTO.SignInRequest;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Authentication.DTO.SignUpRequest;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Enitity.User;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Enum.Role;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.UserRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.AuthenticationService;
import com.NextLeap.Restaurant_Management_Platform_Project.Utility.JwtUtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtilService jwtUtilService;

    @Override
    public User registerUserToDB(SignUpRequest userSignUpRequest) throws UserAlreadyExistException {

        //Assuming the authenticity of JSON payload is checked by client browser

        String emailToRegister = userSignUpRequest.getEmail();

        if(checkIfUserExists(emailToRegister)){
            throw new UserAlreadyExistException(" User with email : " + emailToRegister +" already exists");
        }

        User userToRegister = User.builder()
                .email(emailToRegister)
                .firstName(userSignUpRequest.getFirstName())
                .lastName(userSignUpRequest.getLastName())
                .password(passwordEncoder.encode(userSignUpRequest.getPassword()))
                .role( userSignUpRequest.getRole() == null ? Role.CUSTOMER : userSignUpRequest.getRole())
                .build();

        userRepository.save(userToRegister);


        return userToRegister;
    }

    @Override
    public Boolean checkIfUserExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User fetchUserByEmail(String email) {
        Optional<User> user =  userRepository.findByEmail(email);

        if(user.isPresent()){
            return user.get();
        }
        else{
            throw new UsernameNotFoundException(" User with email : " + email +" doesnt exist");
        }
    }

    @Override
    public AuthenticationResponse authenticateSignInRequest(SignInRequest userSignInRequest) throws UsernameNotFoundException {
        User userToAuthenticate = fetchUserByEmail(userSignInRequest.getEmail());

        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userSignInRequest.getEmail(), userSignInRequest.getPassword()));

        if (auth.isAuthenticated()) {

            String jwtToken = jwtUtilService.generateToken(userSignInRequest.getEmail(), userToAuthenticate.getRole());
            return AuthenticationResponse.builder().message("Token created successfully for " + userSignInRequest.getEmail()).token(jwtToken).build();
        }
        else{
            throw new UsernameNotFoundException("Invalid credentials, Please check!");
        }
    }
}

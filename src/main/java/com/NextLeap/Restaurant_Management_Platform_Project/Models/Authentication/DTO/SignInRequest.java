package com.NextLeap.Restaurant_Management_Platform_Project.Models.Authentication.DTO;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequest {

    private String email;
    private String password;

}

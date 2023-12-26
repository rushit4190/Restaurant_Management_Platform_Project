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
public class SignUpRequest {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    // role is used in JSON payload only for admin sign ups for this application.
    // by default JSON payload will not have role field,
    // and the application considers it as Customer.
    private Role role;
}

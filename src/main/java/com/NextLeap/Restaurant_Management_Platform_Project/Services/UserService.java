package com.NextLeap.Restaurant_Management_Platform_Project.Services;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Enitity.User;

import java.util.List;

public interface UserService {

    User fetchUserById(String userId);

    User fetchUserByEmail(String userEmail);

    List<User> fetchAllUsers(Integer pageNo, Integer pageSize);

    void deleteUser(String userEmail);
}

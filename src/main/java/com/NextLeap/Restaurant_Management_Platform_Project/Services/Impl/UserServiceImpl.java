package com.NextLeap.Restaurant_Management_Platform_Project.Services.Impl;

import com.NextLeap.Restaurant_Management_Platform_Project.Models.Review.Entity.Review;
import com.NextLeap.Restaurant_Management_Platform_Project.Models.Enitity.User;
import com.NextLeap.Restaurant_Management_Platform_Project.Repositories.UserRepository;
import com.NextLeap.Restaurant_Management_Platform_Project.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User fetchUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User doesn't exist for given Id"));

    }

    @Override
    public User fetchUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new NoSuchElementException("User doesn't exist for given Email"));

    }

    @Override
    public List<User> fetchAllUsers(Integer pageNo, Integer pageSize) {
        Pageable pageQuery = PageRequest.of(pageNo, pageSize);
        return userRepository.findAll(pageQuery).getContent();
    }

    @Override
    public void deleteUser(String userEmail) {
        User userToDelete = fetchUserByEmail(userEmail);

        if(!userToDelete.getReviews().isEmpty()){
            for(Review r : userToDelete.getReviews()){
                r.getRestaurant().getReviews().remove(r);
            }

            userToDelete.getReviews().clear();
        }

        userRepository.delete(userToDelete);

    }
}

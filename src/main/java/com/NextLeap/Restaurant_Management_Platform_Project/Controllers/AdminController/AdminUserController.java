package com.NextLeap.Restaurant_Management_Platform_Project.Controllers.AdminController;


import com.NextLeap.Restaurant_Management_Platform_Project.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant-platform/v1/admin/users")
public class AdminUserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getUserById(@PathVariable String userId){
        try{
            return ResponseEntity.ok().body(userService.fetchUserById(userId));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/email/{userEmail}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getUserByEmail(@PathVariable String userEmail){
        try{
            return ResponseEntity.ok().body(userService.fetchUserByEmail(userEmail));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getAllUsersByPagination(@RequestParam(defaultValue = "0") Integer pageNo,
                                                     @RequestParam(defaultValue = "3") Integer pageSize){
        try{
            return ResponseEntity.ok().body(userService.fetchAllUsers(pageNo, pageSize));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteUserByEmail(@RequestParam String userEmail){
        try{
            userService.deleteUser(userEmail);
            return ResponseEntity.ok().body("User deleted successfully");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}

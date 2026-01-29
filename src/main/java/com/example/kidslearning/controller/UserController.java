package com.example.kidslearning.controller;

import com.example.kidslearning.dto.LoginRequestDto;
import com.example.kidslearning.dto.UserDto;
import com.example.kidslearning.service.UserService;
import com.example.kidslearning.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;



    @PostMapping
    public ResponseEntity<ApiResponse<UserDto>> createUser(@RequestBody UserDto userDto) {
        UserDto created = userService.createUser(userDto);
        return ResponseEntity.ok(ApiResponse.ok("User created successfully", created));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDto>>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(ApiResponse.ok("Users fetched successfully", users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDto>> getUserById(@PathVariable Long id) {
        UserDto user = userService.getUserById(id);
        return ResponseEntity.ok(ApiResponse.ok("User fetched successfully", user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(ApiResponse.ok("User deleted successfully", null));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserDto>> login(
            @RequestBody LoginRequestDto loginRequestDto) {

        UserDto user = userService.login(loginRequestDto);
        return ResponseEntity.ok(
                ApiResponse.ok("Login successful", user)
        );
    }
}



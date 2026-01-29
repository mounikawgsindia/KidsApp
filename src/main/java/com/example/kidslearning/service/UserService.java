package com.example.kidslearning.service;

import com.example.kidslearning.dto.LoginRequestDto;
import com.example.kidslearning.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    void deleteUser(Long id);

    // ✅ Login API
    UserDto login(LoginRequestDto loginRequestDto);
}



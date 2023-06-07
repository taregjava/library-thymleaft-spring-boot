package com.booklibrary.booklibrary.service;



import com.booklibrary.booklibrary.dto.UserDto;
import com.booklibrary.booklibrary.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}

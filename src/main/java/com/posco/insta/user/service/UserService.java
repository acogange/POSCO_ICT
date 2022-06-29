package com.posco.insta.user.service;

import com.posco.insta.user.model.UserDto;
import org.apache.catalina.User;

import java.util.List;


public interface UserService {
    List<UserDto> findUser();
    UserDto findUserById(UserDto userDto);
    Integer postUser(UserDto userDto);

    Integer deleteUser(Integer id);

    Integer updateUserById(UserDto userDto);
    UserDto loginUser(UserDto userDto );
}

package com.sw.splitwise.controllers;

import com.sw.splitwise.dtos.ResponseStatus;
import com.sw.splitwise.dtos.UserRequestDto;
import com.sw.splitwise.dtos.UserResponseDto;
import com.sw.splitwise.models.User;
import com.sw.splitwise.services.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserResponseDto createNewUser(UserRequestDto requestDto) {
        UserResponseDto responseDto = new UserResponseDto();

        try{
            User user = userService.createNewUser(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword());
            responseDto.setUserId(user.getId());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}

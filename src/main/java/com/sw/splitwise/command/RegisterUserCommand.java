package com.sw.splitwise.command;

import com.sw.splitwise.controllers.UserController;
import com.sw.splitwise.dtos.UserRequestDto;
import com.sw.splitwise.dtos.UserResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUserCommand implements Command {
    private UserController userController;

    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void execute(String input){
        List<String> words = List.of(input.split(" "));

        // NOW HERE TAKE THE REGISTER COMMAND
        // EXTRACT THE USER DETAILS AND CALL THE CONTROLLER TO REGISTER THE NEW USER.
        String commandName = words.get(0);
        String name = words.get(1);
        String email = words.get(2);
        String password = words.get(3);

        UserRequestDto requestDto = new UserRequestDto();
        requestDto.setName(name);
        requestDto.setEmail(email);
        requestDto.setPassword(password);

        UserResponseDto responseDto = userController.createNewUser(requestDto);
    }

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size()==4 && words.get(0).equals(CommandKeywords.register);
    }
}

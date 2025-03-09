package com.sw.splitwise.command;

import com.sw.splitwise.controllers.GroupController;
import com.sw.splitwise.dtos.GroupRequestDto;
import com.sw.splitwise.dtos.GroupResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddGroupCommand implements Command {
    private GroupController groupController;

    public AddGroupCommand(GroupController groupController) {
        this.groupController = groupController;
    }

    @Override
    public void execute(String input){
        List<String> words = List.of(input.split(" "));

        String userId = words.get(0);
        String commandName = words.get(1);
        String groupName = words.get(2);

        GroupRequestDto requestDto = new GroupRequestDto();
        requestDto.setUserId(Long.parseLong(userId));
        requestDto.setGroupName(groupName);

        GroupResponseDto responseDto = groupController.addGroup(requestDto);
    }

    @Override
    public boolean matches(String input){
        List<String> words = List.of(input.split(" "));
        System.out.println("Executing AddGroup Command.");
        return words.size() == 3 && words.get(1).equals(CommandKeywords.addGroup);

    }

}

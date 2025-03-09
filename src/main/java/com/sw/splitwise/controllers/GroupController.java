package com.sw.splitwise.controllers;

import com.sw.splitwise.dtos.GroupRequestDto;
import com.sw.splitwise.dtos.GroupResponseDto;
import com.sw.splitwise.dtos.ResponseStatus;
import com.sw.splitwise.models.Group;
import com.sw.splitwise.repositories.GroupRepository;
import com.sw.splitwise.services.GroupService;
import org.springframework.stereotype.Controller;

@Controller
public class GroupController {
    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    public GroupResponseDto addGroup(GroupRequestDto requestDto) {
        GroupResponseDto responseDto = new GroupResponseDto();

        try{
            Group group = groupService.createNewGroup(requestDto.getGroupName(), requestDto.getUserId());
            responseDto.setGroupId(group.getId());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;

    }
}

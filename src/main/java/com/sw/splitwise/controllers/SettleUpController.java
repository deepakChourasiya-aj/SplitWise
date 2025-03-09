package com.sw.splitwise.controllers;

import com.sw.splitwise.dtos.*;
import com.sw.splitwise.models.Expense;
import com.sw.splitwise.services.SettleUpService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {
    private SettleUpService settleUpService;
    /*
        will have methods related to settle up.
        settleup functionality should return the list of transaction
        which when executed will make the net amount of a user to be ZERO.
     */
    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto requestDto){
        SettleUpUserResponseDto responseDto = new SettleUpUserResponseDto();
       try{
           List<Expense> expenses = settleUpService.settleUpUser(requestDto.getUserId());
           responseDto.setExpenseList(expenses);
           responseDto.setResponseStatus(ResponseStatus.SUCCESS);
       }catch (Exception e){
           responseDto.setResponseStatus(ResponseStatus.FAILURE);
       }
       return responseDto;
    }

    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto requestDto){
        SettleUpGroupResponseDto responseDto = new SettleUpGroupResponseDto();
        try{
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}

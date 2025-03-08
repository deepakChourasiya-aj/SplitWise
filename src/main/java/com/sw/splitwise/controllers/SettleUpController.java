package com.sw.splitwise.controllers;

import com.sw.splitwise.dtos.*;
import org.springframework.stereotype.Controller;

@Controller
public class SettleUpController {
    /*
        will have methods related to settle up.

        settleup functionality should return the list of transaction
        which when executed will make the net amount of a user to be ZERO.
     */

    public SettleUpController() {

    }
    SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto requestDto){
        SettleUpUserResponseDto responseDto = new SettleUpUserResponseDto();
       try{
           responseDto.setResponseStatus(ResponseStatus.SUCCESS);
       }catch (Exception e){
           responseDto.setResponseStatus(ResponseStatus.FAILURE);
       }
       return responseDto;
    }

    SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto requestDto){
        SettleUpGroupResponseDto responseDto = new SettleUpGroupResponseDto();
        try{
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}

package com.sw.splitwise.command;

import com.sw.splitwise.controllers.SettleUpController;
import com.sw.splitwise.dtos.ResponseStatus;
import com.sw.splitwise.dtos.SettleUpGroupRequestDto;
import com.sw.splitwise.dtos.SettleUpUserRequestDto;
import com.sw.splitwise.dtos.SettleUpUserResponseDto;
import com.sw.splitwise.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpUserCommand implements Command {
    private SettleUpController settleUpController;

    public SettleUpUserCommand(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }

    @Override
    public void execute(String input){
        List<String> words = List.of(input.split(" "));

        Long userId = Long.valueOf(words.get(0));

        SettleUpUserRequestDto requestDto = new SettleUpUserRequestDto();
        requestDto.setUserId(userId);

        SettleUpUserResponseDto responseDto = this.settleUpController.settleUpUser(requestDto);

        List<Transaction> transactions = responseDto.getTransactionsList();

        if(responseDto.getResponseStatus().equals(ResponseStatus.FAILURE)){
            System.out.println(responseDto.getResponseStatus()+" Something went wrong");
        }else{
            for(Transaction transaction : transactions){
                System.out.println(transaction.getUserFrom().getName()+" should pay "+ transaction.getUserTo().getName()+" of amount "+transaction.getAmount());
            }
        }
    }

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        System.out.println("Executing SettleUpUserCommand Command.");
        return words.size()==2 && words.get(1).equals(CommandKeywords.settleUp);
    }
}

package com.sw.splitwise.command;

import com.sw.splitwise.controllers.SettleUpController;
import com.sw.splitwise.dtos.ResponseStatus;
import com.sw.splitwise.dtos.SettleUpGroupRequestDto;
import com.sw.splitwise.dtos.SettleUpGroupResponseDto;
import com.sw.splitwise.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpGroupCommand implements Command {

    @Autowired
    private SettleUpController settleUpController;

    @Override
    public void execute(String input){
        List<String> words = List.of(input.split(" "));
        Long groupId = Long.valueOf(words.get(0));

        SettleUpGroupRequestDto requestDto = new SettleUpGroupRequestDto();
        requestDto.setGroupId(groupId);

        SettleUpGroupResponseDto responseDto = this.settleUpController.settleUpGroup(requestDto);
        System.out.println(responseDto.getResponseStatus());

        List<Transaction> transactions = responseDto.getTransactionList();

        if(responseDto.getResponseStatus().equals(ResponseStatus.FAILURE)){
            System.out.println(responseDto.getResponseStatus()+" Something went wrong");
        }else{
            for(Transaction transaction : transactions){
                System.out.println(transaction.getUserFrom().getName()+" has paid to "+transaction.getUserTo().getName()+" of amount "+ transaction.getAmount());
            }
        }
    }
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        System.out.println("Executing SettleUpGroupCommand Command.");
        return words.size()==3 && words.get(0).equals("SettleUp");
    }
}

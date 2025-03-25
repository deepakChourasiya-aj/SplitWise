package com.sw.splitwise.dtos;

import com.sw.splitwise.models.Expense;
import com.sw.splitwise.models.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {
    private List<Transaction> transactionList;
    private ResponseStatus responseStatus;
}

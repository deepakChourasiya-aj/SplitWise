package com.sw.splitwise.dtos;

import com.sw.splitwise.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDto {
    private List<Expense> expenseList;
    private ResponseStatus responseStatus;
}

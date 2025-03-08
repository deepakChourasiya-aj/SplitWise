package com.sw.splitwise.dtos;

import com.sw.splitwise.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {
    private List<Expense> expenses;
    private ResponseStatus responseStatus;
}

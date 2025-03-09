package com.sw.splitwise.strategies;

import com.sw.splitwise.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    // common method for all the strategies will build..
    List<Expense> settleUp(List<Expense> expenses);
}

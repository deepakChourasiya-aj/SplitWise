package com.sw.splitwise.strategies;

import com.sw.splitwise.models.Expense;
import com.sw.splitwise.models.Transaction;

import java.util.List;

public interface SettleUpStrategy {
    // common method for all the strategies will build..
    List<Transaction> settleUp(List<Expense> expenses);
}

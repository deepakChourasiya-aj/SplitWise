package com.sw.splitwise.strategies;

import com.sw.splitwise.models.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        // HERE WE HAVE TO IMPLEMENT THE SETTLE UP STRATEGY USING THE HEAP
        // ALGORITHEM.. IMPLEMENT...IT..
        System.out.println(expenses);
        for(Expense expense : expenses){
            System.out.println(expense+" User expense "+expense.getAmount()+" id: "+expense.getId());
        }
        return List.of();
    }
}

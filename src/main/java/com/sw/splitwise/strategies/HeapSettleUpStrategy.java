package com.sw.splitwise.strategies;

import com.sw.splitwise.models.Expense;
import com.sw.splitwise.models.ExpenseUser;
import com.sw.splitwise.models.Transaction;
import com.sw.splitwise.models.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        // HERE WE HAVE TO IMPLEMENT THE SETTLE UP STRATEGY USING THE HEAP
        // ALGORITHEM.. IMPLEMENT...IT..
        HashMap<User,Integer> expensesMap = new HashMap<>();


        // CALCULATE THE NET AMOUNT HERE FOR EACH USER HAS TO PAY INDIVIDUALLY..
        for(Expense expense : expenses){
            for(ExpenseUser expenseUser : expense.getExpenseUsers()){
                if(expensesMap.containsKey(expenseUser.getUser())){
                    expensesMap.put(expenseUser.getUser(),expensesMap.get(expenseUser.getUser())+expenseUser.getAmount());
                }else{
                    expensesMap.put(expenseUser.getUser(),expensesMap.get(expenseUser.getUser()));
                }
            }
        }

        PriorityQueue<Map.Entry<User,Integer>> positiveHeap = new PriorityQueue<>(
                (a,b)->b.getValue().compareTo(a.getValue())
        );
        PriorityQueue<Map.Entry<User,Integer>> negativeHeap = new PriorityQueue<>(
                (a,b)->a.getValue().compareTo(b.getValue())
        );

        // PUSHING THE ENTRIES INTO THE HEAP BASED ON + AND - CONDITION CREDITORS AND DEBTERS
        for(Map.Entry<User,Integer> entry : expensesMap.entrySet()){
            if(entry.getValue() > 0){
                positiveHeap.add(entry);
            }else if(entry.getValue() < 0){
                negativeHeap.add(entry);
            }
        }

        List<Transaction> settlements = new ArrayList<>();

        while(!positiveHeap.isEmpty() && !negativeHeap.isEmpty()){
            Map.Entry<User,Integer> positive = positiveHeap.poll();
            Map.Entry<User,Integer> negative = negativeHeap.poll();

            int settlementAmount = Math.min(positive.getValue(),-negative.getValue());

            settlements
                    .add(new Transaction(negative.getKey(),positive.getKey(),settlementAmount));

            positive.setValue(positive.getValue()-settlementAmount);
            negative.setValue(negative.getValue()+settlementAmount);

            if(positive.getValue() > 0){
                positiveHeap.offer(positive);
            }else if(negative.getValue() < 0){
                negativeHeap.offer(negative);
            }
        }
        return  settlements;
    }
}

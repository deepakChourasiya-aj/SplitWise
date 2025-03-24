package com.sw.splitwise.strategies;

import com.sw.splitwise.models.Expense;
import com.sw.splitwise.models.ExpenseUser;
import com.sw.splitwise.models.Transaction;
import com.sw.splitwise.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component("GeneralSettleUpStrategy")
public class GeneralSettleUpStrategy implements SettleUpStrategy {

    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {

        HashMap<User,Integer> expensesMap = new HashMap<>();

        for(Expense expense : expenses){
            for(ExpenseUser expenseUser : expense.getExpenseUsers()){
                if(expensesMap.containsKey(expenseUser.getUser())){
                    expensesMap.put(expenseUser.getUser(),expensesMap.get(expenseUser.getUser()) + expenseUser.getAmount());
                }else{
                    expensesMap.put(expenseUser.getUser(),expenseUser.getAmount());
                }
            }
        }

        List<Transaction> transactions = new ArrayList<>();

        for(User user : expensesMap.keySet()){
            System.out.println(user.getName()+" "+ expensesMap.get(user));
        }

        List<User> userList = new ArrayList<>(expensesMap.keySet());

        for(int i = 0; i<userList.size(); i++){
            Transaction transaction =  new Transaction(null,null,0);

            if(expensesMap.get(userList.get(i))<0){
                transaction.setUserFrom(userList.get(i));
                transaction.setAmount(Math.abs(expensesMap.get(userList.get(i))));
                transaction.setUserTo(userList.get(i+1));
                transactions.add(transaction);
                expensesMap.put(userList.get(i+1),expensesMap.get(userList.get(i+1)) + expensesMap.get(userList.get(i)));
            }else if(expensesMap.get(userList.get(i))>0){
                transaction.setUserFrom(userList.get(i+1));
                transaction.setAmount(Math.abs(expensesMap.get(userList.get(i))));
                transaction.setUserTo(userList.get(i));
                transactions.add(transaction);
                expensesMap.put(userList.get(i+1),expensesMap.get(userList.get(i+1))+expensesMap.get(userList.get(i)));
            }
        }
        return transactions;
    }
}

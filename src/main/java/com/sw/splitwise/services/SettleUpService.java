package com.sw.splitwise.services;

import com.sw.splitwise.exceptions.UserNotFoundException;
import com.sw.splitwise.models.Expense;
import com.sw.splitwise.models.ExpenseUser;
import com.sw.splitwise.models.User;
import com.sw.splitwise.repositories.ExpenseUserRepository;
import com.sw.splitwise.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SettleUpService {
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;

    public SettleUpService(UserRepository userRepository, ExpenseUserRepository expenseUserRepository) {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
    }

    public List<Expense> settleUpUser(Long userId){
        /**
         *  1. GET THE USER FROM THE GIVEN USER ID FROM THE DB
         *  2. GET ALL THE EXPENSE IN WHICH THIS USER IS INVOLVED .
         *  3. ITERATE THROUGH ALL THE EXPENSE AND FIND OUT WHO HAS PAID EXTRA/LESSER
         *  FOR EVERY USER INVOVLED IN THE ABOVE LIST OF EXPENSE
         *  4. USE MIN HEAP AND MAX HEAP TO FIND OUT THE LIST OF TRNASACTION WILL REQUIRE TO SETTLE UP THE USER.
         */
        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User not found with id " + userId);
        }

        User user = optionalUser.get();

//        GET THE LIST OF EXPENSEUSERS OF PARTICULAR USER..
        List<ExpenseUser> expenseUsers = expenseUserRepository.findByUser(user);

        Set<Expense> expenses = new HashSet<>();
        for(ExpenseUser expenseUser: expenseUsers){
            expenses.add(expenseUser.getExpense());
        }

        // Convert a set into list.
        List<Expense> expensesToSettuleUp = expenses.stream().toList();

        // Heap Algorithem to settle up the list of expense.
        // Not only heap algorithem we can have multiple algorithem to settle the expense,
        // here we can implement the strategy design pattern to(settleUpStrategy) to settleup the expenses,
        // also ask which method people want to use (good idea)..
        List<Expense> finalExpenses =

        return null;
    }

    public List<Expense> settleUpGroup(Long groupId){
        return null;
    }
}

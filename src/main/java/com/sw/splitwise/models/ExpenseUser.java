package com.sw.splitwise.models;

import com.sw.splitwise.models.enums.ExpenseUserType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="expense_users")
public class ExpenseUser extends BaseModel {
    @ManyToOne
    private Expense expense;

    @ManyToOne
    private User user;

    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseUserType expenseUserType;
}

/*
      1               1
    EXPENSEUSER ---EXPENSE
      M               1
     1                1
     EXPENSEUSER -- USER
     M                1
 */

package com.sw.splitwise.models;

import com.sw.splitwise.models.enums.ExpenseType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="expenses")
public class Expense extends BaseModel {
    // AMOUNT, DESCRIPTION, PAID BY, HADTOPAY, LIST<USERID,HADTOPAY>,LIST<USERID,PAIDBY>;
    // Private String desc; > do not use desc its are reserved keyword resolved the error..good learning..haaaaa
    private String description;
    private double amount;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @ManyToOne
    private Group group;

    @OneToMany(mappedBy = "expense")
    private List<ExpenseUser> expenseUsers;

}
/*
      1                M
  EXPENSE           EXPENSE_USER
                        1

 */

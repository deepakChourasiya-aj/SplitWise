package com.sw.splitwise.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {
    private User userFrom;
    private User userTo;
    private int amount;
}

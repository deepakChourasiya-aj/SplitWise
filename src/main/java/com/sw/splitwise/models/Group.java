package com.sw.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="groupss")
public class Group extends BaseModel{
    // what all we need for the groupp think of it...
    // name ,id ,List<Members/User> lets say, List<Expense> with each user and their ratio.
    // private
    private String name;

    @ManyToOne
    private User createdBy;

    @ManyToMany
    private List<User> members;

    @ManyToMany
    private List<Expense> expenses;
}

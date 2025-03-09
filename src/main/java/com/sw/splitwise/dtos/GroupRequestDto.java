package com.sw.splitwise.dtos;

import com.sw.splitwise.models.Expense;
import com.sw.splitwise.models.User;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupRequestDto {
    Long userId;
    String groupName;
}

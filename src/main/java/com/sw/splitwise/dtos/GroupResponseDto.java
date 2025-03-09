package com.sw.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupResponseDto {
    private Long groupId;
    private ResponseStatus responseStatus;
}

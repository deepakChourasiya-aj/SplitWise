package com.sw.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long userId;
    private ResponseStatus responseStatus;
}


package org.example.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRequestDto {
    private String email;
    private String password;
}
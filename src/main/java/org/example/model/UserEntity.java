package org.example.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserEntity {
    private long id;
    private String email;
    private String password;
}
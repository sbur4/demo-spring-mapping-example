package org.example.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class User {
    private String email;
    private String password;
    private LocalDateTime updated;
}
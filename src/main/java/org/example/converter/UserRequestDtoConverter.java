package org.example.converter;

import org.example.dto.UserRequestDto;
import org.example.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class UserRequestDtoConverter implements Converter<UserRequestDto, User> {

    @Override
    public User convert(UserRequestDto dto) {
        return User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .updated(LocalDateTime.now())
                .build();
    }
}
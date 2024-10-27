package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.UserDto;
import org.example.dto.UserRequestDto;
import org.example.mapper.UserMapper;
import org.example.model.User;
import org.example.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/hello")
    public ResponseEntity<User> springConverter(@RequestBody UserRequestDto userRequestDto) {
        log.debug("Received a request for greeting with dto: {}", userRequestDto);

        User user = conversionService.convert(userRequestDto, User.class);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/hello")
    public ResponseEntity<UserEntity> mapstructMapper(@RequestBody UserDto userDto) {
        log.debug("Received a request for greeting with dto: {}", userDto);

        UserEntity user = userMapper.toEntity(userDto);
        // or
//        UserEntity user = UserMapper.INSTANCE.toEntity(userDto);

        return ResponseEntity.ok(user);
    }
}
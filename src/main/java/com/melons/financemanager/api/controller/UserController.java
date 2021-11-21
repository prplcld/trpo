package com.melons.financemanager.api.controller;

import com.melons.financemanager.service.UserService;
import com.melons.financemanager.service.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private  final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }
}

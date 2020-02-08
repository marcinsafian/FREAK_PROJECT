package com.freak.project.controller;

import com.freak.project.exception.UserExistException;
import com.freak.project.service.UserService;
import com.freak.project.user.NewUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED, reason ="User_added")
    public void addUser(@RequestBody NewUserDto newUserDto) throws UserExistException{userService.addUser(newUserDto);}
}

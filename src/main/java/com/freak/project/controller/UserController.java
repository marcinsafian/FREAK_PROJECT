package com.freak.project.controller;

import com.freak.project.exception.UserExistException;
import com.freak.project.exception.UserNotFoundException;
import com.freak.project.service.UserService;
import com.freak.project.user.NewUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/adduser")
    @ResponseStatus(value = HttpStatus.CREATED, reason ="User added")
    public void addUser(@RequestBody NewUserDto newUserDto) throws UserExistException{userService.addUser(newUserDto);}

    @GetMapping
    public List<NewUserDto> getAllUsers(){return userService.getAllUsers();}

    @GetMapping(value = "/id/{userId}")
    public NewUserDto getUser(@PathVariable(name = "userId")Long id) throws UserNotFoundException{
        return userService.getById(id);
    }

    @GetMapping(value = "/name/{userName}")
    public NewUserDto getUserByName(@PathVariable(name = "userName")String userName) throws UserNotFoundException{
        return userService.getByName(userName);
    }

    @PutMapping
    public NewUserDto updateUser(@RequestBody NewUserDto newUserDto) throws UserNotFoundException {return userService.updateUser(newUserDto);}

    @DeleteMapping(value = "/del/{userId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "delete - done!")
    public void deleteUser(@PathVariable(name = "userId")Long id) throws UserNotFoundException{
        userService.deleteUser(id);
    }
}

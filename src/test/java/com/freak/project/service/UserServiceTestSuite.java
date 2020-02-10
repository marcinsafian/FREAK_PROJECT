package com.freak.project.service;

import com.freak.project.exception.UserExistException;
import com.freak.project.exception.UserNotFoundException;
import com.freak.project.mapper.UserMapper;
import com.freak.project.reposytory.UserRepository;
import com.freak.project.user.NewUserDto;
import com.freak.project.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTestSuite {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserMapper userMapper;


    @Test
    void shouldAddUserReturnSavedUserId() throws UserExistException {
        //Given
        User userToSave = new User();
        User savedUser = new User();
        savedUser.setId(1L);
        NewUserDto userDto = new NewUserDto();
        when(userMapper.mapToUser(userDto)).thenReturn(userToSave);
        when(userRepository.save(userToSave)).thenReturn(savedUser);

        //When
        Long savedUserId = userService.addUser(userDto);

        //Then
        assertEquals(1L, savedUserId);

    }
    @Test
    void shouldGetUserByUsernameReturnUserDtoNoId(){
        User user = new User("firstName","lastName","userName","password","email",true);
        NewUserDto newUserDto = new NewUserDto("firstName","lastName","userName","password","email",true);
        when(userRepository.findByUserName(anyString())).thenReturn(Optional.of(user));
        when(userMapper.mapToUserDto(user)).thenReturn(newUserDto);

        //When
        NewUserDto fetchUser = userService.getByName(anyString());

        //Then
        assertEquals(newUserDto, fetchUser);
    }

    @Test
    void shouldGetUserByIdReturnUserDtoNoId(){
        User user = new User("firstName","lastName","userName","password","email",true);
        NewUserDto newUserDto = new NewUserDto("firstName","lastName","userName","password","email",true);
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(userMapper.mapToUserDto(user)).thenReturn(newUserDto);
    }

    @Test
    void shouldUpdateUserThrowUserNotFoundException() {
        //Given
        when(userRepository.findByUserName(anyString())).thenReturn(Optional.empty());

        //When & Then
        assertThrows(UserNotFoundException.class, () -> userService.updateUser(new NewUserDto()));
    }


}

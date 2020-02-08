package com.freak.project.service;

import com.freak.project.exception.UserExistException;
import com.freak.project.mapper.UserMapper;
import com.freak.project.reposytory.UserRepository;
import com.freak.project.user.NewUserDto;
import com.freak.project.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
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
}

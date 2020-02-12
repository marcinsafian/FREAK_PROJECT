package com.freak.project.controller;

import com.freak.project.service.UserService;
import com.freak.project.user.NewUserDto;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    void shouldFetchEmptyList()throws Exception{
        //Given
        List<NewUserDto> newUserDtos = new ArrayList<>();
        when(userService.getAllUsers()).thenReturn(newUserDtos);

        //When & Then
        mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }
    @Test
    void shouldFetchUserList() throws Exception{
        //Given
        NewUserDto user1 = new NewUserDto("name1","lastname1","username1","password1","email1",true);
        NewUserDto user2 = new NewUserDto("name2","lastname2","username2","password2","email2",true);
        List<NewUserDto> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        when(userService.getAllUsers()).thenReturn(users);
        //When &Then
        mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].firstName", is("name1")))
                .andExpect(jsonPath("$[1].firstName",is("name2")));

    }
    @Test
    void shouldAddUser() throws Exception {
        //Given
        NewUserDto newUserDto = new NewUserDto(
                "fName",
                "lName",
                "uName",
                "pass",
                "mail",true);

        when(userService.addUser(newUserDto)).thenReturn(1L);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(newUserDto);

        //When & Then
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is(201))
                .andExpect(status().reason("User added"));
    }

}
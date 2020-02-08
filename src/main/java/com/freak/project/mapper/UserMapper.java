package com.freak.project.mapper;

import com.freak.project.user.NewUserDto;
import com.freak.project.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(NewUserDto newUserDto) {
        return new User(newUserDto.getFirstName(), newUserDto.getLastName(),newUserDto.getUserName(),
                newUserDto.getPassword(),newUserDto.getEmail(), newUserDto.isSchedulerOn());
    }
}

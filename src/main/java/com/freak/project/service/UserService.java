package com.freak.project.service;


import com.freak.project.exception.UserExistException;
import com.freak.project.mapper.UserMapper;
import com.freak.project.reposytory.LogRepository;
import com.freak.project.reposytory.UserRepository;
import com.freak.project.statistic.RegistrationLog;
import com.freak.project.user.NewUserDto;
import com.freak.project.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LogRepository logRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

   // public UserService() {}

    public Long addUser(NewUserDto dtoNewUser) throws UserExistException {
        if (isUserNameNew(dtoNewUser.getUserName())) {
            User user = userRepository.save(userMapper.mapToUser(dtoNewUser));
            LOGGER.info("User added with id: "+user.getId()+".");
            logRepository.save(new RegistrationLog(LocalDateTime.now(),user.getUserName()));
            return user.getId();
        }
        LOGGER.info("User "+dtoNewUser.getUserName()+" alredy exist");
        throw new UserExistException();
    }

    public boolean isUserNameNew(String userName) {
        return !(userRepository.findByUserName(userName).isPresent());
    }
}

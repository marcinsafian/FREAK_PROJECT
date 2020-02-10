package com.freak.project.service;

import com.freak.project.exception.UserExistException;
import com.freak.project.exception.UserNotFoundException;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LogRepository logRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserService() {}

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
    public List<NewUserDto> getAllUsers() {
        LOGGER.info("Fetching users from database...");
        List<NewUserDto> userDtos = new ArrayList<>();
        userRepository.findAll().forEach(u -> userDtos.add(userMapper.mapToUserDto(u)));
        return userDtos;
    }
    public NewUserDto getById(Long id){
        return userMapper.mapToUserDto(userRepository.findById(id).get());
    }
    public NewUserDto getByName(String name){return userMapper.mapToUserDto(userRepository.findByUserName(name).get()); }

    public void deleteUser(Long id) throws UserNotFoundException {
        LOGGER.info("Looking to just delete...");
        userRepository.deleteById(id);
        LOGGER.error("Nothing to delete");
        throw new UserNotFoundException();
    }

    public NewUserDto updateUser(NewUserDto newUserDto) throws UserNotFoundException {
        LOGGER.info("Searching for... " + newUserDto.getUserName() + " to update...");
        if (userRepository.findByUserName(newUserDto.getUserName()).isPresent()) {
            User user = userRepository.findByUserName(newUserDto.getUserName()).get();
            user.setFirstName(newUserDto.getFirstName());
            user.setLastName(newUserDto.getLastName());
            user.setEmail(newUserDto.getEmail());
            user.setSchedulerOn(newUserDto.isSchedulerOn());
            return userMapper.mapToUserDto(userRepository.save(user));
        } else {
            LOGGER.error("Call 911... There's no " + newUserDto.getUserName());
            throw new UserNotFoundException();
        }
    }


    public boolean isUserNameNew(String userName) {
        return !(userRepository.findByUserName(userName).isPresent());
    }
}

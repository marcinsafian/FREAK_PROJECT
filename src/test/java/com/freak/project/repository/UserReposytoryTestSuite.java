package com.freak.project.repository;
import com.freak.project.exception.UserExistException;
import com.freak.project.reposytory.UserRepository;
import com.freak.project.user.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserReposytoryTestSuite {

    @Autowired
    private UserRepository userRepository;

    private static Long userId;
    private static User user;

    @BeforeEach
    public void sampleDB(){
        user = new User("TestFirstName", "TestLastName", "TestUserName",
                "TestPassword","Test e-mail",true);
    }

    @Test
    @Order(1)
    public void testSaveUser() {
        //Given

        //When
        userRepository.save(user);
        userId = user.getId();

        //Then
        assertTrue(userRepository.findById(userId).isPresent());
    }

    @Test
    @Order(2)
    public void testFindByUserName() throws UserExistException {
        //Given

        //When
        userRepository.findByUserName("TestUserName").orElseThrow(UserExistException::new);
        userId = user.getId();

        //Then
        assertEquals(userId, user.getId());
        assertEquals("TestFirstName", user.getFirstName());
        assertEquals("TestLastName", user.getLastName());
        assertEquals("TestUserName", user.getUserName());
        assertEquals("TestPassword", user.getPassword());
        assertEquals("Test e-mail", user.getEmail());
        assertTrue(user.isSchedulerOn());
    }

    @Test
    @Order(3)
    public void testDeleteUser() {
        //Given
        userRepository.save(user);
        userId = user.getId();
        //When
        userRepository.deleteById(userId);
        //
        assertFalse(userRepository.findById(userId).isPresent());

    }
}
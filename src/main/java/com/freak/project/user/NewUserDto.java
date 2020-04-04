package com.freak.project.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewUserDto {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private boolean schedulerOn;
}

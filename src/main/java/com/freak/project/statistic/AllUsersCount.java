package com.freak.project.statistic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table
public class AllUsersCount {
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, unique = true)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "registeredUsers")
    private int registeredUsers;

    @Column(name = "emailsSent")
    private int emailsSent;

    public AllUsersCount(LocalDateTime now, int userCount, int emailCount) {
    }
}

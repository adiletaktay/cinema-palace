package com.cinema_palace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "userSubscription")
public class UserSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionId;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "plan", nullable = false)
    private String plan;

    @Column(name = "startDate", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "expDate", nullable = false)
    private LocalDateTime expDate;
}

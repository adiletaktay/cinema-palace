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
@Table(name = "transactions")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long referenceNo;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "cardNumber")
    private String cardNumber;

    @Column(name = "paymentAmount", nullable = false)
    private double paymentAmount;

    @Column(name = "paymentDateTime")
    private LocalDateTime paymentDateTime;
}
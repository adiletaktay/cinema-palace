package com.cinema_palace.repository;

import com.cinema_palace.model.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSubscriptionRepo extends JpaRepository<UserSubscription, Long> {
    Optional<UserSubscription> findByEmail(String email);
}

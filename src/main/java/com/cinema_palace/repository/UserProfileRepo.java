package com.cinema_palace.repository;

import com.cinema_palace.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByGameHandle(String gameHandle);
    Optional<UserProfile> findByEmailAndProfileName(String email, String profileName);
    void deleteByEmailAndProfileName(String email, String profileName);
    List<UserProfile> findAllByEmail(String email);
}
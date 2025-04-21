package com.cinema_palace.repository;

import com.cinema_palace.model.UserVideoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PreferencesRepo extends JpaRepository<UserVideoList, Long> {
    void deleteByEmailAndProfileNameAndVideoTitle(String email, String profileName, String videoTitle);
    List<UserVideoList> findAllByEmailAndProfileName(String email, String profileName);
    Optional<UserVideoList> findByEmailAndProfileNameAndVideoTitle(String email, String profileName, String videoTitle);
}
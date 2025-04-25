package com.cinema_palace.repository;

import com.cinema_palace.model.UserVideoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PreferencesRepo extends JpaRepository<UserVideoList, Long> {
    @Modifying
    @Query("UPDATE UserVideoList v SET v.profileName = :newProfileName WHERE v.email = :email AND v.profileName = :oldProfileName")
    void updateProfileNameInUserVideoList(String email, String oldProfileName, String newProfileName);
    void deleteByEmailAndProfileNameAndVideoTitle(String email, String profileName, String videoTitle);
    void deleteByEmailAndProfileName(String email, String profileName);
    List<UserVideoList> findAllByEmailAndProfileName(String email, String profileName);
    Optional<UserVideoList> findByEmailAndProfileNameAndVideoTitle(String email, String profileName, String videoTitle);
}
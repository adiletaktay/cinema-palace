package com.cinema_palace.service;

import com.cinema_palace.model.UserProfile;

import java.util.List;

public interface UserProfileService {
    UserProfile addProfile(UserProfile newProfile);
    UserProfile updateProfile(UserProfile updateProfile, String email, String profileName);
    void deleteProfile(String email, String profileName);
    boolean validateProfileName(String email, String profileName);
    boolean validateGameHandle(String gameHandle);
    List<UserProfile> getAllProfiles(String email);
}
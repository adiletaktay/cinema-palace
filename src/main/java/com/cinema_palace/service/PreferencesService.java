package com.cinema_palace.service;

import com.cinema_palace.model.UserVideoList;

import java.util.List;

public interface PreferencesService {
    void removeFromList(String email, String profileName, String videoTitle);
    void removeProfile(String email, String profileName);
    UserVideoList addToList(UserVideoList addVideo);
    List<UserVideoList> getAllInList(String email, String profileName);
    boolean checkInList(String email, String profileName, String videoTitle);
}
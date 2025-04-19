package com.cinema_palace.service;

import com.cinema_palace.model.UserVideoList;

import java.util.List;

public interface PreferencesService {
    void removeFromList(String email, String profileName, String videoTitle);
    UserVideoList addToList(UserVideoList addVideo);
    List<UserVideoList> getAllInList(String email, String profileName);
}
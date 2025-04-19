package com.cinema_palace.service.implementation;

import com.cinema_palace.model.UserVideoList;
import com.cinema_palace.repository.PreferencesRepo;
import com.cinema_palace.service.PreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferencesServiceImpl implements PreferencesService {

    @Autowired
    private PreferencesRepo preferencesRepository;

    public UserVideoList addToList(UserVideoList addVideo) {
        return preferencesRepository.save(addVideo);
    }

    public List<UserVideoList> getAllInList(String email, String profileName) {
        return preferencesRepository.findAllByEmailAndProfileName(email, profileName);
    }

    public void removeFromList(String email, String profileName, String videoTitle) {
        preferencesRepository.deleteByEmailAndProfileNameAndVideoTitle(email, profileName, videoTitle);
    }
}
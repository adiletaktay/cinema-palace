package com.cinema_palace.service.implementation;

import com.cinema_palace.model.UserVideoList;
import com.cinema_palace.repository.PreferencesRepo;
import com.cinema_palace.service.PreferencesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public void removeFromList(String email, String profileName, String videoTitle) {
        preferencesRepository.deleteByEmailAndProfileNameAndVideoTitle(email, profileName, videoTitle);
    }

    public boolean checkInList(String email, String profileName, String videoTitle) {
        Optional<UserVideoList> inList = preferencesRepository.findByEmailAndProfileNameAndVideoTitle(email, profileName, videoTitle);
        return inList.isEmpty();
    }
}
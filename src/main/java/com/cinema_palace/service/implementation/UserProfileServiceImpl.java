package com.cinema_palace.service.implementation;

import com.cinema_palace.model.UserProfile;
import com.cinema_palace.repository.UserProfileRepo;
import com.cinema_palace.service.UserProfileService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepo userProfileRepository;

    public UserProfile addProfile(UserProfile newProfile) {
        return userProfileRepository.save(newProfile);
    }

    @Override
    public UserProfile updateProfile(UserProfile updateProfile, String email, String profileName) {
        Optional<UserProfile> existingProfile = userProfileRepository.findByEmailAndProfileName(email, profileName);
        UserProfile profile = existingProfile.get();
        profile.setProfileName(updateProfile.getProfileName());
        profile.setProfilePicture(updateProfile.getProfilePicture());
        profile.setLanguage(updateProfile.getLanguage());
        profile.setMaturity(updateProfile.getMaturity());
        profile.setGameHandle(updateProfile.getGameHandle());
        return userProfileRepository.save(profile);
    }

    @Transactional
    public void deleteProfile(String email, String profileName) {
        userProfileRepository.deleteByEmailAndProfileName(email, profileName);
    }

    public boolean validateProfileName(String email, String profileName) {
        Optional<UserProfile> existingProfile = userProfileRepository.findByEmailAndProfileName(email, profileName);
        return existingProfile.isEmpty();
    }

    public boolean validateGameHandle(String gameHandle) {
        Optional<UserProfile> existingProfile = userProfileRepository.findByGameHandle(gameHandle);
        return existingProfile.isEmpty();
    }

    public List<UserProfile> getAllProfiles(String email) {
        return userProfileRepository.findAllByEmail(email);
    }
}
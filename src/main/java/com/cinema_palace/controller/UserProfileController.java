package com.cinema_palace.controller;

import com.cinema_palace.model.UserProfile;
import com.cinema_palace.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("api/profile/add")
    public ResponseEntity<UserProfile> addProfile(@RequestBody UserProfile newProfile) {
        return new ResponseEntity<UserProfile>(userProfileService.addProfile(newProfile), HttpStatus.CREATED);
    }

    @PutMapping("api/profile/update/{email}/{profileName}")
    public ResponseEntity<UserProfile> updateProfile(@PathVariable("email") String email, @PathVariable("profileName") String profileName,
                                                     @RequestBody UserProfile existingProfile) {
        return new ResponseEntity<UserProfile>(userProfileService.updateProfile(existingProfile, email, profileName), HttpStatus.OK);
    }

    @DeleteMapping("api/profile/delete/{email}/{profileName}")
    public ResponseEntity<String> deleteProfile(@PathVariable("email") String email, @PathVariable("profileName") String profileName) {
        userProfileService.deleteProfile(email, profileName);
        return new ResponseEntity<String>("profile delete successful!", HttpStatus.OK);
    }

    @GetMapping("api/profile/validate/{email}/{profileName}")
    public ResponseEntity<Boolean> validateProfileName(@PathVariable("email") String email, @PathVariable("profileName") String profileName) {
        boolean validity = userProfileService.validateProfileName(email, profileName);
        return ResponseEntity.ok(validity);
    }

    @GetMapping("api/profile/validate/{gameHandle}")
    public ResponseEntity<Boolean> validateGameHandle(@PathVariable("gameHandle") String gameHandle) {
        boolean validity = userProfileService.validateGameHandle(gameHandle);
        return ResponseEntity.ok(validity);
    }

    @GetMapping("api/profiles/{email}")
    public List<UserProfile> getAllProfiles(@PathVariable("email") String email) {
        return userProfileService.getAllProfiles(email);
    }
}
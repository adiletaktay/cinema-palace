package com.cinema_palace.controller;


import com.cinema_palace.model.UserVideoList;
import com.cinema_palace.service.PreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserPreferencesController {

    @Autowired
    private PreferencesService preferencesService;

    @PostMapping("api/list/add")
    public ResponseEntity<UserVideoList> addToList(@RequestBody UserVideoList addVideo) {
        return new ResponseEntity<UserVideoList>(preferencesService.addToList(addVideo), HttpStatus.CREATED);
    }

    @GetMapping("api/list/{email}/{profileName}")
    public List<UserVideoList> getAllInList(@PathVariable("email") String email, @PathVariable("profileName") String profileName) {
        return preferencesService.getAllInList(email, profileName);
    }

    @DeleteMapping("api/list/delete/{email}/{profileName}/{videoTitle}")
    public ResponseEntity<String> deleteFromList(@PathVariable("email") String email, @PathVariable("profileName") String profileName, @PathVariable("videoTitle") String videoTitle) {
        preferencesService.removeFromList(email, profileName, videoTitle);
        return new ResponseEntity<String>("video removed from list!", HttpStatus.OK);
    }
}
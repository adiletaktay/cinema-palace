package com.cinema_palace.controller;

import com.cinema_palace.model.VideoMetaData;
import com.cinema_palace.service.VideoSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class VideoSuggestionController {

    @Autowired
    private VideoSuggestionService videoSuggestionService;

    @GetMapping("api/videoSuggestions/{suggestionCategory}")
    public List<VideoMetaData> getSuggestions(@PathVariable("suggestionCategory") String suggestionCategory) {
        return videoSuggestionService.getSuggestions(suggestionCategory);
    }
}
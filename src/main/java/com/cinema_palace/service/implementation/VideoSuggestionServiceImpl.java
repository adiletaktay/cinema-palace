package com.cinema_palace.service.implementation;

import com.cinema_palace.model.VideoMetaData;
import com.cinema_palace.repository.VideoSuggestionRepo;
import com.cinema_palace.service.VideoSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoSuggestionServiceImpl implements VideoSuggestionService {

    @Autowired
    private VideoSuggestionRepo videoSuggestionRepository;
    public List<VideoMetaData> getSuggestions(String suggestionCategory) {
        return videoSuggestionRepository.findBySuggestionCategory(suggestionCategory);
    }
}
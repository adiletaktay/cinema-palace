package com.cinema_palace.service;

import com.cinema_palace.model.VideoMetaData;

import java.util.List;

public interface VideoSuggestionService {
    List<VideoMetaData> getSuggestions(String suggestionCategory);
}
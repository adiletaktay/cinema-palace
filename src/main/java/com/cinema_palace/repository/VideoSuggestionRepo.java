package com.cinema_palace.repository;

import com.cinema_palace.model.VideoMetaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoSuggestionRepo extends JpaRepository<VideoMetaData, Long> {
    List<VideoMetaData> findBySuggestionCategory(String suggestionCategory);
}
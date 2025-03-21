package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dtos.TopicListDTO;
import com.openclassrooms.mddapi.services.TopicsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/topic")
public class TopicsController {
    private final TopicsService topicsService;

    public TopicsController(TopicsService topicsService) {
        this.topicsService = topicsService;
    }
    // with future back office - POST and PUT to create categories

    @GetMapping
    public ResponseEntity<TopicListDTO> getAllTopics() {
        TopicListDTO topics = topicsService.getAllTopics();
        return ResponseEntity.ok().body(topics);
    }
}

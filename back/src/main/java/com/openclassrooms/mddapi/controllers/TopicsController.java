package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dtos.TopicListDTO;
import com.openclassrooms.mddapi.services.TopicsService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/topic")
@CrossOrigin(origins = "http://localhost:4200")
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

    @PostMapping("/{id}/subscribe")
    public void subscribeToTopic(@PathVariable int id) {

    }
}

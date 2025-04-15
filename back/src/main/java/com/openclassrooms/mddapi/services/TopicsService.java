package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dtos.SubscriptionDTO;
import com.openclassrooms.mddapi.dtos.TopicDTO;
import com.openclassrooms.mddapi.dtos.TopicListDTO;
import com.openclassrooms.mddapi.entities.Subscription;
import com.openclassrooms.mddapi.entities.Topic;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.mappers.TopicMapper;
import com.openclassrooms.mddapi.repositories.SubscriptionRepository;
import com.openclassrooms.mddapi.repositories.TopicRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicsService {
    private final TopicRepository topicRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final UserService userService;
    private final TopicMapper topicMapper;

    public TopicsService(TopicRepository topicRepository, SubscriptionRepository subscriptionRepository, UserService userService, TopicMapper topicMapper) {
        this.topicRepository = topicRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.userService = userService;
        this.topicMapper = topicMapper;
    }

    public TopicListDTO getAllTopics() {
        List<Topic> topics = topicRepository.findAll();
        List<TopicDTO> topicsDTOs = new ArrayList<>();

        topics.forEach(topic -> topicsDTOs.add(topicMapper.convertToDTO(topic)));
        TopicListDTO list = new TopicListDTO();
        list.setTopics(topicsDTOs);

        return list;
    }

    public String subscribeToTopic(Long id) {
        // get username from JWTtoken
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User user = userService.getUserEntityByEmail(email);
        // get topic with ID
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found"));
        // mapper
        Subscription sub = topicMapper.convertToSubscriptionEntity(topic, user);
        subscriptionRepository.save(sub);
        return "Subscription saved";
    }
}

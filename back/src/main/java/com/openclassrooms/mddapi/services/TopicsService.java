package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dtos.TopicDTO;
import com.openclassrooms.mddapi.dtos.TopicListDTO;
import com.openclassrooms.mddapi.entities.Topic;
import com.openclassrooms.mddapi.mappers.TopicMapper;
import com.openclassrooms.mddapi.repositories.TopicRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicsService {
    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;

    public TopicsService(TopicRepository topicRepository, TopicMapper topicMapper) {
        this.topicRepository = topicRepository;
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
}

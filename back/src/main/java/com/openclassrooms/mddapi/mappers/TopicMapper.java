package com.openclassrooms.mddapi.mappers;

import com.openclassrooms.mddapi.dtos.TopicDTO;
import com.openclassrooms.mddapi.entities.Topic;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TopicMapper {
    private final ModelMapper modelMapper;

    public TopicMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TopicDTO convertToDTO(Topic topic) {
        TopicDTO dto = modelMapper.map(topic, TopicDTO.class);
        dto.setId(topic.getTopic_id());
        return dto;
    }
}

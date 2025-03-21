package com.openclassrooms.mddapi.dtos;

import java.util.List;

public class TopicListDTO {
    private List<TopicDTO> topics;

    public List<TopicDTO> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicDTO> topics) {
        this.topics = topics;
    }
}

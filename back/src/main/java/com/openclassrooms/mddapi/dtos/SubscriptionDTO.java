package com.openclassrooms.mddapi.dtos;

public class SubscriptionDTO {
    private Long topicId;
    private Long userId;

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

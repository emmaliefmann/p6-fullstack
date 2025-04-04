package com.openclassrooms.mddapi.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "topics")
public class Topic {
    //when saving use ID and NOT name (in case of future modification)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topic_id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Long getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Long topic_id) {
        this.topic_id = topic_id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    //Join table user_subscription

    // Join table with article topic
}

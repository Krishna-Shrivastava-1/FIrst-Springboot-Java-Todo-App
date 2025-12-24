package com.firstcrudspring.firstCrudStoreSpring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "todo")
public class Todo {
    @Id
    @JsonProperty("_id")
    private String id;
    private String title;
    private Boolean status;
// Mongo Db Constructor
    public Todo() {
    };

    // My Code Constructor
    public Todo(String title, Boolean status) {
        this.title = title;
        this.status = status;
    }
// Setters and Getters
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

}

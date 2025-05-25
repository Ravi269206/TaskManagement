package com.example.demo.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize (using = TaskSerializer.class)
public enum TaskStatus {
    NEW,
    PARTIALLY_COMPLETED,
    ON_HOLD,
    COMPLETED;

    public static TaskStatus fromString(String value) {
        return TaskStatus.valueOf(value.trim().replace(" ", "_").toUpperCase());
    }
}

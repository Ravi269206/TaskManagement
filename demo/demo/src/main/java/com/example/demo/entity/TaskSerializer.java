package com.example.demo.entity;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class TaskSerializer extends JsonDeserializer<TaskStatus> {


    @Override
    public TaskStatus deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
        String value = p.getText().toUpperCase();//as we had upper case in enum
        value = value.trim().replaceAll("[\\s-]+", "_");//replacing space with '_'
        try {
            return TaskStatus.valueOf(value);
        }
        catch (IllegalArgumentException e) {
            throw new IOException("Invalid status value: " + value);
        }
    }
}

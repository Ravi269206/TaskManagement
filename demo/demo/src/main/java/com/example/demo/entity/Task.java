package com.example.demo.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Task {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;
    private String title;
    private String description;
    private String status;
    private LocalDate dueDate;

    public Task() {
    }

    public Task(Long id, String title, String description, String status, LocalDate dueDate) {
        Id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}

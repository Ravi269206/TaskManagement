package com.example.demo.repository;

import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface TaskRepository extends JpaRepository<Task,Long> {

    Optional<Task> findByTitleIgnoreCase(String title);
}

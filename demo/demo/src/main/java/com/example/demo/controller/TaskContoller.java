package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskContoller {

    private TaskRepository taskRepository;

    @Autowired
    public TaskContoller(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getTasks(){
       return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id){
        return taskRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Task saveTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @PostMapping("/bulk")
    public List<Task> savetasks(@RequestBody List<Task> tasks){
        return taskRepository.saveAll(tasks);
    }



    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask){
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            task.setDueDate(updatedTask.getDueDate());
            return taskRepository.save(task);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
         taskRepository.deleteById(id);
    }



}

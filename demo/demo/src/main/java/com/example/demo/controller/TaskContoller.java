package com.example.demo.controller;

import com.example.demo.TaskService;
import com.example.demo.entity.Task;
import com.example.demo.entity.TaskSerializer;
import com.example.demo.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskContoller {

    private TaskService taskService;

    @Autowired
    public TaskContoller(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(){
       return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id){
        return taskService.getTask(id);
    }

    @PostMapping
    public Task saveTask(@Valid @RequestBody Task task){ //@Valid annotation checks validations on task entity
        System.out.println("Received Task: " + task);
        return taskService.saveOrUpdateTask(task);
    }

    @PostMapping("/bulk")
    public List<Task> savetasks(@Valid @RequestBody List<Task> tasks){//@Valid annotation checks validations on task entity
        return taskService.saveOrUpdateTasks(tasks);
    }



    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @Valid @RequestBody Task updatedTask){//@Valid annotation checks validations on task entity
        return taskService.updateTask(id,updatedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
         taskService.deleteTask(id);
    }



}

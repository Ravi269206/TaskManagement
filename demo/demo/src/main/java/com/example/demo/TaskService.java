package com.example.demo;

import com.example.demo.entity.Task;
import com.example.demo.entity.TaskStatus;
import com.example.demo.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService{

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Task saveOrUpdateTask(Task task){


        Optional<Task> existingTaskOpt = taskRepository.findByTitleIgnoreCase(task.getTitle());


        if(existingTaskOpt.isPresent()){
            Task existingTask = existingTaskOpt.get();
            System.out.println("existingTask "+existingTask);
            existingTask.setDescription(task.getDescription());
            existingTask.setDueDate(task.getDueDate());
            existingTask.setStatus(task.getStatus());
            System.out.println("existingTask after update "+existingTask);
            // ... update any other fields as needed
            return taskRepository.save(existingTask);
        } else {
            return taskRepository.save(task);
        }

    }

    public List<Task> saveOrUpdateTasks(List<Task> tasks) {
        return tasks.stream()
                .map(this::saveOrUpdateTask)
                .collect(Collectors.toList());
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public Task getTask(Long id){
        return taskRepository.findById(id).orElse(null);
    }


    public Task updateTask(Long id, Task updatedTask){//@Valid annotation checks validations on task entity
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            task.setDueDate(updatedTask.getDueDate());
            return taskRepository.save(task);
        }).orElse(null);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

}

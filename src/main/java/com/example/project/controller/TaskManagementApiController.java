package com.example.project.controller;
import com.example.project.dto.Task;
import com.example.project.dto.TaskCreateRequest;
import com.example.project.dto.TaskEditRequest;
import com.example.project.model.Tasks;
import com.example.project.service.TaskManagementService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class TaskManagementApiController implements TaskManagmentApi {

private final TaskManagementService service;

public TaskManagementApiController(TaskManagementService service){
    this.service = service;
}
    @Override
    public List<Task> getTaskList(){
      return service.getTaskList();
    }


    @Override
    public Optional<Tasks> getTask(@PathVariable Long id){
    return service.getTask(id);
    }

    @Override
    public Task postTaskList(@RequestBody TaskCreateRequest task){
        System.out.println("task received is"+ task);
    return service.createTask(task);
    }

    @Override
    public Task editTask(@RequestBody TaskEditRequest task, Long id){
    return service.editTask(task, id);
    }


}

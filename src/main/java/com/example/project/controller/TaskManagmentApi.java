package com.example.project.controller;
import com.example.project.dto.Task;
import com.example.project.dto.TaskCreateRequest;
import com.example.project.dto.TaskEditRequest;
import com.example.project.model.Tasks;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("/tasks")
public interface TaskManagmentApi {



  @GetMapping
   @ApiResponse(responseCode = "200", description = "OK")
 @ApiResponse(responseCode = "404", description = "Not found")
   List<Task> getTaskList();

  @GetMapping(value = "/{id}")
  @ApiResponse(responseCode = "501", description = "succed")
  @ApiResponse(responseCode = "404", description = "Not found")
  Optional<Tasks> getTask(@PathVariable Long id);


   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
  @ApiResponse(responseCode = "404", description = "validation error")
//   @PreAuthorize("@securityService.employeeOnly(T(com.example.project.security.TaskManagementPermissions).TASKS_EDIT)")
   Task postTaskList(@Valid @RequestBody TaskCreateRequest task);


   @PatchMapping(value = "/{id}")
    @ApiResponse(responseCode = "200", description = "OK")
   @ApiResponse(responseCode = "400", description = "Validation error")
    Task editTask(@Valid @RequestBody TaskEditRequest task, @PathVariable Long id);
}

package com.example.project.service;
import com.example.project.dto.Task;
import com.example.project.dto.TaskCreateRequest;
import com.example.project.dto.TaskEditRequest;
import com.example.project.exception.NotFoundException;
import com.example.project.mapper.PatchRequestMapper;
import com.example.project.mapper.TaskManagementMapper;
import com.example.project.model.Tasks;
import com.example.project.repository.TaskManagementRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TaskManagementService {
    private final TaskManagementRepository repository;
    private final TaskManagementMapper mapper;

    private final PatchRequestMapper patchRequestMapper;

    public TaskManagementService(TaskManagementRepository taskRepository, TaskManagementMapper mapper, PatchRequestMapper patchRequestMapper) {
        this.repository = taskRepository;
        this.mapper = mapper;
        this.patchRequestMapper = patchRequestMapper;
    }

    public List<Task> getTaskList() {

        List<Tasks> result = repository.findAll();

        return result.stream().map(mapper::convertTaskFromEntityToListDto).toList();
    }

    public Optional<Tasks> getTask(Long id) {
        Optional<Tasks> foundTask = repository.findById(id);
        if (foundTask.isPresent()) {
            return foundTask;
        }
        return foundTask;
    }

    public Task createTask(@Valid TaskCreateRequest task) {
        System.out.println("task is ->" + task);
        Tasks taskConvertedFromReqToEntity = mapper.convertTaskFromCreateRequestToEntity(task);
        System.out.println("task after conversion ->" + taskConvertedFromReqToEntity);
        Tasks val = repository.save(taskConvertedFromReqToEntity);
        return mapper.convertTaskFromEntityToListDto(val);
    }

    public Task editTask(@Valid TaskEditRequest editRequest, long id) {
        Optional<Tasks> foundTask = repository.findById(id);
        Tasks existingEntity =  foundTask.get();
        if (foundTask.isEmpty()) {
            throw new NotFoundException();
        }
        patchRequestMapper.update(editRequest, existingEntity);
        repository.saveAndFlush(existingEntity);
        return mapper.convertTaskFromEntityToDtO(existingEntity);
    }
}

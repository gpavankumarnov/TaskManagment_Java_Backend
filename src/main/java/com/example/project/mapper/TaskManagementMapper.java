package com.example.project.mapper;
import com.example.project.dto.Task;
import com.example.project.dto.TaskCreateRequest;
import com.example.project.dto.TaskEditRequest;
import com.example.project.model.Tasks;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public abstract class TaskManagementMapper {



    public abstract Tasks convertTaskFromCreateRequestToEntity(TaskCreateRequest task);



    public abstract Task convertTaskFromEntityToListDto(Tasks task);


    public abstract Task convertTaskFromEntityToDtO(Tasks task);


}

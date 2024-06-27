package com.example.project.mapper;
import com.example.project.dto.TaskEditRequest;
import com.example.project.model.Tasks;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PatchRequestMapper {


   Tasks update(TaskEditRequest editRequest, @MappingTarget Tasks destination);



}

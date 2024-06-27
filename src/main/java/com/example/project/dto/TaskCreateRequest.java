package com.example.project.dto;
import com.example.project.enums.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreateRequest {

   // private Long id;

    @NotNull
    private String taskName;


    @Enumerated(EnumType.STRING)
     @NotNull
    private TaskStatus taskStatus;


}

package com.example.project.dto;
import com.example.project.enums.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private Long id;
    @NotNull
    private String taskName;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
}


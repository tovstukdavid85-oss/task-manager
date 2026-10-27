package com.example.taskmanager.dto;

import com.example.taskmanager.model.Tasckstatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {
    @NotBlank(message = "Название задачи обязательно")
    @Size(max = 200, message = "Название не должно превышать 200 символов")
    private String title;

    @Size(max = 2000, message = "Описание не должно превышать 2000 символов")
    private String description;

    private Long categoryId;
    private Long userId;
    private Integer priority;
    private Tasckstatus status;
    private LocalDateTime dueDate;
}
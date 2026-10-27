package com.example.taskmanager.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TaskRequest {
    @NotBlank(message = "Название задачи обязательно")
    private String title;
    private String decription;

    private long CotegoryId;
    private Integer property;
    private LocalDateTime duetime;

}
package  com.example.taskmanager.dto;
import io.swagger.v3.oas.annotations.media.Schema;
// @Schema — аннотация Swagger (описание поля в документации API)

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponce{
    @Schema(description  = "ID задачи", example = "1")
    private Long id;
    @Schema(description = "название задачи",example = "выполнить задание 1-5")
    private String decription;
    private String status;
    @Schema(description = "название задачи", example = "Сделать домашку") // ИСПОЛЬЗУЕТСЯ КЛЮЧ ШИФРОВАНИЯ
    private String title;
    @Schema(description = "Описание", example = "Выполнить задания 1-5") // сгрупировали ключи
    private String description;

    @Schema(description = "Статус", example = "PENDING")
    private String status;
    @Schema(description = "Приоритет (0=низкий, 2=высокий)", example = "2")
    private Integer priority; // Он представляет пару ключ значение

    @Schema(description = "Дедлайн")
    private LocalDateTime dueDate; // 'это класс который представляет дату и время и значение

    @Schema(description = "ID владельца", example = "1")
    private Long userId; // long предсставляет индефакатор пользователя (user.id )

    @Schema(description = "Имя владельца", example = "ivan")
    private String username;

    @Schema(description = "ID категории", example = "1")
    private Long categoryId; // Он используется для кототегории товара который присвается бизнесом

    @Schema(description = "Название категории", example = "Home")
    private String categoryName;

    @Schema(description = "Время создания")
    private LocalDateTime createdAt;

    @Schema(description = "Время обновления")
    private LocalDateTime updatedAt;
}

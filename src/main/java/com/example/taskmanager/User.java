package com.example.taskmanager.model;

import jakarta.persistence.*;   // Все аннотации для работы с БД
import lombok.*;                // Генератор кода (getters/setters/конструкторы)
import org.springframework.scheduling.config.Task;

import java.time.LocalDateTime; // Тип данных для даты и времени
import java.util.List;

// @Entity = "Этот класс — таблица в базе данных"
// Без неё Hibernate незнает про этот класс
@Entity

// @Table(name = "users") — как называется таблица
// Если не указать — Hibernate назовёт "User" (с большой буквы)
@Table(name = "users")

// Lombok аннотации:
@Data           // Генерирует: getUsername(), setUsername(), toString(), equals(), hashCode()
@Builder        // Генерирует: User.builder().username("Bob").email("bob@mail.ru").build()
@NoArgsConstructor  // Генерирует: new User() (без аргументов) — нужен для Hibernate
@AllArgsConstructor // Генерирует: new User(id, username, email, ...) (со всеми полями)
public class User {

    // ==========================================
    // ПОЛЯ = СТОЛБЦЫ В ТАБЛИЦЕ
    // ==========================================

    @Id
    // @Id = PRIMARY KEY (уникальный идентификатор)
    // Без неё Hibernate не знает какой столбец — главный

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Генерация ID автоматически (1, 2, 3, 4...)
    // IDENTITY = PostgreSQL стиль (AUTO_INCREMENT)
    private Long id;
    // Java-тип: Long (большое целое число)
    // SQL-тип: BIGINT (автоматически Hibernate)

    // ==========================================

    @Column(nullable = false, unique = true, length = 100)
    // @Column = "настройки столбца"
    // nullable = false = "НЕЛЬЗЯ пустое" (NOT NULL)
    // unique = true = "НЕЛЬЗЯ повторяющееся" (UNIQUE)
    // length = 100 = "максимум 100 символов" (VARCHAR(100))
    private String username;

    @Column(nullable = false, unique = true)
    // nullable = false + unique = true → два пользователя с одной почтой = ошибка
    private String email;
    // SQL: email VARCHAR(255) NOT NULL UNIQUE



    @Column(name = "created_at", nullable = false)
    // name = "created_at" — имя столбца в БД (в Java поле называется createdAt)
    private LocalDateTime createdAt;
    // SQL: created_at TIMESTAMP NOT NULL



    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


    @OneToMany(mappedBy = "user")
    // "Один пользователь → много задач"
    // mappedBy = "user" — поле "user" в классе Task ссылается на этот класс
    // Это НЕ столбец в таблице users! Это "виртуальная" связь
    private List<Task> tasks;

    // ==========================================
    // ХУКИ — автоматический код
    // ==========================================

    @PrePersist
        // Вызывается Hibernate ПЕРЕД сохранением в БД (INSERT)
    void prePersist() {
        createdAt = LocalDateTime.now();  // Записываем текущее время
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
        // Вызывается Hibernate ПЕРЕД обновлением (UPDATE)
    void preUpdate() {
        updatedAt = LocalDateTime.now();  // Обновляем время изменения
    }
}
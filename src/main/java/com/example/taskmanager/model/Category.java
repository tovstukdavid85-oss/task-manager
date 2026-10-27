package com.example.taskmanager.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categories")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    private String description;

    @Column(length = 7)
    private String color;


    @Column(name = "created_at", nullable = false)
    protected LocalDateTime createdAt;

;;
    @PrePersist
    void prePersist() {
        createdAt = LocalDateTime.now();
    }
}

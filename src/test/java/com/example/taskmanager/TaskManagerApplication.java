package com.example.taskmanager;
// Пакет = папка в src/main/java

import org.springframework.boot.SpringApplication;
// Spring Boot — инструмент для запуска веб-приложений

import org.springframework.boot.autoconfigure.SpringBootApplication;
// Главная аннотация: "Сканируй все пакеты и подключи всё автоматически"

@SpringBootApplication   // = @Configuration + @EnableAutoConfiguration + @ComponentScan
// 1. @Configuration — "Это конфигурационный класс"
// 2. @EnableAutoConfiguration — "Подключи всё что найдёшь автоматически"
// 3. @ComponentScan — "Просканируй все пакеты и создай бины"

public class TaskManagerApplication {

    // main() — точка входа (как в любом Java-приложении)
    public static void main(String[] args) {
        // SpringApplication.run() — запускает встроенный сервер (Tomcat)
        // и подключает Spring контекст
        SpringApplication.run(TaskManagerApplication.class, args);
        // После этой строки приложение работает на http://localhost:8080
    }
}

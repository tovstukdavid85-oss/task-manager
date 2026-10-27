package com.example.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication — "магическая" аннотация.
// Она включает:
//   1. @Configuration — загрузить все настройки
//   2. @EnableAutoConfiguration — настроить Spring Boot автоматически
//   3. @ComponentScan — найти все компоненты в этом пакете и ниже
@SpringBootApplication
public class TaskManagerApplication {

    // main() — отсюда Java начинает выполнение
    public static void main(String[] args) {
        // SpringApplication.run — запускает Spring Boot:
        //   1. Читает application.yml
        //   2. Подключается к PostgreSQL
        //   3. Запускает встроенный Tomcat на порту 8080
        //   4. Сканирует все @RestController, @Service, @Repository
        SpringApplication.run(TaskManagerApplication.class, args);
    }
}
package com.example.taskmanager.model;

// enum = "перечисление" — список ИЗВЕСТНЫХ значений
// Задача не может иметь статус "blabla" — только эти 4 варианта
public enum Tasckstatus {
    PENDING,        // Ожидает (начальный статус при создании)
    IN_PROGRESS,    // В работе (кто-то взялся делать)
    COMPLETED,      // Выполнена (задача сделана)
    CANCELLED       // Отменена (задача больше не актуальна)
}
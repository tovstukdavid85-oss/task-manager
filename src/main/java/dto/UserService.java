package com.example.taskmanager.service;

import com.example.taskmanager.model.Category;
import com.example.taskmanager.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public Category createCategory(String name, String description, String color) {
        if (categoryRepository.existsByName(name)) {
            throw new RuntimeException("Категория уже существует: " + name);
        }

        Category category = Category.builder()
                .name(name)
                .description(description)
                .color(color != null ? color : "#000000")
                .build();

        Category saved = categoryRepository.save(category);
        log.info("Category created | id={} | name={}", saved.getId(), saved.getName());
        return saved;
    }

    @Transactional(readOnly = true)
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found: " + id));
    }

    @Transactional
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found: " + id));
        categoryRepository.delete(category);
    }
}





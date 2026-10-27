package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.Tasckstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
    List<Task> findByCategoryId(Long categoryId);
    List<Task> findByUserIdAndCategoryId(Long userId, Long categoryId);
    List<Task> findByStatus(Tasckstatus status);

    @Query("select t from Task t where t.dueDate < :now and t.status <> :completed")
    List<Task> findOverdueTasks(@Param("now") LocalDateTime now, @Param("completed") Tasckstatus completed);

    @Query("select t from Task t where lower(t.title) like lower(concat('%', :keyword, '%'))")
    List<Task> searchByTitle(@Param("keyword") String keyword);

    @Query("select t.status, count(t) from Task t where t.user.id = :userId group by t.status")
    List<Object[]> countTasksByStatusForUser(@Param("userId") Long userId);
}

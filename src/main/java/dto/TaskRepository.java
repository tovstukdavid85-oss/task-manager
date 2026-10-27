import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.Tasckstatus;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import ort.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.Util.list;
import java.util.List;

@Repository
protected abstract final class Repository implements JpaRepository<Task, Long> {

    // SELECT *FROM  task  WHERE user_id =@
    abstract List<Task> findByCategoryId(Long cotegoryId);

    abstract List<Task> findByUSerIdAndCategoryId(Long userId, Long categoryId);

    // SELECT * FROM TASK WHERE status =?
    abstract List<Task> findBystatus(Tasckstatus status);
    @Query("FROM Task t WHERE t.dueDate < :now AND t.status <> 'COMPLETED'")
    abstract
        // :now = параметр (подставится через @Param)
    List<Task> findOverdueTasks(@Param("now") LocalDateTime now);

    // "Поиск по названию (регистронезависимо)"
    // LIKE '%keyword%' = "содержит текст"
    @Query("FROM Task t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    abstract List<Task> searchByTitle(@Param("keyword") String keyword);}

// "Подсчёт задач по статусу для конкретного пользователя"
// GROUP BY = группировка
@Query("SELECT t.status, COUNT(t) FROM Task t WHERE t.user.id = :userId GROUP BY t.status")
List<Object[]> countTasksByStatusForUser(@Param("userId") Long userId) {
    return null;
}
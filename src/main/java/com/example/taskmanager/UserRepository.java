package  com.example.taskmanager;

import com.example.taskmanager.model.User;
// jpaRepository = "Библиотечный" репозиторий с готовыми методами

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// помечает этот интерфейс как компонент для работы с бд"

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}

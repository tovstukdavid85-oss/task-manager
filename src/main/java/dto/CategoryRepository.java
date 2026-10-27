package dto;
import com.example.taskmanager.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public abstract class CategoryRepository extends jpaRepository <Category, Long>{
    // SELECT FROM categoruies WHERE name = ?
    public abstract Optional<Category> findByName(String name);

    // SELECT COUNT(*) > FROM Categories WHERE  NAME  = ?

    //
}



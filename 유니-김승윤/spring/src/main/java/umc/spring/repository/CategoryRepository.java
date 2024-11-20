package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Category;
import umc.spring.domain.Region;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}

package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.FoodType;

public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {
}

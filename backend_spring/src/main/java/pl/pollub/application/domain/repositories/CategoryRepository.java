package pl.pollub.application.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub.application.domain.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}

package pl.pollub.application.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub.application.domain.entities.StatusEntity;

public interface StatusRepository extends JpaRepository<StatusEntity, Long> {

}

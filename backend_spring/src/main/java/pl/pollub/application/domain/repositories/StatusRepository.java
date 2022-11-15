package pl.pollub.inzynierka.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub.inzynierka.domain.entities.StatusEntity;

public interface StatusRepository extends JpaRepository<StatusEntity, Long> {

}

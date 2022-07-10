package pl.pollub.inzynierka.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub.inzynierka.domain.entities.OfferEntity;

public interface OfferRepository extends JpaRepository<OfferEntity, Integer> {

}

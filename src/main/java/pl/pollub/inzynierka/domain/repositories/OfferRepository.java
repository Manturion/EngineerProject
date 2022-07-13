package pl.pollub.inzynierka.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pollub.inzynierka.domain.entities.OfferEntity;
import pl.pollub.inzynierka.infrastructure.OfferDto;

import java.util.List;

public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

    @Query("select new pl.pollub.inzynierka.infrastructure.OfferDto(o.title,o.description,o.image,o.oldPrice,o.newPrize,o.gps,o.startDate,o.expireDate,o.isAvailable,o.categoryByCategoryId.id, o.id) from OfferEntity o ")
    List<OfferDto> getAllOffers();

    @Query("select new pl.pollub.inzynierka.infrastructure.OfferDto(o.title,o.description,o.image,o.oldPrice,o.newPrize,o.gps,o.startDate,o.expireDate,o.isAvailable, o.categoryByCategoryId.id, o.id) from OfferEntity o where o.id = :id")
    OfferDto getOfferById(int id);


}

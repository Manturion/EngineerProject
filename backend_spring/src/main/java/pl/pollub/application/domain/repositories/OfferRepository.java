package pl.pollub.application.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pollub.application.domain.entities.OfferEntity;
import pl.pollub.application.infrastructure.Offer.OfferDto;

import java.util.List;

public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

    @Query("select new pl.pollub.application.infrastructure.Offer.OfferDto(o.title,o.description,o.image,o.oldPrice,o.newPrice,o.latitude,o.longitude,o.startDate,o.expireDate,o.isAvailable,o.categoryByCategoryId.id, o.id) from OfferEntity o ")
    List<OfferDto> getAllOffers();

    @Query("select new pl.pollub.application.infrastructure.Offer.OfferDto(o.title,o.description,o.image,o.oldPrice,o.newPrice,o.latitude,o.longitude,o.startDate,o.expireDate,o.isAvailable, o.categoryByCategoryId.id, o.id) from OfferEntity o where o.id = :id")
    OfferDto getOfferById(Long id);

}

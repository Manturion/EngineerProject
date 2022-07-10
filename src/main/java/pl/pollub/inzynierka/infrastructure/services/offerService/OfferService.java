package pl.pollub.inzynierka.infrastructure.services.offerService;

import pl.pollub.inzynierka.domain.entities.OfferEntity;

import java.util.List;

public interface OfferService {
    List<OfferEntity> getAllOffers();

    OfferEntity getOfferById(int id);
}

package pl.pollub.inzynierka.infrastructure;

import pl.pollub.inzynierka.domain.entities.OfferEntity;

import java.util.List;

public interface OfferPort {

    List<OfferDto> getAllOffers();

    OfferDto getOfferById(int id);
}

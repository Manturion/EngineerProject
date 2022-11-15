package pl.pollub.application.infrastructure.Offer;

import java.util.List;
import java.util.Optional;

public interface OfferPort {

    List<OfferDto> getAllOffers();

    Optional<OfferDto> getOfferById(Long id);

    Long createOffer(CreateOfferDto offerDto);

    Long deleteOffer(Long id);

    List<OfferDto> getAllOffersBelongingToUser(Long id);

    Optional<Long> editOffer(Long id, CreateOfferDto createOfferDto);
}

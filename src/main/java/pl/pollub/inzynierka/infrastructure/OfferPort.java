package pl.pollub.inzynierka.infrastructure;

import java.util.List;

public interface OfferPort {

    List<OfferDto> getAllOffers();

    OfferDto getOfferById(int id);

    Long createOffer(CreateOfferDto offerDto);
}

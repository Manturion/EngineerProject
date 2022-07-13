package pl.pollub.inzynierka.domain.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pollub.inzynierka.domain.entities.OfferEntity;
import pl.pollub.inzynierka.domain.repositories.OfferRepository;
import pl.pollub.inzynierka.infrastructure.OfferDto;
import pl.pollub.inzynierka.infrastructure.OfferPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OfferAdapter implements OfferPort {

    private final OfferRepository offerRepository;

    @Override
    public List<OfferDto> getAllOffers() {
        if (offerRepository.getAllOffers() == null) {
            return null;
        }
        return offerRepository.getAllOffers();
    }

    @Override
    public OfferDto getOfferById(int id) {
        OfferDto offer = offerRepository.getOfferById(id);
        if (offer == null) {
            return null;
        } else if (offer.getId() != id) {
            return null;
        }
        return offerRepository.getOfferById(id);
    }
}

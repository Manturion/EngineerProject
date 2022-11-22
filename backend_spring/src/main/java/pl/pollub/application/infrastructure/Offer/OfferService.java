package pl.pollub.application.infrastructure.Offer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class OfferService {

    private final OfferPort offerPort;

    public Optional<OfferDto> getOfferById(Long id) {
        return offerPort.getOfferById(id);
    }
    public List<OfferDto> getAllOffers() {
        return offerPort.getAllOffers();
    }

    public List<OfferDto> getAllOffersBelongingToUser(Long id) {
        return offerPort.getAllOffersBelongingToUser(id);
    }

    public Long createOffer(CreateOfferDto createOfferDto) {
        return offerPort.createOffer(createOfferDto);
    }

    public Long deleteOffer(Long id) {
        return offerPort.deleteOffer(id);
    }

    public Optional<Long> editOffer(CreateOfferDto createOfferDto, Long id){
        return offerPort.editOffer(id, createOfferDto);
    }
}

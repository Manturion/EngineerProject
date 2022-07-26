package pl.pollub.inzynierka.infrastructure.Offer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class OfferService {

    private final OfferPort offerPort;

    public OfferDto getOfferById(int id) {
        return offerPort.getOfferById(id);
    }

    public List<OfferDto> getAllOffers() {
        return offerPort.getAllOffers();
    }

    public Long createOffer(CreateOfferDto createOfferDto) {
        return offerPort.createOffer(createOfferDto);
    }

    public Long deleteOffer(Long id) {
        return offerPort.deleteOffer(id);
    }

}

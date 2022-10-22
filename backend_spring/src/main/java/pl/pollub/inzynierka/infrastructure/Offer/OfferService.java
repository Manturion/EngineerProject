package pl.pollub.inzynierka.infrastructure.Offer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Optional<Long> editOffer(OfferDto offerDto, Long id){
        return offerPort.editOffer(id, offerDto);
    }

}

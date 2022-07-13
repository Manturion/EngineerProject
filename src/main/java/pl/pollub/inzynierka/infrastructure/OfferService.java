package pl.pollub.inzynierka.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pollub.inzynierka.domain.entities.OfferEntity;

import java.util.List;

@Service
@RequiredArgsConstructor

public class OfferService{

    private final OfferPort offerPort;

    public OfferDto getOfferById(int id){
        return offerPort.getOfferById(id);
    }

//    public OfferEntity getOfferById(int id){
//        OfferEntity offerEntity = offerPort.getOfferById(id);
//        OfferDto offerDto = new OfferDto(offerEntity.getTitle(),offerEntity.getDescription(),)
//    }
    public List<OfferDto> getAllOffers(){
        return offerPort.getAllOffers();
    }
}

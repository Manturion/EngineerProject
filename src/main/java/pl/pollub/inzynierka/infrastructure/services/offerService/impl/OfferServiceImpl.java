package pl.pollub.inzynierka.infrastructure.services.offerService.impl;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import pl.pollub.inzynierka.domain.entities.OfferEntity;
import pl.pollub.inzynierka.domain.repositories.OfferRepository;
import pl.pollub.inzynierka.infrastructure.services.offerService.OfferService;

import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        super();
        this.offerRepository = offerRepository;
    }
    @Override
    public List<OfferEntity> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public OfferEntity getOfferById(int id) {
        Optional<OfferEntity> result = offerRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        } else {
            System.out.println("nie ma oferty o tym id");
        }
        return null;
    }
}

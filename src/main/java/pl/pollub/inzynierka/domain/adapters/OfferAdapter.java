package pl.pollub.inzynierka.domain.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pollub.inzynierka.domain.entities.OfferEntity;
import pl.pollub.inzynierka.domain.mappers.OfferMapper;
import pl.pollub.inzynierka.domain.repositories.CategoryRepository;
import pl.pollub.inzynierka.domain.repositories.CustomerRepository;
import pl.pollub.inzynierka.domain.repositories.OfferRepository;
import pl.pollub.inzynierka.domain.repositories.StatusRepository;
import pl.pollub.inzynierka.infrastructure.CreateOfferDto;
import pl.pollub.inzynierka.infrastructure.OfferDto;
import pl.pollub.inzynierka.infrastructure.OfferPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OfferAdapter implements OfferPort {

    private final OfferRepository offerRepository;
    private final CustomerRepository customerRepository;
    private final StatusRepository statusRepository;
    private final CategoryRepository categoryRepository;
    private final OfferMapper offerMapper;

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

    @Override
    public Long createOffer(CreateOfferDto offerDto) {
        OfferEntity offerEntity = mapToEntity(offerDto);
        customerRepository.findById(1L)
                .ifPresent(offerEntity::setCreatedBy);
        statusRepository.findById(1L)
                .ifPresent(offerEntity::setStatusByStatusId);
        categoryRepository.findById(offerDto.getCategoryId())
                .ifPresent(offerEntity::setCategoryByCategoryId);
        OfferEntity savedEntity = offerRepository.save(offerEntity);
        return savedEntity.getId();
    }

    private OfferEntity mapToEntity(CreateOfferDto offerDto) {
        return offerMapper.mapToEntity(offerDto);
    }
}

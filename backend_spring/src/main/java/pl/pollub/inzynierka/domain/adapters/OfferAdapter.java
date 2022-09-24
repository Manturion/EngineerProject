package pl.pollub.inzynierka.domain.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pollub.inzynierka.domain.entities.OfferEntity;
import pl.pollub.inzynierka.domain.mappers.OfferMapper;
import pl.pollub.inzynierka.domain.repositories.CategoryRepository;
import pl.pollub.inzynierka.domain.repositories.CustomerRepository;
import pl.pollub.inzynierka.domain.repositories.OfferRepository;
import pl.pollub.inzynierka.domain.repositories.StatusRepository;
import pl.pollub.inzynierka.infrastructure.Offer.CreateOfferDto;
import pl.pollub.inzynierka.infrastructure.Offer.OfferDto;
import pl.pollub.inzynierka.infrastructure.Offer.OfferPort;

import java.util.List;
import java.util.Optional;

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
        return offerRepository.getAllOffers();
    }

    @Override
    public Optional<OfferDto> getOfferById(Long id) {

        return Optional.<OfferDto>ofNullable(offerRepository.getOfferById(id));
    }

    @Override
    public Long createOffer(CreateOfferDto offerDto) {
        OfferEntity offerEntity = mapToEntity(offerDto);

        customerRepository.findById(offerEntity.getCreatedBy().getId())
                .ifPresent(offerEntity::setCreatedBy);
        statusRepository.findById(offerEntity.getStatusByStatusId().getId())
                .ifPresent(offerEntity::setStatusByStatusId);
        categoryRepository.findById(offerEntity.getCategoryByCategoryId().getId())
                .ifPresent(offerEntity::setCategoryByCategoryId);

        OfferEntity savedEntity = offerRepository.save(offerEntity);
        return savedEntity.getId();
    }

    @Override
    public Long deleteOffer(Long id) {
        offerRepository.deleteById(id);
        return id;
    }

    @Override
    public List<OfferDto> getAllOffersBelongingToUser(Long id) {
        offerRepository.getAllOffers();
        /*TODO  fetch offers belonging to user */
        return null;
    }

    private OfferEntity mapToEntity(CreateOfferDto offerDto) {
        return offerMapper.mapToEntity(offerDto);
    }
}

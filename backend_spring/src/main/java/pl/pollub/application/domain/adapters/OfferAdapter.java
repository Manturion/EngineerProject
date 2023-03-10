package pl.pollub.application.domain.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pollub.application.domain.entities.OfferEntity;
import pl.pollub.application.domain.mappers.OfferMapper;
import pl.pollub.application.domain.repositories.CategoryRepository;
import pl.pollub.application.domain.repositories.CustomerRepository;
import pl.pollub.application.domain.repositories.OfferRepository;
import pl.pollub.application.domain.repositories.StatusRepository;
import pl.pollub.application.infrastructure.Offer.CreateOfferDto;
import pl.pollub.application.infrastructure.Offer.OfferDto;
import pl.pollub.application.infrastructure.Offer.OfferPort;

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
    public Long createOffer(CreateOfferDto createOfferDto) {
        OfferEntity offerEntity = mapToEntity(createOfferDto);

        customerRepository.findById(1L)
                .ifPresent(offerEntity::setCreatedBy);
        statusRepository.findById(1L)
                .ifPresent(offerEntity::setStatusByStatusId);
        categoryRepository.findById(1L)
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

    @Override
    public Optional<Long> editOffer(Long id, CreateOfferDto createOfferDto) {

        return offerRepository.findById(id).map(offer -> {
            offer.setTitle(createOfferDto.getTitle());
            offer.setDescription(createOfferDto.getDescription());
            offer.setImage(createOfferDto.getImage());
            offer.setOldPrice(createOfferDto.getOldPrice());
            offer.setNewPrice(createOfferDto.getNewPrice());
            offer.setLatitude(createOfferDto.getLatitude());
            offer.setLongitude(createOfferDto.getLongitude());
            offer.setStartDate( createOfferDto.getStartDate());
            offer.setExpireDate(createOfferDto.getExpireDate());
            offerRepository.save(offer);
            return offer.getId();
        });
    }

    private OfferEntity mapToEntity(CreateOfferDto offerDto) {
        return offerMapper.mapToEntity(offerDto);
    }

    private OfferEntity mapToEntity(OfferDto offerDto) {
        return offerMapper.mapToEntity(offerDto);
    }
}

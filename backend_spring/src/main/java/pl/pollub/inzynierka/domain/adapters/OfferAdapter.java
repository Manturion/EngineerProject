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

import java.sql.Timestamp;
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
    public Optional<Long> editOffer(Long id, OfferDto offerDto) {

        return offerRepository.findById(id).map(offer -> {
            offer.setTitle(offerDto.getTitle());
            offer.setDescription(offerDto.getDescription());
            offer.setImage(offerDto.getImage());
            offer.setOldPrice(offerDto.getOldPrice());
            offer.setNewPrice(offerDto.getNewPrice());
            offer.setGps(offerDto.getGps());
            offer.setStartDate((Timestamp) offerDto.getStartDate());
            offer.setExpireDate((Timestamp) offerDto.getExpireDate());
            offerRepository.save(offer);
            return offer.getId();
        });

//        OfferEntity offerEntity = mapToEntity(offerDto);
//
//        customerRepository.findById(1L)
//                .ifPresent(offerEntity::setCreatedBy);
//        statusRepository.findById(1L)
//                .ifPresent(offerEntity::setStatusByStatusId);
//        categoryRepository.findById(1L)
//                .ifPresent(offerEntity::setCategoryByCategoryId);
//        OfferEntity savedEntity = offerRepository.getById(id);
//        savedEntity = offerRepository.save(offerEntity);
//        return savedEntity.getId();
    }

    private OfferEntity mapToEntity(CreateOfferDto offerDto) {
        return offerMapper.mapToEntity(offerDto);
    }

    private OfferEntity mapToEntity(OfferDto offerDto) {
        return offerMapper.mapToEntity(offerDto);
    }
}

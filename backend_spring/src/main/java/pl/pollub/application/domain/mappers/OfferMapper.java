package pl.pollub.application.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.pollub.application.domain.entities.OfferEntity;
import pl.pollub.application.infrastructure.Offer.CreateOfferDto;
import pl.pollub.application.infrastructure.Offer.OfferDto;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    @Mapping(target = "id", ignore = true)
    OfferEntity mapToEntity(CreateOfferDto createOfferDto);

    OfferEntity mapToEntity(OfferDto offerDto);

}

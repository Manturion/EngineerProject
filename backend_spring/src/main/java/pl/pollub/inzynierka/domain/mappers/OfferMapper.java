package pl.pollub.inzynierka.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.pollub.inzynierka.domain.entities.OfferEntity;
import pl.pollub.inzynierka.infrastructure.Offer.CreateOfferDto;
import pl.pollub.inzynierka.infrastructure.Offer.OfferDto;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    @Mapping(target = "id", ignore = true)
    OfferEntity mapToEntity(CreateOfferDto createOfferDto);

    OfferEntity mapToEntity(OfferDto offerDto);

}

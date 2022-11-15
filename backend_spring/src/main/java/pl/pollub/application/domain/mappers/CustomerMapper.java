package pl.pollub.application.domain.mappers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    //@Mapping(target = "id", ignore = true)
    //ustomerEntity mapToEntity(CreateCustomerDto createCustomerDto);

    //CustomerEntity mapToEntity(CustomerDto customerDto);
}

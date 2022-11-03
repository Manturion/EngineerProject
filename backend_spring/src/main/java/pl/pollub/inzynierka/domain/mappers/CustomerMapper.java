package pl.pollub.inzynierka.domain.mappers;

import org.mapstruct.Mapper;
import pl.pollub.inzynierka.domain.entities.CustomerEntity;
import pl.pollub.inzynierka.infrastructure.Customer.CreateCustomerDto;
import pl.pollub.inzynierka.infrastructure.Customer.CustomerDto;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    //@Mapping(target = "id", ignore = true)
    //ustomerEntity mapToEntity(CreateCustomerDto createCustomerDto);

    //CustomerEntity mapToEntity(CustomerDto customerDto);
}

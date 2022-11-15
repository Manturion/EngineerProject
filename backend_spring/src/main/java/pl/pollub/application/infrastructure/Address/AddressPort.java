package pl.pollub.application.infrastructure.Address;

import java.util.List;

public interface AddressPort {

    List<AddressDto> getAllAddresses();

    AddressDto getAddressById(Long id);
}

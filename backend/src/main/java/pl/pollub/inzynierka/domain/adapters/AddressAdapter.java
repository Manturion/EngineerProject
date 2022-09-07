package pl.pollub.inzynierka.domain.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pollub.inzynierka.domain.repositories.AddressRepository;
import pl.pollub.inzynierka.infrastructure.Address.AddressDto;
import pl.pollub.inzynierka.infrastructure.Address.AddressPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AddressAdapter implements AddressPort {

    private final AddressRepository addressRepository;

    @Override
    public List<AddressDto> getAllAddresses() {
        return addressRepository.getAllAddresses();
    }

    @Override
    public AddressDto getAddressById(Long id) {
        return addressRepository.getAddressById(id);
    }
}

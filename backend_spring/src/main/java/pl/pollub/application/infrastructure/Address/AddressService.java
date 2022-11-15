package pl.pollub.application.infrastructure.Address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressPort addressPort;

    public AddressDto getAddressById(Long id) {
        return addressPort.getAddressById(id);
    }

    public List<AddressDto> getAllAddresses() {
        return addressPort.getAllAddresses();
    }
}

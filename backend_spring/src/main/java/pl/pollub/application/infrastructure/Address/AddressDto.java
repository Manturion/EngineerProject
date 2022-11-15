package pl.pollub.application.infrastructure.Address;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressDto extends AddressDtoTemplate{
    private Long id;

    public AddressDto(String streetName, String streetNumber, String flatNumber, String zipCode, Long cityId, Long id) {
        super(streetName, streetNumber, flatNumber, zipCode, cityId);
        this.id = id;
    }
}

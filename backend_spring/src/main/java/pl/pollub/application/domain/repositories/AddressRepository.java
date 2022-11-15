package pl.pollub.application.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pollub.application.domain.entities.AddressEntity;
import pl.pollub.application.infrastructure.Address.AddressDto;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query("select new pl.pollub.application.infrastructure.Address.AddressDto(a.streetName, a.streetNumber, a.flatNumber, a.zipCode, a.cityByCityId.id, a.id) from AddressEntity a ")
    List<AddressDto> getAllAddresses();

    @Query("select new pl.pollub.application.infrastructure.Address.AddressDto(a.streetName, a.streetNumber, a.flatNumber, a.zipCode, a.cityByCityId.id, a.id) from AddressEntity a where a.id = :id")
    AddressDto getAddressById(Long id);
}
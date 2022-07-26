package pl.pollub.inzynierka.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pollub.inzynierka.domain.entities.AddressEntity;
import pl.pollub.inzynierka.infrastructure.Address.AddressDto;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query("select new pl.pollub.inzynierka.infrastructure.Address.AddressDto(a.streetName, a.streetNumber, a.flatNumber, a.zipCode, a.cityByCityId.id, a.id) from AddressEntity a ")
    List<AddressDto> getAllAddresses();

    @Query("select new pl.pollub.inzynierka.infrastructure.Address.AddressDto(a.streetName, a.streetNumber, a.flatNumber, a.zipCode, a.cityByCityId.id, a.id) from AddressEntity a where a.id = :id")
    AddressDto getAddressById(Long id);
}
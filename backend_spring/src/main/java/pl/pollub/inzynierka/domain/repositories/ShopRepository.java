package pl.pollub.inzynierka.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pollub.inzynierka.domain.entities.ShopEntity;
import pl.pollub.inzynierka.infrastructure.Shop.ShopDto;

import java.util.List;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {

    @Query("select new pl.pollub.inzynierka.infrastructure.Shop.ShopDto(s.name, s.addressByAddressId.id, s.id) from ShopEntity s")
    List<ShopDto> getAllShops();

    @Query("select new pl.pollub.inzynierka.infrastructure.Shop.ShopDto(s.name, s.addressByAddressId.id, s.id) from ShopEntity s where s.id = :id")
    ShopDto getShopById(Long id);
}

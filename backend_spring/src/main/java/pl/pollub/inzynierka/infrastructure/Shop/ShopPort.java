package pl.pollub.inzynierka.infrastructure.Shop;

import java.util.List;

public interface ShopPort {

    ShopDto getShopById(Long id);

    List<ShopDto> getAllShops();

}

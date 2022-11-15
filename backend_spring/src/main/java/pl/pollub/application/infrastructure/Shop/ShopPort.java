package pl.pollub.application.infrastructure.Shop;

import java.util.List;

public interface ShopPort {

    ShopDto getShopById(Long id);

    List<ShopDto> getAllShops();

}

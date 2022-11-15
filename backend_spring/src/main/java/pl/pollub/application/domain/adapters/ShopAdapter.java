package pl.pollub.application.domain.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pollub.application.domain.repositories.ShopRepository;
import pl.pollub.application.infrastructure.Shop.ShopDto;
import pl.pollub.application.infrastructure.Shop.ShopPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ShopAdapter implements ShopPort {

    private final ShopRepository shopRepository;

    @Override
    public ShopDto getShopById(Long id) {
        return shopRepository.getShopById(id);
    }

    @Override
    public List<ShopDto> getAllShops() {
        return shopRepository.getAllShops();
    }
}

package pl.pollub.inzynierka.domain.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pollub.inzynierka.domain.repositories.ShopRepository;
import pl.pollub.inzynierka.infrastructure.Shop.ShopDto;
import pl.pollub.inzynierka.infrastructure.Shop.ShopPort;

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

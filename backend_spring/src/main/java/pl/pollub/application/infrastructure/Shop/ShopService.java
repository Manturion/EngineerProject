package pl.pollub.application.infrastructure.Shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopPort shopPort;

    public ShopDto getShopById(Long id) {
        return shopPort.getShopById(id);
    }

    public List<ShopDto> getAllShops() {
        return shopPort.getAllShops();
    }
}

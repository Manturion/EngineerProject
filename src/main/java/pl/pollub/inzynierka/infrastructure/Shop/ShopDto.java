package pl.pollub.inzynierka.infrastructure.Shop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopDto extends ShopDtoTemplate{
    private Long id;

    public ShopDto(String name, Long addressId, Long id) {
        super(name, addressId);
        this.id = id;
    }
}

package pl.pollub.application.infrastructure.Shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ShopDtoTemplate {
    protected String name;
    protected Long addressId;
}

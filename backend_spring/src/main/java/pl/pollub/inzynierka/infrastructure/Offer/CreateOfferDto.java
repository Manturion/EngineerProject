package pl.pollub.inzynierka.infrastructure.Offer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CreateOfferDto extends OfferDtoTemplate {

    public CreateOfferDto(String title, String description, String image, BigDecimal oldPrice, BigDecimal newPrice, BigDecimal latitude, BigDecimal longtitude, Date startDate, Date expireDate, boolean isAvailable, Long categoryId, boolean deleted) {
        super(title, description, image, oldPrice, newPrice, latitude, longtitude, startDate, expireDate, isAvailable, categoryId, deleted);
    }
}

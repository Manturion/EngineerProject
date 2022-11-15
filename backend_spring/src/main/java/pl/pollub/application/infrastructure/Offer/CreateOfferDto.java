package pl.pollub.application.infrastructure.Offer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CreateOfferDto extends OfferDtoTemplate {

    public CreateOfferDto(String title, String description, String image, BigDecimal oldPrice, BigDecimal newPrice, BigDecimal latitude, BigDecimal longitude, Date startDate, Date expireDate, boolean isAvailable, Long categoryId) {
        super(title, description, image, oldPrice, newPrice, latitude, longitude, startDate, expireDate, isAvailable, categoryId);
    }
}

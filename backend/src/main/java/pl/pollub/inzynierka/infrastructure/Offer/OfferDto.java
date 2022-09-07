package pl.pollub.inzynierka.infrastructure.Offer;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class OfferDto extends OfferDtoTemplate {
    private Long id;

    public OfferDto(String title, String description, String image, BigDecimal oldPrice, BigDecimal newPrize, BigDecimal gps, Date startDate, Date expireDate, boolean isAvailable, Long categoryId, Long id) {
        super(title, description, image, oldPrice, newPrize, gps, startDate, expireDate, isAvailable, categoryId);
        this.id = id;
    }
}
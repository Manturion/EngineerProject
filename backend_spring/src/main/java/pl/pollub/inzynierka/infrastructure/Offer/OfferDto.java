package pl.pollub.inzynierka.infrastructure.Offer;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class OfferDto extends OfferDtoTemplate {
    private Long id;

    public OfferDto(String title, String description, String image, BigDecimal oldPrice, BigDecimal newPrice, BigDecimal latitude, BigDecimal longtitude, Date startDate, Date expireDate, boolean isAvailable, Long categoryId, boolean deleted, Long id) {
        super(title, description, image, oldPrice, newPrice, latitude, longtitude, startDate, expireDate, isAvailable, categoryId, deleted);
        this.id = id;
    }
}
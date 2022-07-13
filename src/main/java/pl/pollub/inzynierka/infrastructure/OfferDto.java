package pl.pollub.inzynierka.infrastructure;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class OfferDto {
    private String title;
    private String description;
    private String image;
    private BigDecimal oldPrice;
    private BigDecimal newPrize;
    private BigDecimal gps;
    private Date startDate;
    private Date expireDate;
    private boolean isAvailable;
    private int id;

    public OfferDto() {
    }

    public OfferDto(String title, String description, String image, BigDecimal oldPrice, BigDecimal newPrize, BigDecimal gps, Date startDate, Date expireDate, boolean isAvailable, int id) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.oldPrice = oldPrice;
        this.newPrize = newPrize;
        this.gps = gps;
        this.startDate = startDate;
        this.expireDate = expireDate;
        this.isAvailable = isAvailable;
        this.id = id;
    }
}
package pl.pollub.application.infrastructure.Offer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class OfferDtoTemplate {
    protected String title;
    protected String description;
    protected String image;
    protected BigDecimal oldPrice;
    protected BigDecimal newPrice;
    protected BigDecimal latitude;
    protected BigDecimal longitude;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Date expireDate;
    protected boolean isAvailable;
    private Long categoryId;


}
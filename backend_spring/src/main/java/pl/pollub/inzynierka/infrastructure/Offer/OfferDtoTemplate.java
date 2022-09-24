package pl.pollub.inzynierka.infrastructure.Offer;

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
    protected BigDecimal gps;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    protected Date startDate;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    protected Date expireDate;
    protected boolean isAvailable;
    //    private int createdBy;
//    private int statusId;
    private Long categoryId;

}
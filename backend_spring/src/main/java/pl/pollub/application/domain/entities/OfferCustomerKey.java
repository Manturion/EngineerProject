package pl.pollub.application.domain.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class OfferCustomerKey implements Serializable {
    @Column(name = "offer_id")
    private int offerId;

    @Column(name = "customer_id")
    private int customerId;
}
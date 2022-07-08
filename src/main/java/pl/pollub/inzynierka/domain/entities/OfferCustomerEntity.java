package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "offer_customer")
@Data
public class OfferCustomerEntity {
    @EmbeddedId
    private OfferCustomerKey id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne
    @MapsId("offerId")
    @JoinColumn(name = "offer_id")
    private OfferEntity offer;

    private int grade;

}

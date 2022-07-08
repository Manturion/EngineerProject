package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Data
public class OfferCustomerEntityPK implements Serializable {
    @Column(name = "customer_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(name = "offer_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int offerId;
}

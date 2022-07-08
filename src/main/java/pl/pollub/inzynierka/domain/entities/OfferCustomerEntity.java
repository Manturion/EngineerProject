package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "offer_customer", schema = "public", catalog = "inzynierka")
@IdClass(OfferCustomerEntityPK.class)
public class OfferCustomerEntity {
    @Basic
    @Column(name = "grade")
    private int grade;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "customer_id")
    private int customerId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "offer_id")
    private int offerId;
}

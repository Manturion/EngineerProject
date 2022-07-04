package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@Table(name = "report", schema = "public", catalog = "inzynierka")
public class ReportEntity {


    private String description;


    private Timestamp date;


    private int offerId;


    private int customerId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private int id;
    @ManyToOne
    @JoinColumn(name = "offer_id", referencedColumnName = "id", nullable = false)
    private OfferEntity offerByOfferId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private CustomerEntity customerByCustomerId;
}

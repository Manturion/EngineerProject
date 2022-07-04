package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@Table(name = "banned_customer", schema = "public", catalog = "inzynierka")
public class BannedCustomerEntity {


    private Timestamp banDate;


    private Timestamp expireDate;


    private String reason;


    private int bannedBy;


    private int customerId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private CustomerEntity customerByCustomerId;
}

package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "banned_customer", schema = "public", catalog = "inzynierka")
public class BannedCustomerEntity {
    @Basic
    @Column(name = "ban_date", nullable = false)
    private Timestamp banDate;
    @Basic
    @Column(name = "expire_date", nullable = false)
    private Timestamp expireDate;
    @Basic
    @Column(name = "reason", nullable = false)
    private String reason;
    @Basic
    @Column(name = "banned_by", nullable = false)
    private int bannedBy;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private CustomerEntity customerByCustomerId;
}

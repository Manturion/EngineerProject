package pl.pollub.inzynierka.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@Table(name = "offer", schema = "public", catalog = "inzynierka")
@AllArgsConstructor
@NoArgsConstructor
public class OfferEntity {
    @Basic
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    @Basic
    @Column(name = "image", nullable = false, length = 255)
    private String image;
    @Basic
    @Column(name = "old_price", nullable = true, precision = 2)
    private BigDecimal oldPrice;
    @Basic
    @Column(name = "new_prize", nullable = true, precision = 2)
    private BigDecimal newPrize;
    @Basic
    @Column(name = "gps", nullable = false, precision = 2)
    private BigDecimal gps;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;
    @Basic
    @Column(name = "expire_date", nullable = true)
    private Timestamp expireDate;
    @Basic
    @Column(name = "is_available", nullable = false)
    private boolean isAvailable;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id", nullable = false)
    private CustomerEntity createdBy;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private StatusEntity statusByStatusId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity categoryByCategoryId;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "offerByOfferId")
    private Collection<ReportEntity> reportsById;

    @OneToMany(mappedBy = "offer")
    private Set<OfferCustomerEntity> grades;
    //private Collection<OfferCustomerEntity> offerCustomersById;

//    @Enumerated(EnumType.STRING)
//    private OfferStatus offerStatus;
}

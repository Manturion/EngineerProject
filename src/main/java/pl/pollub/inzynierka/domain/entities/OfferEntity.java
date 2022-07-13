package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@Table(name = "offer", schema = "public", catalog = "inzynierka")
public class OfferEntity implements java.io.Serializable {
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id", nullable = false)
    private CustomerEntity createdBy;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private StatusEntity statusByStatusId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity categoryByCategoryId;
    @OneToMany(mappedBy = "offerByOfferId")
    private Collection<ReportEntity> reportsById;
    @OneToMany(mappedBy = "offer")
    private Set<OfferCustomerEntity> grades;
    //private Collection<OfferCustomerEntity> offerCustomersById;
}

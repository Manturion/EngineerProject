package pl.pollub.inzynierka.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "offer", schema = "public", catalog = "inzynierka")
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE offer SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class OfferEntity {
    @Basic
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    @Basic
    @Column(name = "description", nullable = false)
    private String description;
    @Basic
    @Column(name = "image", nullable = false, length = 255)
    private String image;
    @Basic
    @Column(name = "old_price", nullable = true, precision = 9, scale = 2)
    private BigDecimal oldPrice;
    @Basic
    @Column(name = "new_price", nullable = true , precision = 9, scale = 2)
    private BigDecimal newPrice;
    @Basic
    @Column(name = "gps", nullable = false, precision = 12, scale = 2)
    private BigDecimal gps;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Basic
    @Column(name = "expire_date", nullable = true)
    private Date expireDate;
    @Basic
    @Column(name = "is_available", nullable = false)
    private boolean isAvailable;
    @Basic
    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "created_by_customer_id", referencedColumnName = "id", nullable = false)
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

}

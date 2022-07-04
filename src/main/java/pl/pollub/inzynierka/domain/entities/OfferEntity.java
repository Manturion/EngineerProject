package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

@Data
@Entity
@Table(name = "offer", schema = "public", catalog = "inzynierka")
public class OfferEntity {


    private String title;


    private String description;


    private String image;


    private BigDecimal oldPrice;


    private BigDecimal newPrize;


    private BigDecimal gps;


    private Timestamp startDate;


    private Timestamp expireDate;


    private boolean isAvailable;


    private int likes;


    private int dislikes;


    private int customerId;


    private int statusId;


    private int categoryId;


    private int sellerId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private CustomerEntity customerByCustomerId;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private StatusEntity statusByStatusId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity categoryByCategoryId;
    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable = false)
    private CustomerEntity customerBySellerId;
    @OneToMany(mappedBy = "offerByOfferId")
    private Collection<ReportEntity> reportsById;

}

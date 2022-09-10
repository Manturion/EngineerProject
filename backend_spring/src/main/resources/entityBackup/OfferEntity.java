package entityBackup;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "offer", schema = "public", catalog = "inzynierka")
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
    @Basic
    @Column(name = "created_by", nullable = false)
    private int createdBy;
    @Basic
    @Column(name = "status_id", nullable = false)
    private int statusId;
    @Basic
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id", nullable = false)
    private CustomerEntity customerByCreatedBy;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private StatusEntity statusByStatusId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity categoryByCategoryId;
    @OneToMany(mappedBy = "offerByOfferId")
    private Collection<OfferCustomerEntity> offerCustomersById;
    @OneToMany(mappedBy = "offerByOfferId")
    private Collection<ReportEntity> reportsById;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public BigDecimal getNewPrize() {
        return newPrize;
    }

    public void setNewPrize(BigDecimal newPrize) {
        this.newPrize = newPrize;
    }

    public BigDecimal getGps() {
        return gps;
    }

    public void setGps(BigDecimal gps) {
        this.gps = gps;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Timestamp expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferEntity that = (OfferEntity) o;
        return isAvailable == that.isAvailable && createdBy == that.createdBy && statusId == that.statusId && categoryId == that.categoryId && id == that.id && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(image, that.image) && Objects.equals(oldPrice, that.oldPrice) && Objects.equals(newPrize, that.newPrize) && Objects.equals(gps, that.gps) && Objects.equals(startDate, that.startDate) && Objects.equals(expireDate, that.expireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, image, oldPrice, newPrize, gps, startDate, expireDate, isAvailable, createdBy, statusId, categoryId, id);
    }

    public CustomerEntity getCustomerByCreatedBy() {
        return customerByCreatedBy;
    }

    public void setCustomerByCreatedBy(CustomerEntity customerByCreatedBy) {
        this.customerByCreatedBy = customerByCreatedBy;
    }

    public StatusEntity getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(StatusEntity statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }

    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    public Collection<OfferCustomerEntity> getOfferCustomersById() {
        return offerCustomersById;
    }

    public void setOfferCustomersById(Collection<OfferCustomerEntity> offerCustomersById) {
        this.offerCustomersById = offerCustomersById;
    }

    public Collection<ReportEntity> getReportsById() {
        return reportsById;
    }

    public void setReportsById(Collection<ReportEntity> reportsById) {
        this.reportsById = reportsById;
    }
}

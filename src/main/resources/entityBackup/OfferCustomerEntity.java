package entityBackup;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "offer_customer", schema = "public", catalog = "inzynierka")
@IdClass(OfferCustomerEntityPK.class)
public class OfferCustomerEntity {
    @Basic
    @Column(name = "grade", nullable = false)
    private int grade;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "customer_id", nullable = false)
    private int customerId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "offer_id", nullable = false)
    private int offerId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private CustomerEntity customerByCustomerId;
    @ManyToOne
    @JoinColumn(name = "offer_id", referencedColumnName = "id", nullable = false)
    private OfferEntity offerByOfferId;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferCustomerEntity that = (OfferCustomerEntity) o;
        return grade == that.grade && customerId == that.customerId && offerId == that.offerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade, customerId, offerId);
    }

    public CustomerEntity getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(CustomerEntity customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    public OfferEntity getOfferByOfferId() {
        return offerByOfferId;
    }

    public void setOfferByOfferId(OfferEntity offerByOfferId) {
        this.offerByOfferId = offerByOfferId;
    }
}

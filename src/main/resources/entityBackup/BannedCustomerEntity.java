package entityBackup;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "banned_customer", schema = "public", catalog = "inzynierka")
public class BannedCustomerEntity {
    @Basic
    @Column(name = "ban_date", nullable = false)
    private Timestamp banDate;
    @Basic
    @Column(name = "expire_date", nullable = false)
    private Timestamp expireDate;
    @Basic
    @Column(name = "reason", nullable = false, length = -1)
    private String reason;
    @Basic
    @Column(name = "banned_by", nullable = false)
    private int bannedBy;
    @Basic
    @Column(name = "customer_id", nullable = false)
    private int customerId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private CustomerEntity customerByCustomerId;

    public Timestamp getBanDate() {
        return banDate;
    }

    public void setBanDate(Timestamp banDate) {
        this.banDate = banDate;
    }

    public Timestamp getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Timestamp expireDate) {
        this.expireDate = expireDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getBannedBy() {
        return bannedBy;
    }

    public void setBannedBy(int bannedBy) {
        this.bannedBy = bannedBy;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
        BannedCustomerEntity that = (BannedCustomerEntity) o;
        return bannedBy == that.bannedBy && customerId == that.customerId && id == that.id && Objects.equals(banDate, that.banDate) && Objects.equals(expireDate, that.expireDate) && Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(banDate, expireDate, reason, bannedBy, customerId, id);
    }

    public CustomerEntity getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(CustomerEntity customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }
}

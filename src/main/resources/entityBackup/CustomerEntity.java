package entityBackup;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "customer", schema = "public", catalog = "inzynierka")
public class CustomerEntity {
    @Basic
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic
    @Column(name = "salt", nullable = false, length = 255)
    private String salt;
    @Basic
    @Column(name = "phone_number", nullable = true, length = 15)
    private String phoneNumber;
    @Basic
    @Column(name = "respect", nullable = false)
    private int respect;
    @Basic
    @Column(name = "is_banned", nullable = false)
    private boolean isBanned;
    @Basic
    @Column(name = "offer_counter", nullable = false)
    private int offerCounter;
    @Basic
    @Column(name = "token", nullable = false, length = 255)
    private String token;
    @Basic
    @Column(name = "role_id", nullable = false)
    private int roleId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<BannedCustomerEntity> bannedCustomersById;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private RoleEntity roleByRoleId;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<CustomerShopEntity> customerShopsById;
    @OneToMany(mappedBy = "customerByCreatedBy")
    private Collection<OfferEntity> offersById;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<OfferCustomerEntity> offerCustomersById;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<ReportEntity> reportsById;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRespect() {
        return respect;
    }

    public void setRespect(int respect) {
        this.respect = respect;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public int getOfferCounter() {
        return offerCounter;
    }

    public void setOfferCounter(int offerCounter) {
        this.offerCounter = offerCounter;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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
        CustomerEntity that = (CustomerEntity) o;
        return respect == that.respect && isBanned == that.isBanned && offerCounter == that.offerCounter && roleId == that.roleId && id == that.id && Objects.equals(email, that.email) && Objects.equals(name, that.name) && Objects.equals(password, that.password) && Objects.equals(salt, that.salt) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, password, salt, phoneNumber, respect, isBanned, offerCounter, token, roleId, id);
    }

    public Collection<BannedCustomerEntity> getBannedCustomersById() {
        return bannedCustomersById;
    }

    public void setBannedCustomersById(Collection<BannedCustomerEntity> bannedCustomersById) {
        this.bannedCustomersById = bannedCustomersById;
    }

    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    public Collection<CustomerShopEntity> getCustomerShopsById() {
        return customerShopsById;
    }

    public void setCustomerShopsById(Collection<CustomerShopEntity> customerShopsById) {
        this.customerShopsById = customerShopsById;
    }

    public Collection<OfferEntity> getOffersById() {
        return offersById;
    }

    public void setOffersById(Collection<OfferEntity> offersById) {
        this.offersById = offersById;
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

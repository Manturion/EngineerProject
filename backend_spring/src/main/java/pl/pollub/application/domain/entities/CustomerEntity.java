package pl.pollub.application.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@Table(name = "customer", schema = "public", catalog = "inzynierka")
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE offer SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
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
    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany
    @JoinTable(name = "customer_shop",
            joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    Set<ShopEntity> customers;

    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<BannedCustomerEntity> bannedCustomersById;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private RoleEntity roleByRoleId;
    //@OneToMany(mappedBy = "customerByCustomerId")
    //private Collection<OfferEntity> offersById;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<ReportEntity> reportsById;

    @OneToMany(mappedBy = "customer")
    private Set<OfferCustomerEntity> grades;
    //@OneToMany(mappedBy = "customerByCustomerId")
    //private Collection<OfferCustomerEntity> offerCustomersById;
}

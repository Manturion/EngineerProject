package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@Table(name = "customer", schema = "public", catalog = "inzynierka")
public class CustomerEntity {
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "salt")
    private String salt;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic
    @Column(name = "respect")
    private int respect;
    @Basic
    @Column(name = "is_banned")
    private boolean isBanned;
    @Basic
    @Column(name = "offer_counter")
    private int offerCounter;
    @Basic
    @Column(name = "token")
    private String token;
    @Basic
    @Column(name = "shop_id")
    private int shopId;
    @Basic
    @Column(name = "role_id")
    private int roleId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<BannedCustomerEntity> bannedCustomersById;
    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id", nullable = false)
    private ShopEntity shopByShopId;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private RoleEntity roleByRoleId;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<OfferEntity> offersById;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<ReportEntity> reportsById;
}

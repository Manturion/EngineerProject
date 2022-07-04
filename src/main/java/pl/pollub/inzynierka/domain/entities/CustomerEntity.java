package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@Table(name = "customer", schema = "public", catalog = "inzynierka")
public class CustomerEntity {


    private String email;


    private String customername;


    private String password;


    private String salt;


    private String phoneNumber;


    private int respect;


    private boolean isBanned;


    private int offerCounter;


    private String token;


    private int roleId;


    private int shopId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private int id;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<BannedCustomerEntity> bannedCustomersById;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private RoleEntity roleByRoleId;
    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id", nullable = false)
    private ShopEntity shopByShopId;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<OfferEntity> offersById;
    @OneToMany(mappedBy = "customerBySellerId")
    private Collection<OfferEntity> offersById_0;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<ReportEntity> reportsById;
}

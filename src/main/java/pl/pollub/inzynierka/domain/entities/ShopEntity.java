package pl.pollub.inzynierka.domain.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "shop", schema = "public", catalog = "inzynierka")
public class ShopEntity {
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "address_id", nullable = false)
    private int addressId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToMany
    Set<OfferEntity> offers;

    @OneToMany(mappedBy = "shopByShopId")
    private List<CustomerEntity> customersById;
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private AddressEntity addressByAddressId;
    //@OneToMany(mappedBy = "shopByShopId")
    //private Collection<CustomerShopEntity> customerShopsById;
}

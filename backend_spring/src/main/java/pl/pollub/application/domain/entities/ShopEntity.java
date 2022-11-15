package pl.pollub.application.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "shop", schema = "public", catalog = "inzynierka")
public class ShopEntity {
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany
    Set<OfferEntity> offers;

    //@OneToMany(mappedBy = "shopByShopId")
    //private List<CustomerEntity> customersById;
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private AddressEntity addressByAddressId;
    //@OneToMany(mappedBy = "shopByShopId")
    //private Collection<CustomerShopEntity> customerShopsById;
}

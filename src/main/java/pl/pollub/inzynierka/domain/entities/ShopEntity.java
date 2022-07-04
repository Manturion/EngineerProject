package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@Table(name = "shop", schema = "public", catalog = "inzynierka")
public class ShopEntity {


    private String name;


    private int addressId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private int id;
    @OneToMany(mappedBy = "shopByShopId")
    private Collection<CustomerEntity> customersById;
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private AddressEntity addressByAddressId;

}

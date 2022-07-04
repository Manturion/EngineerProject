package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@Table(name = "address", schema = "public", catalog = "inzynierka")
public class AddressEntity {


    private String streetName;


    private String streetNumber;


    private String flatNumber;


    private String zipCode;


    private int cityId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private int id;
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    private CityEntity cityByCityId;
    @OneToMany(mappedBy = "addressByAddressId")
    private Collection<ShopEntity> shopsById;
}

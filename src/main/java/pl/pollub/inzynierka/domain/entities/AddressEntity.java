package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@Table(name = "address", schema = "public", catalog = "inzynierka")
public class AddressEntity {
    @Basic
    @Column(name = "street_name", nullable = false, length = 255)
    private String streetName;
    @Basic
    @Column(name = "street_number", nullable = false, length = 5)
    private String streetNumber;
    @Basic
    @Column(name = "flat_number", nullable = true, length = 5)
    private String flatNumber;
    @Basic
    @Column(name = "zip_code", nullable = false, length = 6)
    private String zipCode;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    private CityEntity cityByCityId;
    @OneToMany(mappedBy = "addressByAddressId")
    private Collection<ShopEntity> shopsById;
}

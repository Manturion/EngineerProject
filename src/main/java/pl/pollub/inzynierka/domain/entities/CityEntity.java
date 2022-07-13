package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@Table(name = "city", schema = "public", catalog = "inzynierka")
public class CityEntity {
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @OneToMany(mappedBy = "cityByCityId")
    private Collection<AddressEntity> addressesById;
}

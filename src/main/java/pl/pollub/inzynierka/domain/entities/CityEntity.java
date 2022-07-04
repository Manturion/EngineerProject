package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@Table(name = "city", schema = "public", catalog = "inzynierka")
public class CityEntity {


    private String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private int id;
    @OneToMany(mappedBy = "cityByCityId")
    private Collection<AddressEntity> addressesById;
}

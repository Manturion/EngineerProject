package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@Table(name = "status", schema = "public", catalog = "inzynierka")
public class StatusEntity {


    private String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private int id;
    @OneToMany(mappedBy = "statusByStatusId")
    private Collection<OfferEntity> offersById;

}

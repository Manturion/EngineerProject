package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@Table(name = "status", schema = "public", catalog = "inzynierka")
public class StatusEntity {
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @OneToMany(mappedBy = "statusByStatusId")
    private Collection<OfferEntity> offersById;
}

package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@Table(name = "category", schema = "public", catalog = "inzynierka")
public class CategoryEntity {


    private String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private int id;
    @OneToMany(mappedBy = "categoryByCategoryId")
    private Collection<OfferEntity> offersById;
}

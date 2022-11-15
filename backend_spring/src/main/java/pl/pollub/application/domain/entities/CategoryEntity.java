package pl.pollub.application.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "category", schema = "public", catalog = "inzynierka")
public class CategoryEntity {
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToMany(mappedBy = "categoryByCategoryId")
    private Collection<OfferEntity> offersById;
}

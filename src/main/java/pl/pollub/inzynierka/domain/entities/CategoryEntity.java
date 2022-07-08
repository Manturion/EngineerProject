package pl.pollub.inzynierka.domain.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "public", catalog = "inzynierka")
public class CategoryEntity {
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @OneToMany(mappedBy = "categoryByCategoryId")
    private Collection<OfferEntity> offersById;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public Collection<OfferEntity> getOffersById() {
        return offersById;
    }

    public void setOffersById(Collection<OfferEntity> offersById) {
        this.offersById = offersById;
    }
}

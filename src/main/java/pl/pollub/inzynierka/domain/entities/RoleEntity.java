package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@Table(name = "role", schema = "public", catalog = "inzynierka")
public class RoleEntity {
    @Basic
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @OneToMany(mappedBy = "roleByRoleId")
    private Collection<CustomerEntity> customersById;
}

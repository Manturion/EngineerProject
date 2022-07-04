package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@Table(name = "role", schema = "public", catalog = "inzynierka")
public class RoleEntity {


    private String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private int id;
    @OneToMany(mappedBy = "roleByRoleId")
    private Collection<CustomerEntity> customersById;
}

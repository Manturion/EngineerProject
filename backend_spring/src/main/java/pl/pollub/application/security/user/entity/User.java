package pl.pollub.inzynierka.security.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pollub.inzynierka.security.user.dto.UserRequestDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @ElementCollection
    @CollectionTable
    private List<String> roles = new ArrayList<>();

    public User(UserRequestDto userRequestDto) {
        this.username = userRequestDto.getUsername();
        this.password = userRequestDto.getPassword();
    }
}

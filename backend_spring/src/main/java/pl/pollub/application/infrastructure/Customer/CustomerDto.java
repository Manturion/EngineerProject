package pl.pollub.inzynierka.infrastructure.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto extends CustomerDtoTemplate{

    private Long id;

    public CustomerDto(String email, String name, String password, String salt, String phoneNumber, int respect, boolean isBanned, int offerCounter, String token, Long roleId, boolean deleted, Long id) {
        super(email, name, password, salt, phoneNumber, respect, isBanned, offerCounter, token, roleId, deleted);
        this.id = id;
    }
}

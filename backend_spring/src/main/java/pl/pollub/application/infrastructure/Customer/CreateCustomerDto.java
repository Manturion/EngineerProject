package pl.pollub.application.infrastructure.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCustomerDto extends CustomerDtoTemplate{

    public CreateCustomerDto(String email, String name, String password, String salt, String phoneNumber, int respect, boolean isBanned, int offerCounter, String token, Long roleId, boolean deleted) {
        super(email, name, password, salt, phoneNumber, respect, isBanned, offerCounter, token, roleId, deleted);
    }
}

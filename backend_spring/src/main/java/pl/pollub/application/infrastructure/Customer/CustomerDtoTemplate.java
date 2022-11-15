package pl.pollub.inzynierka.infrastructure.Customer;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class CustomerDtoTemplate {
    protected String email;
    protected String name;
    protected String password;
    protected String salt;
    protected String phoneNumber;
    protected int respect;
    protected boolean isBanned;
    protected int offerCounter;
    protected String token;
    private Long roleByRoleId;
    private boolean deleted;
}

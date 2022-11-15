package pl.pollub.application.infrastructure.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class AddressDtoTemplate {
    protected String streetName;
    protected String streetNumber;
    protected String flatNumber;
    protected String zipCode;
    protected Long cityId;
}

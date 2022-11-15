package pl.pollub.application.infrastructure.Customer;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface CustomerPort {

    Optional<CustomerDto> getCustomerById(@PathVariable Long id);

    List<CustomerDto> getAllCustomers();

    Long createCustomer(CreateCustomerDto createCustomerDto);

    Long deleteCustomer(Long id);

    Optional<Long> editCustomer(CustomerDto customerDto, Long id);
}

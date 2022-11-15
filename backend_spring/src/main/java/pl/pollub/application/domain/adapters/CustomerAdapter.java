package pl.pollub.application.domain.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pollub.application.domain.entities.CustomerEntity;
import pl.pollub.application.domain.mappers.CustomerMapper;
import pl.pollub.application.domain.repositories.CustomerRepository;
import pl.pollub.application.infrastructure.Customer.CreateCustomerDto;
import pl.pollub.application.infrastructure.Customer.CustomerDto;
import pl.pollub.application.infrastructure.Customer.CustomerPort;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerAdapter implements CustomerPort {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;
    @Override
    public Optional<CustomerDto> getCustomerById(Long id) {
        return Optional.ofNullable(customerRepository.getCustomerById(id));
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public Long createCustomer(CreateCustomerDto createCustomerDto) {

        //CustomerEntity customerEntity = mapToEntity(createCustomerDto);

        return null;
    }

    @Override
    public Long deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        return id;
    }

    @Override
    public Optional<Long> editCustomer(CustomerDto customerDto, Long id) {
        return Optional.empty();
    }

    private CustomerEntity mapToEntity(CreateCustomerDto createCustomerDto){
        return null;
    }
}

package pl.pollub.inzynierka.infrastructure.Customer;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerPort customerPort;

    public Optional<CustomerDto> getCustomerById(Long id){
        return customerPort.getCustomerById(id);
    }

    public List<CustomerDto> getAllCustomers(){
        return customerPort.getAllCustomers();
    }

    public Long createCustomer(CreateCustomerDto createCustomerDto){
        return customerPort.createCustomer(createCustomerDto);
    }

    public Long deleteCustomer(Long id){
        return customerPort.deleteCustomer(id);
    }

    public Optional<Long> editCustomer(CustomerDto customerDto, Long id){
        return customerPort.editCustomer(customerDto, id);
    }
}

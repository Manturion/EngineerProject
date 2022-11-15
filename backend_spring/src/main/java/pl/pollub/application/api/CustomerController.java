package pl.pollub.application.api;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.pollub.application.infrastructure.Customer.CreateCustomerDto;
import pl.pollub.application.infrastructure.Customer.CustomerDto;
import pl.pollub.application.infrastructure.Customer.CustomerService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/customer")
@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<CustomerDto> getCustomerId(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @GetMapping()
    @ResponseBody
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createCustomer(@RequestBody CreateCustomerDto createCustomerDto){
        return ResponseEntity.ok(customerService.createCustomer(createCustomerDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteCustomer(@PathVariable Long id){
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Optional<Long>> editCustomer(@RequestBody CustomerDto customerDto, @PathVariable Long id){
        return ResponseEntity.ok(customerService.editCustomer(customerDto, id));
    }
}

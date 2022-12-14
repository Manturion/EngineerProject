package pl.pollub.application.infrastructure.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomerService.class})
@ExtendWith(SpringExtension.class)
class CustomerServiceTest {
    @MockBean
    private CustomerPort customerPort;

    @Autowired
    private CustomerService customerService;

    /**
     * Method under test: {@link CustomerService#getCustomerById(Long)}
     */
    @Test
    void testGetCustomerById() {
        Optional<CustomerDto> ofResult = Optional.of(new CustomerDto("jane.doe@example.org", "Name", "iloveyou", "Salt",
                "4105551212", 1, true, 3, "ABC123", 123L, true, 123L));
        when(customerPort.getCustomerById((Long) any())).thenReturn(ofResult);
        Optional<CustomerDto> actualCustomerById = customerService.getCustomerById(123L);
        assertSame(ofResult, actualCustomerById);
        assertTrue(actualCustomerById.isPresent());
        verify(customerPort).getCustomerById((Long) any());
    }

    /**
     * Method under test: {@link CustomerService#getAllCustomers()}
     */
    @Test
    void testGetAllCustomers() {
        ArrayList<CustomerDto> customerDtoList = new ArrayList<>();
        when(customerPort.getAllCustomers()).thenReturn(customerDtoList);
        List<CustomerDto> actualAllCustomers = customerService.getAllCustomers();
        assertSame(customerDtoList, actualAllCustomers);
        assertTrue(actualAllCustomers.isEmpty());
        verify(customerPort).getAllCustomers();
    }

    /**
     * Method under test: {@link CustomerService#createCustomer(CreateCustomerDto)}
     */
    @Test
    void testCreateCustomer() {
        when(customerPort.createCustomer((CreateCustomerDto) any())).thenReturn(1L);
        assertEquals(1L, customerService.createCustomer(new CreateCustomerDto()).longValue());
        verify(customerPort).createCustomer((CreateCustomerDto) any());
    }

    /**
     * Method under test: {@link CustomerService#deleteCustomer(Long)}
     */
    @Test
    void testDeleteCustomer() {
        when(customerPort.deleteCustomer((Long) any())).thenReturn(1L);
        assertEquals(1L, customerService.deleteCustomer(123L).longValue());
        verify(customerPort).deleteCustomer((Long) any());
    }

    /**
     * Method under test: {@link CustomerService#editCustomer(CustomerDto, Long)}
     */
    @Test
    void testEditCustomer() {
        Optional<Long> ofResult = Optional.of(42L);
        when(customerPort.editCustomer((CustomerDto) any(), (Long) any())).thenReturn(ofResult);
        Optional<Long> actualEditCustomerResult = customerService.editCustomer(new CustomerDto("jane.doe@example.org",
                "Name", "iloveyou", "Salt", "4105551212", 1, true, 3, "ABC123", 123L, true, 123L), 123L);
        assertSame(ofResult, actualEditCustomerResult);
        assertTrue(actualEditCustomerResult.isPresent());
        assertEquals(42L, actualEditCustomerResult.get());
        verify(customerPort).editCustomer((CustomerDto) any(), (Long) any());
    }
}


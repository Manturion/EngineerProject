package pl.pollub.application.domain.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.pollub.application.domain.mappers.CustomerMapper;
import pl.pollub.application.domain.repositories.CustomerRepository;
import pl.pollub.application.infrastructure.Customer.CreateCustomerDto;
import pl.pollub.application.infrastructure.Customer.CustomerDto;

@ContextConfiguration(classes = {CustomerAdapter.class})
@ExtendWith(SpringExtension.class)
class CustomerAdapterTest {
    @Autowired
    private CustomerAdapter customerAdapter;

    @MockBean
    private CustomerMapper customerMapper;

    @MockBean
    private CustomerRepository customerRepository;

    /**
     * Method under test: {@link CustomerAdapter#getCustomerById(Long)}
     */
    @Test
    void testGetCustomerById() {
        when(customerRepository.getCustomerById((Long) any())).thenReturn(new CustomerDto("jane.doe@example.org", "Name",
                "iloveyou", "Salt", "4105551212", 1, true, 3, "ABC123", 123L, true, 123L));
        assertTrue(customerAdapter.getCustomerById(123L).isPresent());
        verify(customerRepository).getCustomerById((Long) any());
    }

    /**
     * Method under test: {@link CustomerAdapter#getAllCustomers()}
     */
    @Test
    void testGetAllCustomers() {
        ArrayList<CustomerDto> customerDtoList = new ArrayList<>();
        when(customerRepository.getAllCustomers()).thenReturn(customerDtoList);
        List<CustomerDto> actualAllCustomers = customerAdapter.getAllCustomers();
        assertSame(customerDtoList, actualAllCustomers);
        assertTrue(actualAllCustomers.isEmpty());
        verify(customerRepository).getAllCustomers();
    }

    /**
     * Method under test: {@link CustomerAdapter#createCustomer(CreateCustomerDto)}
     */
    @Test
    void testCreateCustomer() {
        assertNull(customerAdapter.createCustomer(new CreateCustomerDto()));
        assertNull(customerAdapter.createCustomer(mock(CreateCustomerDto.class)));
    }

    /**
     * Method under test: {@link CustomerAdapter#deleteCustomer(Long)}
     */
    @Test
    void testDeleteCustomer() {
        doNothing().when(customerRepository).deleteById((Long) any());
        assertEquals(123L, customerAdapter.deleteCustomer(123L).longValue());
        verify(customerRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link CustomerAdapter#editCustomer(CustomerDto, Long)}
     */
    @Test
    void testEditCustomer() {
        assertFalse(customerAdapter
                .editCustomer(new CustomerDto("jane.doe@example.org", "Name", "iloveyou", "Salt", "4105551212", 1, true, 3,
                        "ABC123", 123L, true, 123L), 123L)
                .isPresent());
        assertFalse(customerAdapter.editCustomer(mock(CustomerDto.class), 123L).isPresent());
    }
}


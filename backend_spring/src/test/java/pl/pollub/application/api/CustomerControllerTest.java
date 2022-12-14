package pl.pollub.application.api;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.pollub.application.infrastructure.Customer.CreateCustomerDto;
import pl.pollub.application.infrastructure.Customer.CustomerDto;
import pl.pollub.application.infrastructure.Customer.CustomerService;

@ContextConfiguration(classes = {CustomerController.class})
@ExtendWith(SpringExtension.class)
class CustomerControllerTest {
    @Autowired
    private CustomerController customerController;

    @MockBean
    private CustomerService customerService;

    /**
     * Method under test: {@link CustomerController#getAllCustomers()}
     */
    @Test
    void testGetAllCustomers() throws Exception {
        when(customerService.getAllCustomers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/customer");
        MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CustomerController#getAllCustomers()}
     */
    @Test
    void testGetAllCustomers2() throws Exception {
        when(customerService.getAllCustomers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/customer");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CustomerController#createCustomer(CreateCustomerDto)}
     */
    @Test
    void testCreateCustomer() throws Exception {
        when(customerService.createCustomer((CreateCustomerDto) any())).thenReturn(1L);

        CreateCustomerDto createCustomerDto = new CreateCustomerDto();
        createCustomerDto.setBanned(true);
        createCustomerDto.setDeleted(true);
        createCustomerDto.setEmail("jane.doe@example.org");
        createCustomerDto.setName("Name");
        createCustomerDto.setOfferCounter(3);
        createCustomerDto.setPassword("iloveyou");
        createCustomerDto.setPhoneNumber("4105551212");
        createCustomerDto.setRespect(1);
        createCustomerDto.setRoleByRoleId(123L);
        createCustomerDto.setSalt("Salt");
        createCustomerDto.setToken("ABC123");
        String content = (new ObjectMapper()).writeValueAsString(createCustomerDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/customer/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("1"));
    }

    /**
     * Method under test: {@link CustomerController#deleteCustomer(Long)}
     */
    @Test
    void testDeleteCustomer() throws Exception {
        when(customerService.deleteCustomer((Long) any())).thenReturn(1L);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/customer/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("1"));
    }

    /**
     * Method under test: {@link CustomerController#deleteCustomer(Long)}
     */
    @Test
    void testDeleteCustomer2() throws Exception {
        when(customerService.deleteCustomer((Long) any())).thenReturn(1L);
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/customer/delete/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("1"));
    }

    /**
     * Method under test: {@link CustomerController#editCustomer(CustomerDto, Long)}
     */
    @Test
    void testEditCustomer() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .put("/api/customer/edit/{id}", "", "Uri Variables")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new CustomerDto("jane.doe@example.org", "Name", "iloveyou", "Salt",
                        "4105551212", 1, true, 3, "ABC123", 123L, true, 123L)));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }

    /**
     * Method under test: {@link CustomerController#getCustomerId(Long)}
     */
    @Test
    void testGetCustomerId() throws Exception {
        when(customerService.getCustomerById((Long) any())).thenReturn(Optional.of(new CustomerDto("jane.doe@example.org",
                "Name", "iloveyou", "Salt", "4105551212", 1, true, 3, "ABC123", 123L, true, 123L)));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/customer/{id}", 123L);
        MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"email\":\"jane.doe@example.org\",\"name\":\"Name\",\"password\":\"iloveyou\",\"salt\":\"Salt\",\"phoneNumber\":"
                                        + "\"4105551212\",\"respect\":1,\"offerCounter\":3,\"token\":\"ABC123\",\"roleByRoleId\":123,\"deleted\":true,\"id\":123"
                                        + ",\"banned\":true}"));
    }
}


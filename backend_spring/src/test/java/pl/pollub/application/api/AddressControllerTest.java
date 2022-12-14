package pl.pollub.application.api;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.pollub.application.infrastructure.Address.AddressDto;
import pl.pollub.application.infrastructure.Address.AddressService;

@ContextConfiguration(classes = {AddressController.class})
@ExtendWith(SpringExtension.class)
class AddressControllerTest {
    @Autowired
    private AddressController addressController;

    @MockBean
    private AddressService addressService;

    /**
     * Method under test: {@link AddressController#getAddressById(Long)}
     */
    @Test
    void testGetAddressById() throws Exception {
        when(addressService.getAddressById((Long) any()))
                .thenReturn(new AddressDto("Street Name", "42", "42", "21654", 123L, 123L));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/address/{id}", 123L);
        MockMvcBuilders.standaloneSetup(addressController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"streetName\":\"Street Name\",\"streetNumber\":\"42\",\"flatNumber\":\"42\",\"zipCode\":\"21654\",\"cityId\":123"
                                        + ",\"id\":123}"));
    }

    /**
     * Method under test: {@link AddressController#getAllAddresses()}
     */
    @Test
    void testGetAllAddresses() throws Exception {
        when(addressService.getAllAddresses()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/addresses");
        MockMvcBuilders.standaloneSetup(addressController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AddressController#getAllAddresses()}
     */
    @Test
    void testGetAllAddresses2() throws Exception {
        when(addressService.getAllAddresses()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/addresses");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(addressController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}


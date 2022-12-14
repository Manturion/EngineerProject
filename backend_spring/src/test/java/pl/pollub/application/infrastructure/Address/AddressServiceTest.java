package pl.pollub.application.infrastructure.Address;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
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

@ContextConfiguration(classes = {AddressService.class})
@ExtendWith(SpringExtension.class)
class AddressServiceTest {
    @MockBean
    private AddressPort addressPort;

    @Autowired
    private AddressService addressService;

    /**
     * Method under test: {@link AddressService#getAddressById(Long)}
     */
    @Test
    void testGetAddressById() {
        AddressDto addressDto = new AddressDto("Street Name", "42", "42", "21654", 123L, 123L);

        when(addressPort.getAddressById((Long) any())).thenReturn(addressDto);
        assertSame(addressDto, addressService.getAddressById(123L));
        verify(addressPort).getAddressById((Long) any());
    }

    /**
     * Method under test: {@link AddressService#getAllAddresses()}
     */
    @Test
    void testGetAllAddresses() {
        ArrayList<AddressDto> addressDtoList = new ArrayList<>();
        when(addressPort.getAllAddresses()).thenReturn(addressDtoList);
        List<AddressDto> actualAllAddresses = addressService.getAllAddresses();
        assertSame(addressDtoList, actualAllAddresses);
        assertTrue(actualAllAddresses.isEmpty());
        verify(addressPort).getAllAddresses();
    }
}


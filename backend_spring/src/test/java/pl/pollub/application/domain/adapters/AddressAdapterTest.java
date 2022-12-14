package pl.pollub.application.domain.adapters;

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
import pl.pollub.application.domain.repositories.AddressRepository;
import pl.pollub.application.infrastructure.Address.AddressDto;

@ContextConfiguration(classes = {AddressAdapter.class})
@ExtendWith(SpringExtension.class)
class AddressAdapterTest {
    @Autowired
    private AddressAdapter addressAdapter;

    @MockBean
    private AddressRepository addressRepository;

    /**
     * Method under test: {@link AddressAdapter#getAllAddresses()}
     */
    @Test
    void testGetAllAddresses() {
        ArrayList<AddressDto> addressDtoList = new ArrayList<>();
        when(addressRepository.getAllAddresses()).thenReturn(addressDtoList);
        List<AddressDto> actualAllAddresses = addressAdapter.getAllAddresses();
        assertSame(addressDtoList, actualAllAddresses);
        assertTrue(actualAllAddresses.isEmpty());
        verify(addressRepository).getAllAddresses();
    }

    /**
     * Method under test: {@link AddressAdapter#getAddressById(Long)}
     */
    @Test
    void testGetAddressById() {
        AddressDto addressDto = new AddressDto("Street Name", "42", "42", "21654", 123L, 123L);

        when(addressRepository.getAddressById((Long) any())).thenReturn(addressDto);
        assertSame(addressDto, addressAdapter.getAddressById(123L));
        verify(addressRepository).getAddressById((Long) any());
    }
}


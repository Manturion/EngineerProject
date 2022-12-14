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
import pl.pollub.application.domain.repositories.ShopRepository;
import pl.pollub.application.infrastructure.Shop.ShopDto;

@ContextConfiguration(classes = {ShopAdapter.class})
@ExtendWith(SpringExtension.class)
class ShopAdapterTest {
    @Autowired
    private ShopAdapter shopAdapter;

    @MockBean
    private ShopRepository shopRepository;

    /**
     * Method under test: {@link ShopAdapter#getShopById(Long)}
     */
    @Test
    void testGetShopById() {
        ShopDto shopDto = new ShopDto("Name", 123L, 123L);

        when(shopRepository.getShopById((Long) any())).thenReturn(shopDto);
        assertSame(shopDto, shopAdapter.getShopById(123L));
        verify(shopRepository).getShopById((Long) any());
    }

    /**
     * Method under test: {@link ShopAdapter#getAllShops()}
     */
    @Test
    void testGetAllShops() {
        ArrayList<ShopDto> shopDtoList = new ArrayList<>();
        when(shopRepository.getAllShops()).thenReturn(shopDtoList);
        List<ShopDto> actualAllShops = shopAdapter.getAllShops();
        assertSame(shopDtoList, actualAllShops);
        assertTrue(actualAllShops.isEmpty());
        verify(shopRepository).getAllShops();
    }
}


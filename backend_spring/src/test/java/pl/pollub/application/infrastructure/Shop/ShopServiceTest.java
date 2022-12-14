package pl.pollub.application.infrastructure.Shop;

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

@ContextConfiguration(classes = {ShopService.class})
@ExtendWith(SpringExtension.class)
class ShopServiceTest {
    @MockBean
    private ShopPort shopPort;

    @Autowired
    private ShopService shopService;

    /**
     * Method under test: {@link ShopService#getShopById(Long)}
     */
    @Test
    void testGetShopById() {
        ShopDto shopDto = new ShopDto("Name", 123L, 123L);

        when(shopPort.getShopById((Long) any())).thenReturn(shopDto);
        assertSame(shopDto, shopService.getShopById(123L));
        verify(shopPort).getShopById((Long) any());
    }

    /**
     * Method under test: {@link ShopService#getAllShops()}
     */
    @Test
    void testGetAllShops() {
        ArrayList<ShopDto> shopDtoList = new ArrayList<>();
        when(shopPort.getAllShops()).thenReturn(shopDtoList);
        List<ShopDto> actualAllShops = shopService.getAllShops();
        assertSame(shopDtoList, actualAllShops);
        assertTrue(actualAllShops.isEmpty());
        verify(shopPort).getAllShops();
    }
}


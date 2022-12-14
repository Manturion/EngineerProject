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
import pl.pollub.application.infrastructure.Shop.ShopDto;
import pl.pollub.application.infrastructure.Shop.ShopService;

@ContextConfiguration(classes = {ShopController.class})
@ExtendWith(SpringExtension.class)
class ShopControllerTest {
    @Autowired
    private ShopController shopController;

    @MockBean
    private ShopService shopService;

    /**
     * Method under test: {@link ShopController#getShopById(Long)}
     */
    @Test
    void testGetShopById() throws Exception {
        when(shopService.getShopById((Long) any())).thenReturn(new ShopDto("Name", 123L, 123L));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/shop/{id}", 123L);
        MockMvcBuilders.standaloneSetup(shopController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"name\":\"Name\",\"addressId\":123,\"id\":123}"));
    }

    /**
     * Method under test: {@link ShopController#getAllShops()}
     */
    @Test
    void testGetAllShops() throws Exception {
        when(shopService.getAllShops()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/shops");
        MockMvcBuilders.standaloneSetup(shopController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ShopController#getAllShops()}
     */
    @Test
    void testGetAllShops2() throws Exception {
        when(shopService.getAllShops()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/shops");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(shopController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}


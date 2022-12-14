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
import pl.pollub.application.infrastructure.City.CityDto;
import pl.pollub.application.infrastructure.City.CityService;

@ContextConfiguration(classes = {CityController.class})
@ExtendWith(SpringExtension.class)
class CityControllerTest {
    @Autowired
    private CityController cityController;

    @MockBean
    private CityService cityService;

    /**
     * Method under test: {@link CityController#getCityById(Long)}
     */
    @Test
    void testGetCityById() throws Exception {
        when(cityService.getCityById((Long) any())).thenReturn(new CityDto("Name", 123L));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/city/{id}", 123L);
        MockMvcBuilders.standaloneSetup(cityController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"name\":\"Name\",\"id\":123}"));
    }

    /**
     * Method under test: {@link CityController#getCityById(Long)}
     */
    @Test
    void testGetCityById2() throws Exception {
        when(cityService.getAllCities()).thenReturn(new ArrayList<>());
        when(cityService.getCityById((Long) any())).thenReturn(new CityDto("Name", 123L));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/city/{id}", "", "Uri Variables");
        MockMvcBuilders.standaloneSetup(cityController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CityController#getAllCities()}
     */
    @Test
    void testGetAllCities() throws Exception {
        when(cityService.getAllCities()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/city");
        MockMvcBuilders.standaloneSetup(cityController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CityController#getAllCities()}
     */
    @Test
    void testGetAllCities2() throws Exception {
        when(cityService.getAllCities()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/city");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(cityController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}


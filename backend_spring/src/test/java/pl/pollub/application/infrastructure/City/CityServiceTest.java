package pl.pollub.application.infrastructure.City;

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

@ContextConfiguration(classes = {CityService.class})
@ExtendWith(SpringExtension.class)
class CityServiceTest {
    @MockBean
    private CityPort cityPort;

    @Autowired
    private CityService cityService;

    /**
     * Method under test: {@link CityService#getCityById(Long)}
     */
    @Test
    void testGetCityById() {
        CityDto cityDto = new CityDto("Name", 123L);

        when(cityPort.getCityById((Long) any())).thenReturn(cityDto);
        assertSame(cityDto, cityService.getCityById(123L));
        verify(cityPort).getCityById((Long) any());
    }

    /**
     * Method under test: {@link CityService#getAllCities()}
     */
    @Test
    void testGetAllCities() {
        ArrayList<CityDto> cityDtoList = new ArrayList<>();
        when(cityPort.getAllCities()).thenReturn(cityDtoList);
        List<CityDto> actualAllCities = cityService.getAllCities();
        assertSame(cityDtoList, actualAllCities);
        assertTrue(actualAllCities.isEmpty());
        verify(cityPort).getAllCities();
    }
}


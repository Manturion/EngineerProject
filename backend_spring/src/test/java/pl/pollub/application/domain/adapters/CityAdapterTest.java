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
import pl.pollub.application.domain.repositories.CityRepository;
import pl.pollub.application.infrastructure.City.CityDto;

@ContextConfiguration(classes = {CityAdapter.class})
@ExtendWith(SpringExtension.class)
class CityAdapterTest {
    @Autowired
    private CityAdapter cityAdapter;

    @MockBean
    private CityRepository cityRepository;

    /**
     * Method under test: {@link CityAdapter#getAllCities()}
     */
    @Test
    void testGetAllCities() {
        ArrayList<CityDto> cityDtoList = new ArrayList<>();
        when(cityRepository.getAllCities()).thenReturn(cityDtoList);
        List<CityDto> actualAllCities = cityAdapter.getAllCities();
        assertSame(cityDtoList, actualAllCities);
        assertTrue(actualAllCities.isEmpty());
        verify(cityRepository).getAllCities();
    }

    /**
     * Method under test: {@link CityAdapter#getCityById(Long)}
     */
    @Test
    void testGetCityById() {
        CityDto cityDto = new CityDto("Name", 123L);

        when(cityRepository.getCityById((Long) any())).thenReturn(cityDto);
        assertSame(cityDto, cityAdapter.getCityById(123L));
        verify(cityRepository).getCityById((Long) any());
    }
}


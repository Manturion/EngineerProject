package pl.pollub.application.infrastructure.City;

import java.util.List;

public interface CityPort {

    List<CityDto> getAllCities();

    CityDto getCityById(Long id);

}

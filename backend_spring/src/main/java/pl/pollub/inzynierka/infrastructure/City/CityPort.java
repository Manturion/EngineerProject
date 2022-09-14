package pl.pollub.inzynierka.infrastructure.City;

import java.util.List;

public interface CityPort {

    List<CityDto> getAllCities();

    CityDto getCityById(Long id);

}

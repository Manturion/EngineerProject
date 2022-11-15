package pl.pollub.application.domain.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pollub.application.domain.repositories.CityRepository;
import pl.pollub.application.infrastructure.City.CityDto;
import pl.pollub.application.infrastructure.City.CityPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CityAdapter implements CityPort {

    private final CityRepository cityRepository;

    @Override
    public List<CityDto> getAllCities() {
        return cityRepository.getAllCities();
    }

    @Override
    public CityDto getCityById(Long id) {
        return cityRepository.getCityById(id);
    }
}

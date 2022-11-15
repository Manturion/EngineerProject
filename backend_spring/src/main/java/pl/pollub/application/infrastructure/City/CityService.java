package pl.pollub.application.infrastructure.City;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityPort cityPort;

    public CityDto getCityById(Long id) {
        return cityPort.getCityById(id);
    }

    public List<CityDto> getAllCities() {
        return cityPort.getAllCities();
    }

}

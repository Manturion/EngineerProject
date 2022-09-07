package pl.pollub.inzynierka.domain.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pollub.inzynierka.domain.repositories.CityRepository;
import pl.pollub.inzynierka.infrastructure.City.CityDto;
import pl.pollub.inzynierka.infrastructure.City.CityPort;
import pl.pollub.inzynierka.infrastructure.Offer.OfferDto;

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

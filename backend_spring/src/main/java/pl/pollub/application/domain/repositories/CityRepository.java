package pl.pollub.application.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pollub.application.domain.entities.CityEntity;
import pl.pollub.application.infrastructure.City.CityDto;

import java.util.List;

public interface CityRepository extends JpaRepository<CityEntity,  Long> {

    @Query("select new pl.pollub.application.infrastructure.City.CityDto(c.name, c.id) from CityEntity c")
    List<CityDto> getAllCities();

    @Query("select new pl.pollub.application.infrastructure.City.CityDto(c.name, c.id) from CityEntity c where c.id = :id")
    CityDto getCityById(Long id);

}

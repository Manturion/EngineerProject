package pl.pollub.inzynierka.infrastructure.City;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDto  extends CityDtoTemplate{
    private Long id;

    public CityDto(String name, Long id) {
        super(name);
        this.id = id;
    }
}

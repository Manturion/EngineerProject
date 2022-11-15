package pl.pollub.application.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.pollub.application.infrastructure.City.CityDto;
import pl.pollub.application.infrastructure.City.CityService;

import java.util.List;

@RequestMapping("/api")
@Controller
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("/city/{id}")
    @ResponseBody
    public CityDto getCityById(@PathVariable Long id){return cityService.getCityById(id);}

    @GetMapping("/city")
    @ResponseBody
    public List<CityDto> getAllCities(){return cityService.getAllCities();}

}

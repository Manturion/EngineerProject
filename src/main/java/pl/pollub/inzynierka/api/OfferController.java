package pl.pollub.inzynierka.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.pollub.inzynierka.domain.entities.OfferEntity;
import pl.pollub.inzynierka.infrastructure.OfferDto;
import pl.pollub.inzynierka.infrastructure.OfferService;

import java.util.List;

@RequestMapping("/api")
@Controller
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping("/test/{id}")
    @ResponseBody
    public OfferDto getOfferById(@PathVariable int id){
        return offerService.getOfferById(id);
    }

    @GetMapping("/users")
    @ResponseBody
    public List<OfferDto> getAllOffers(){
        return offerService.getAllOffers();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String hello(@PathVariable int id){
        return "id" + id;
    }
}

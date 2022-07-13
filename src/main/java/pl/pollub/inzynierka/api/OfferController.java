package pl.pollub.inzynierka.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.pollub.inzynierka.infrastructure.CreateOfferDto;
import pl.pollub.inzynierka.infrastructure.OfferDto;
import pl.pollub.inzynierka.infrastructure.OfferService;

import java.util.List;

@RequestMapping("/api")
@Controller
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping("/user/{id}")
    @ResponseBody
    public OfferDto getOfferById(@PathVariable int id) {
        return offerService.getOfferById(id);
    }

    @GetMapping("/users")
    @ResponseBody
    public List<OfferDto> getAllOffers() {
        return offerService.getAllOffers();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String hello(@PathVariable int id) {
        return "id" + id;
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createOffer(@RequestBody CreateOfferDto createOfferDto) {
        return ResponseEntity.ok(offerService.createOffer(createOfferDto));
    }


}

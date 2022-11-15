package pl.pollub.application.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.pollub.application.infrastructure.Offer.CreateOfferDto;
import pl.pollub.application.infrastructure.Offer.OfferDto;
import pl.pollub.application.infrastructure.Offer.OfferService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/offer")
@Controller
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<OfferDto> getOfferId(@PathVariable Long id) {
        return offerService.getOfferById(id);
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public List<OfferDto> getAllOffersBelongingToUser(@PathVariable Long id) {
        return offerService.getAllOffersBelongingToUser(id);
    }

    @GetMapping
    @ResponseBody
    public List<OfferDto> getAllOffers(){
        return offerService.getAllOffers();
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createOffer(@RequestBody CreateOfferDto createOfferDto) {
        return ResponseEntity.ok(offerService.createOffer(createOfferDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteOffer(@PathVariable Long id){
        return ResponseEntity.ok(offerService.deleteOffer(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Optional<Long>> editOffer(@RequestBody CreateOfferDto createOfferDto, @PathVariable Long id){
        return ResponseEntity.ok(offerService.editOffer(createOfferDto,id));
    }
}

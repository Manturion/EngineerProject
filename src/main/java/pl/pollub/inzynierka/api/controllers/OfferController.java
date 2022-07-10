package pl.pollub.inzynierka.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.pollub.inzynierka.domain.entities.OfferEntity;
import pl.pollub.inzynierka.infrastructure.services.offerService.OfferService;

import java.util.List;

@RestController
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        super();
        this.offerService = offerService;
    }

    @GetMapping
    public List<OfferEntity> getAllOffers(){
        return offerService.getAllOffers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferEntity> getOfferById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok().body(offerService.getOfferById(id));
    }
}

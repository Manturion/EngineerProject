package pl.pollub.inzynierka.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.pollub.inzynierka.infrastructure.Address.AddressDto;
import pl.pollub.inzynierka.infrastructure.Address.AddressService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class AddressController {

    private final AddressService addressService;
    @ResponseBody
    @GetMapping("/address/{id}")
    public AddressDto getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }
    @ResponseBody
    @GetMapping("/addresses")
    public List<AddressDto> getAllAddresses(){
        return addressService.getAllAddresses();
    }
}

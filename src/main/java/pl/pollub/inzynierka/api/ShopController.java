package pl.pollub.inzynierka.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.pollub.inzynierka.infrastructure.Shop.ShopDto;
import pl.pollub.inzynierka.infrastructure.Shop.ShopService;

import java.util.List;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @GetMapping("/shop/{id}")
    @ResponseBody
    public ShopDto getShopById(@PathVariable Long id){
        return shopService.getShopById(id);
    }
    @ResponseBody
    @GetMapping("/shops")
    public List<ShopDto> getAllShops(){
        return shopService.getAllShops();
    }
}

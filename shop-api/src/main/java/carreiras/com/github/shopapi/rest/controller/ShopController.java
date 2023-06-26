package carreiras.com.github.shopapi.rest.controller;

import carreiras.com.github.shopapi.domain.entity.Shop;
import carreiras.com.github.shopapi.rest.dto.ShopDTORequest;
import carreiras.com.github.shopapi.rest.dto.ShopDTOResponse;
import carreiras.com.github.shopapi.service.ShopService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    @GetMapping
    public List<Shop> findAll() {
        return shopService.findAll();
    }

    @GetMapping("/shop_by_user/{userIdentifier}")
    public List<Shop> findAllByUserIdentifier(@PathVariable String userIdentifier) {
        return shopService.findAllByUserIdentifier(userIdentifier);
    }

    @GetMapping("/{id}")
    public Shop findById(@PathVariable Long id) {
        return shopService.findById(id);
    }

    @PostMapping
    public ShopDTOResponse newShop(@RequestBody @Valid ShopDTORequest shopDTORequest) {
        return shopService.include(shopDTORequest);
    }
}
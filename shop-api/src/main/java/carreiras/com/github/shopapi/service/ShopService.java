package carreiras.com.github.shopapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import carreiras.com.github.shopapi.exception.ResourceNotFoundException;
import carreiras.com.github.shopapi.rest.dto.ShopDTOResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import carreiras.com.github.shopapi.domain.entity.Shop;
import carreiras.com.github.shopapi.domain.repository.ShopRepository;
import carreiras.com.github.shopapi.rest.dto.ShopDTORequest;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;

    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    public List<Shop> findAllByUserIdentifier(String userIdentifier) {
        return shopRepository.findAllByUserIdentifier(userIdentifier);
    }

    public Shop findById(Long id) {
        return shopRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado."));
    }

    public ShopDTOResponse include(ShopDTORequest shopDTORequest) {
        shopDTORequest.setTotal(
                shopDTORequest.getItems()
                        .stream()
                        .map(x -> x.getPrice())
                        .reduce((float) 0, Float::sum)
        );
        Shop shop = shopRepository.save(Shop.convert(shopDTORequest));
        return ShopDTOResponse.convert(shop);
    }
}

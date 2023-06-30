package carreiras.com.github.shopapi.rest.dto;

import java.util.Date;
import java.util.List;

import carreiras.com.github.shopapi.domain.entity.Shop;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopRequestDTO {

    @NotBlank
    private String userIdentifier;

    private Float total;

    private Date dateShop;
    
    @NotNull
    private List<ItemRequestDTO> items;

    public static ShopRequestDTO convert(Shop shop) {
        ShopRequestDTO shopRequestDTO = new ShopRequestDTO();
        shopRequestDTO.setUserIdentifier(shop.getUserIdentifier());
        shopRequestDTO.setTotal(shop.getTotal());
        shopRequestDTO.setDateShop(shop.getDateShop());
        return shopRequestDTO;
    }
}

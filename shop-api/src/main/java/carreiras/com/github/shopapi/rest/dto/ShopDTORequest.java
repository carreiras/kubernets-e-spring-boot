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
public class ShopDTORequest {

    @NotBlank
    private String userIdentifier;

    private Float total;

    private Date dateShop;
    
    @NotNull
    private List<ItemDTORequest> items;

    public static ShopDTORequest convert(Shop shop) {
        ShopDTORequest shopDTORequest = new ShopDTORequest();
        shopDTORequest.setUserIdentifier(shop.getUserIdentifier());
        shopDTORequest.setTotal(shop.getTotal());
        shopDTORequest.setDateShop(shop.getDateShop());
        return shopDTORequest;
    }
}

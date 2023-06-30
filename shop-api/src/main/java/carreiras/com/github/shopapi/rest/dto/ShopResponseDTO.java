package carreiras.com.github.shopapi.rest.dto;

import carreiras.com.github.shopapi.domain.entity.Shop;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopResponseDTO {

    private String userIdentifier;
    private Float total;
    private Date dateShop;

    public static ShopResponseDTO convert(Shop shop) {
        return ShopResponseDTO.builder()
                .userIdentifier(shop.getUserIdentifier())
                .total(shop.getTotal())
                .dateShop(shop.getDateShop())
                .build();
    }
}

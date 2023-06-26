package carreiras.com.github.shopapi.domain.entity;

import carreiras.com.github.shopapi.rest.dto.ItemDTORequest;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private String productIdentifier;
    private Float price;

    public static Item convert(ItemDTORequest itemDTORequest) {
        return Item.builder()
                .productIdentifier(itemDTORequest.getProductIdentifier())
                .price(itemDTORequest.getPrice())
                .build();
    }
}

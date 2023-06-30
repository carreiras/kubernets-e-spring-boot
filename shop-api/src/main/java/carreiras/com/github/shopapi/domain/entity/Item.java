package carreiras.com.github.shopapi.domain.entity;

import carreiras.com.github.shopapi.rest.dto.ItemRequestDTO;
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

    public static Item convert(ItemRequestDTO itemRequestDTO) {
        return Item.builder()
                .productIdentifier(itemRequestDTO.getProductIdentifier())
                .price(itemRequestDTO.getPrice())
                .build();
    }
}

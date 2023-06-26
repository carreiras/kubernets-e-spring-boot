package carreiras.com.github.shopapi.rest.dto;

import carreiras.com.github.shopapi.domain.entity.Item;
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
public class ItemDTORequest {

    @NotBlank
    private String productIdentifier;
    @NotNull
    private Float price;

    public static ItemDTORequest convert(Item item) {
        ItemDTORequest itemDTORequest = new ItemDTORequest();
        itemDTORequest.setProductIdentifier(
                item.getProductIdentifier());
        itemDTORequest.setPrice(item.getPrice());
        return itemDTORequest;
    }
}

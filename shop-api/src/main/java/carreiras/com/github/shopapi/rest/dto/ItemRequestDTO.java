package carreiras.com.github.shopapi.rest.dto;

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
public class ItemRequestDTO {

    @NotBlank
    private String productIdentifier;
    @NotNull
    private Float price;

    // public static ItemRequestDTO convert(Item item) {
    // ItemRequestDTO itemRequestDTO = new ItemRequestDTO();
    // itemRequestDTO.setProductIdentifier(
    // item.getProductIdentifier());
    // itemRequestDTO.setPrice(item.getPrice());
    // return itemRequestDTO;
    // }
}

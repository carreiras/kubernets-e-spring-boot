package carreiras.com.github.shopapi.rest.dto;

import carreiras.com.github.shopapi.domain.entity.Shop;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopDTOResponse {

    private String userIdentifier;
    private Float total;
    private Date dateShop;
}

package carreiras.com.github.shopapi.domain.entity;

import carreiras.com.github.shopapi.rest.dto.ShopDTORequest;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    private String userIdentifier;

    @Setter
    private float total;

    @Setter
    private Date dateShop;

    @Setter
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item", joinColumns = @JoinColumn(name = "shop_id"))
    private List<Item> items;

    public static Shop convert(ShopDTORequest shopDTORequest) {
        return Shop.builder()
                .userIdentifier(shopDTORequest.getUserIdentifier())
                .total(shopDTORequest.getTotal())
                .dateShop(new Date())
                .items(shopDTORequest.getItems()
                        .stream()
                        .map(Item::convert)
                        .collect(Collectors.toList()))
                .build();
    }
}

package carreiras.github.com.productapi.rest.dto;

import carreiras.github.com.productapi.domain.entity.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDTOResponse {

    private Long id;
    private String name;
    private Float price;
    private String description;
    private String identifier;
    private CategoryDTOResponse category;

    public static ProductDTOResponse convert(Product product) {
        CategoryDTOResponse categoryDTOResponse = CategoryDTOResponse.convert(product.getCategory());

        return ProductDTOResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .identifier(product.getIdentifier())
                .category(categoryDTOResponse)
                .build();
    }
}

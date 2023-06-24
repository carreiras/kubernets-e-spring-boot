package carreiras.github.com.productapi.dto;

import carreiras.github.com.productapi.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ProductDto {

    @NotBlank(message = "O Identificador deve ser informado")
    private String identifier;

    @NotBlank(message = "O Nome deve ser informado")
    private String name;

    @NotBlank(message = "A Descrição deve ser informada")
    private String description;

    @NotNull(message = "O Preço deve ser informado")
    private Float price;

    @NotNull(message = "A Categoria deve ser informada")
    private CategoryDto category;

    public static ProductDto convert(Product product) {
        CategoryDto categoryDto = CategoryDto.convert(product.getCategory());

        return ProductDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .identifier(product.getIdentifier())
                .description(product.getDescription())
                .category(categoryDto)
                .build();
    }
}

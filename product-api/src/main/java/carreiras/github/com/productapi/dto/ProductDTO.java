package carreiras.github.com.productapi.dto;

import carreiras.github.com.productapi.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
public class ProductDTO {

    @Getter
    @NotBlank
    private String productIdentifier;

    @Getter
    @NotBlank
    private String nome;

    @Getter
    @NotBlank
    private String descricao;

    @Getter
    @NotNull
    private Float preco;

    @Getter
    @NotNull
    private CategoryDTO categoryDTO;

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setProductIdentifier(product.getProductIdentifier());
        productDTO.setDescricao(product.getDescricao());
        if (product.getCategory() != null) {
            productDTO.setCategoryDTO(CategoryDTO.convert(product.getCategory()));
        }
        return productDTO;
    }

}

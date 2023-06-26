package carreiras.github.com.productapi.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ProductDTO {

    @NotNull(message = "A Categoria deve ser informada")
    private Long category_id;

    @NotBlank(message = "A Descrição deve ser informada")
    private String description;

    @NotBlank(message = "O Identificador deve ser informado")
    private String identifier;

    @NotBlank(message = "O Nome deve ser informado")
    private String name;

    @NotNull(message = "O Preço deve ser informado")
    private Float price;
}

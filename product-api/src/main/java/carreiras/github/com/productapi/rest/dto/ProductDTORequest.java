package carreiras.github.com.productapi.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDTORequest {

    @NotBlank(message = "O Nome deve ser informado")
    private String name;

    @NotNull(message = "O Preço deve ser informado")
    private Float price;

    @NotBlank(message = "A Descrição deve ser informada")
    private String description;

    @NotBlank(message = "O Identificador deve ser informado")
    private String identifier;

    @NotNull(message = "A Categoria deve ser informada")
    private Long category_id;
}

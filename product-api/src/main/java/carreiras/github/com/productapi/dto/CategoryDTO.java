package carreiras.github.com.productapi.dto;

import carreiras.github.com.productapi.entity.Category;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
public class CategoryDTO {

    @Getter
    @NotNull
    private Long id;

    @Getter
    private String nome;

    public static CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }
}

package carreiras.github.com.productapi.rest.dto;

import carreiras.github.com.productapi.domain.entity.Category;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryDTOResponse {

    private Long id;
    private String name;

    public static CategoryDTOResponse convert(Category category) {
        return CategoryDTOResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}

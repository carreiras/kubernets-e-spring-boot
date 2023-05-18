package carreiras.github.com.productapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity(name="categories")
public class Category {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String nome;

    // gets e sets

//    public static Category convert(CategoryDTO categoryDTO) {
//        Category category = new Category();
//        category.setId(categoryDTO.getId());
//        category.setNome(categoryDTO.getNome());
//        return category;
//    }
}

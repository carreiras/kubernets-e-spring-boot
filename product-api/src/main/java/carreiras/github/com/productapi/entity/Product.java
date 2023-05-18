package carreiras.github.com.productapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity(name = "products")
public class Product {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String nome;

    @Getter
    private Float preco;

    @Getter
    private String descricao;

    @Getter
    private String productIdentifier;

    @Getter
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    // get e sets
//    public static Product convert(ProductDTO productDTO) {
//        Product product = new Product();
//        product.setNome(productDTO.getNome());
//        product.setPreco(productDTO.getPreco());
//        product.setDescricao(productDTO.getDescricao());
//        product.setProductIdentifier(
//                productDTO.getProductIdentifier());
//        if (productDTO.getCategoryDTO() != null) {
//            product.setCategory(
//                    Category.convert(productDTO.getCategoryDTO()));
//        }
//        return product;
//    }
}

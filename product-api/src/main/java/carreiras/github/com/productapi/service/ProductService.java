package carreiras.github.com.productapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import carreiras.github.com.productapi.dto.ProductDto;
import carreiras.github.com.productapi.entity.Category;
import carreiras.github.com.productapi.entity.Product;
import carreiras.github.com.productapi.exception.ResourceNotFoundException;
import carreiras.github.com.productapi.repository.CategoryRepository;
import carreiras.github.com.productapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private static final String CATEGORY_NOT_FOUND = "Categoria não encontrada.";
    private static final String PRODUCT_NOT_FOUND = "Produto não encontrado.";

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByCategoryId(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY_NOT_FOUND));
        return productRepository.findByCategoryId(category.getId());
    }

    public Product findByIdentifier(String identifier) {
        return productRepository.findByIdentifier(identifier)
                .orElseThrow(() -> new ResourceNotFoundException(PRODUCT_NOT_FOUND));
    }

    public Product include(ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategory_id())
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY_NOT_FOUND));

        Product product = Product.convert(productDto, category);
        return productRepository.save(product);
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(PRODUCT_NOT_FOUND));
        productRepository.delete(product);
    }
}

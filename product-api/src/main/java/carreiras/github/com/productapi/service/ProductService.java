package carreiras.github.com.productapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import carreiras.github.com.productapi.domain.entity.Category;
import carreiras.github.com.productapi.domain.entity.Product;
import carreiras.github.com.productapi.domain.repository.CategoryRepository;
import carreiras.github.com.productapi.domain.repository.ProductRepository;
import carreiras.github.com.productapi.exception.ResourceNotFoundException;
import carreiras.github.com.productapi.rest.dto.ProductDTORequest;
import carreiras.github.com.productapi.rest.dto.ProductDTOResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private static final String CATEGORY_NOT_FOUND = "Categoria não encontrada.";
    private static final String PRODUCT_NOT_FOUND = "Produto não encontrado.";

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductDTOResponse include(ProductDTORequest productDTORequest) {
        Category category = categoryRepository.findById(productDTORequest.getCategory_id())
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY_NOT_FOUND));

        return ProductDTOResponse.convert(
                productRepository.save(
                        Product.convert(productDTORequest, category)));
    }

    public List<ProductDTOResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductDTOResponse::convert)
                .collect(Collectors.toList());
    }

    public List<ProductDTOResponse> findByCategoryId(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY_NOT_FOUND));

        return productRepository.findByCategoryId(category.getId())
                .stream()
                .map(ProductDTOResponse::convert)
                .collect(Collectors.toList());
    }

    public ProductDTOResponse findById(long id) {
        return productRepository.findById(id)
                .map(m -> {
                    return ProductDTOResponse.convert(m);
                })
                .orElseThrow(() -> new ResourceNotFoundException(PRODUCT_NOT_FOUND));
    }

    public ProductDTOResponse findByIdentifier(String identifier) {
        return productRepository.findByIdentifier(identifier)
                .map(m -> {
                    return ProductDTOResponse.convert(m);
                })
                .orElseThrow(() -> new ResourceNotFoundException(PRODUCT_NOT_FOUND));
    }

    public void delete(Long id) {
        productRepository.findById(id)
                .map(m -> {
                    productRepository.delete(m);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResourceNotFoundException(PRODUCT_NOT_FOUND));
    }
}

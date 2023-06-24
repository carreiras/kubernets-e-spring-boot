package carreiras.github.com.productapi.service;

import java.util.List;
import java.util.stream.Collectors;

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

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductDto::convert)
                .collect(Collectors.toList());
    }

    public List<ProductDto> findByCategoryId(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada."));
        List<Product> products = productRepository.findByCategoryId(category.getId());
        return products.stream()
                .map(ProductDto::convert)
                .collect(Collectors.toList());
    }

    public ProductDto findByIdentifier(String identifier) {
        Product product = productRepository.findByIdentifier(identifier)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado."));
        return ProductDto.convert(product);
    }

    public ProductDto include(ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategory().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada."));
        productDto.getCategory().setName(category.getName());
        Product product = productRepository.save(Product.convert(productDto));
        return ProductDto.convert(product);
    }

    public void delete(String identifier) {
        Product product = productRepository.findByIdentifier(identifier)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado."));
        productRepository.delete(product);
    }
}

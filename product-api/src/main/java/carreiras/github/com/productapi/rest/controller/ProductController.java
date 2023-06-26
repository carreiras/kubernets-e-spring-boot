package carreiras.github.com.productapi.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carreiras.github.com.productapi.domain.entity.Product;
import carreiras.github.com.productapi.rest.dto.ProductDTO;
import carreiras.github.com.productapi.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/category/{id}")
    public List<Product> findByCategoryId(@PathVariable Long id) {
        return productService.findByCategoryId(id);
    }

    @GetMapping("/{identifier}")
    public Product findByIdentifier(@PathVariable String identifier) {
        return productService.findByIdentifier(identifier);
    }

    @PostMapping()
    public Product include(@RequestBody @Valid ProductDTO productDto) {
        return productService.include(productDto);
    }
}

package carreiras.github.com.productapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carreiras.github.com.productapi.dto.ProductDto;
import carreiras.github.com.productapi.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/category/{id}")
    public List<ProductDto> findByCategoryId(@PathVariable Long id) {
        return productService.findByCategoryId(id);
    }

    @GetMapping("/{identifier}")
    ProductDto findByIdentifier(@PathVariable String identifier) {
        return productService.findByIdentifier(identifier);
    }

    @PostMapping()
    ProductDto include(@RequestBody @Valid ProductDto productDto) {
        return productService.include(productDto);
    }

    @DeleteMapping("/{identifier}")
    void delete(@PathVariable String identifier) {
        productService.delete(identifier);
    }
}

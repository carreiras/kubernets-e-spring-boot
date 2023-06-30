package carreiras.github.com.productapi.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carreiras.github.com.productapi.rest.dto.ProductDTORequest;
import carreiras.github.com.productapi.rest.dto.ProductDTOResponse;
import carreiras.github.com.productapi.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public ProductDTOResponse include(@RequestBody @Valid ProductDTORequest productDTORequest) {
        return productService.include(productDTORequest);
    }

    @GetMapping
    public List<ProductDTOResponse> findAll() {
        return productService.findAll();
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTOResponse> findByCategoryId(@PathVariable Long categoryId) {
        return productService.findByCategoryId(categoryId);
    }
    
    @GetMapping("/{id}")
    public ProductDTOResponse findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/identifier/{identifier}")
    public ProductDTOResponse findByIdentifier(@PathVariable String identifier) {
        return productService.findByIdentifier(identifier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}

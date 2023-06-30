package carreiras.github.com.productapi.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import carreiras.github.com.productapi.domain.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p from products p join categories c on p.category.id = c.id where c.id = :categoryId ")
    List<Product> findByCategoryId(@Param("categoryId") Long categoryId);

    Optional<Product> findByIdentifier(String identifier);
}

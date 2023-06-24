package carreiras.github.com.productapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import carreiras.github.com.productapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p from products p join categories c on p.category.id = c.id where c.id = :id ")
    List<Product> findByCategoryId(@Param("id") Long id);

    Optional<Product> findByIdentifier(String identifier);
}

package carreiras.github.com.productapi.repository;

import carreiras.github.com.productapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

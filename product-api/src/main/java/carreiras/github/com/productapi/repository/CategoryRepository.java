package carreiras.github.com.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import carreiras.github.com.productapi.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

package carreiras.github.com.productapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import carreiras.github.com.productapi.domain.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

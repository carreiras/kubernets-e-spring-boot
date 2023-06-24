package carreiras.com.github.userapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import carreiras.com.github.userapi.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNameContainingIgnoreCase(String name);

    Optional<User> findByCpf(String cpf);
}

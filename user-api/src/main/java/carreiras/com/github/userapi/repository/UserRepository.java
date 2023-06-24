package carreiras.com.github.userapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import carreiras.com.github.userapi.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByCpf(String cpf);

    List<User> findByNameContainingIgnoreCase(String nome);
}

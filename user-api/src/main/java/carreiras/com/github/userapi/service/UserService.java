package carreiras.com.github.userapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import carreiras.com.github.userapi.domain.entity.User;
import carreiras.com.github.userapi.domain.repository.UserRepository;
import carreiras.com.github.userapi.exception.ResourceNotFoundException;
import carreiras.com.github.userapi.rest.dto.UserDTOPost;
import carreiras.com.github.userapi.rest.dto.UserDTOPut;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final String USER_NOT_FOUND = "Usuário não encontrado.";

    private final UserRepository userRepository;

    public void delete(long id) {
        userRepository.findById(id)
                .map(f -> {
                    userRepository.delete(f);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByCpf(String cpf) {
        return userRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND));
    }

    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND));
    }

    public List<User> findByNameContainingIgnoreCase(String name) {
        return userRepository.findByNameContainingIgnoreCase(name);
    }

    public User include(UserDTOPost userDtoPost) {
        User user = User.convert(userDtoPost);
        return userRepository.save(user);
    }

    public User update(Long id, UserDTOPut userDtoPatch) {
        return userRepository.findById(id)
                .map(f -> {
                    User user = User.convert(userDtoPatch);
                    user.setId(id);
                    user.setCpf(f.getCpf());
                    user.setRegistrationDate(f.getRegistrationDate());

                    userRepository.save(user);
                    return user;
                })
                .orElseThrow(() -> new ResourceNotFoundException("Código de usuário inválido."));
    }
}

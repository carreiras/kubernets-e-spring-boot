package carreiras.com.github.userapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import carreiras.com.github.userapi.domain.entity.User;
import carreiras.com.github.userapi.domain.repository.UserRepository;
import carreiras.com.github.userapi.exception.ResourceNotFoundException;
import carreiras.com.github.userapi.rest.dto.UserDTO;
import carreiras.com.github.userapi.rest.dto.UserDTOPut;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final String USER_NOT_FOUND = "Usuário não encontrado.";

    private final UserRepository userRepository;

    public UserDTO include(UserDTO userDTO) {
        User user = User.convert(userDTO);
        User savedUser = userRepository.save(user);
        return UserDTO.convert(savedUser);
    }

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

    public UserDTO findById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND));
        return UserDTO.convert(user);
    }

    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND));
        return UserDTO.convert(user);
    }

    public List<UserDTO> findByNameContainingIgnoreCase(String name) {
        List<User> users = userRepository.findByNameContainingIgnoreCase(name);
        return users.stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

    public UserDTO update(Long id, UserDTOPut userDTOPut) {
        User updatedUser = userRepository.findById(id)
                .map(f -> {
                    User user = User.convert(userDTOPut);
                    user.setId(id);
                    user.setCpf(f.getCpf());
                    user.setRegistrationDate(f.getRegistrationDate());

                    userRepository.save(user);
                    return user;
                })
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND));

        return UserDTO.convert(updatedUser);

    }

    public void delete(long id) {
        userRepository.findById(id)
                .map(f -> {
                    userRepository.delete(f);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResourceNotFoundException(USER_NOT_FOUND));
    }
}

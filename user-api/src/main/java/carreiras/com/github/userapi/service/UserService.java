package carreiras.com.github.userapi.service;


import carreiras.com.github.userapi.Entity.User;
import carreiras.com.github.userapi.dto.UserDTO;
import carreiras.com.github.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

    public UserDTO findById(long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(UserDTO::convert).orElse(null);

    }

    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(User.convert(userDTO));
        return UserDTO.convert(user);
    }

    public void delete(long userId) {
        Optional<User> user = userRepository.findById(userId);
        user.ifPresent(value -> userRepository.delete(value));
//        return null;
    }

    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);
        if (user != null)
            return UserDTO.convert(user);
        return null;
    }

    public List<UserDTO> findByNameContainingIgnoreCase(String name) {
        List<User> users = userRepository.findByNameContainingIgnoreCase(name);
        return users
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }
}

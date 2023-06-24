package carreiras.com.github.userapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import carreiras.com.github.userapi.Entity.User;
import carreiras.com.github.userapi.dto.UserDto;
import carreiras.com.github.userapi.exception.ResourceNotFoundException;
import carreiras.com.github.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserDto::convert)
                .collect(Collectors.toList());
    }

    public UserDto findById(long id) {
        // Optional<User> user = userRepository.findById(userId);
        // return user.map(UserDto::convert).orElse(null);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
        return UserDto.convert(user);

    }

    public UserDto findByCpf(String cpf) {
        // User user = userRepository.findByCpf(cpf);
        // if (user != null)
        // return UserDto.convert(user);
        // return null;
        User user = userRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
        return UserDto.convert(user);
    }

    public List<UserDto> findByNameContainingIgnoreCase(String name) {
        List<User> users = userRepository.findByNameContainingIgnoreCase(name);
        return users
                .stream()
                .map(UserDto::convert)
                .collect(Collectors.toList());
    }

    public UserDto include(UserDto userDto) {
        User user = userRepository.save(User.convert(userDto));
        return UserDto.convert(user);
    }

    public void delete(long id) {
        // Optional<User> user = userRepository.findById(userId);
        // user.ifPresent(value -> userRepository.delete(value));
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
        userRepository.delete(user);
    }
}

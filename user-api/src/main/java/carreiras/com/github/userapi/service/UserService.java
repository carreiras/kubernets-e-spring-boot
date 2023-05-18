package carreiras.com.github.userapi.service;


import carreiras.com.github.userapi.Entity.User;
import carreiras.com.github.userapi.dto.UserDTO;
import carreiras.com.github.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> usuarios = userRepository.findAll();

        return usuarios
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

    public UserDTO findById(long userId) {
        Optional<User> usuario = userRepository.findById(userId);

        if (usuario.isPresent())
            return UserDTO.convert(usuario.get());

        return null;
    }

    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(User.convert(userDTO));

        return UserDTO.convert(user);
    }

    public UserDTO delete(long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent())
            userRepository.delete(user.get());

        return null;
    }

    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);
        if (user != null) {
            return UserDTO.convert(user);
        }
        return null;
    }
    public List<UserDTO> queryByName(String name) {
        List<User> usuarios = userRepository.findByNomeContainingIgnoreCase(name);

        return usuarios
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }
}
package carreiras.com.github.userapi.controller;

import carreiras.com.github.userapi.dto.UserDTO;
import carreiras.com.github.userapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    UserDTO include(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @DeleteMapping("/{id}")
    UserDTO delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/cpf/{cpf}")
    UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @GetMapping("/search")
    public List<UserDTO> queryByName(@RequestParam(required = true) String nome) {
        return userService.findByNameContainingIgnoreCase(nome);
    }
}

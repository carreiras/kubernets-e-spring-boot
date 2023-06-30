package carreiras.com.github.userapi.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import carreiras.com.github.userapi.rest.dto.UserDTO;
import carreiras.com.github.userapi.rest.dto.UserDTOPut;
import carreiras.com.github.userapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDTO include(@RequestBody @Valid UserDTO userDTO) {
        return userService.include(userDTO);
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/cpf/{cpf}")
    public UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @GetMapping("/search")
    public List<UserDTO> findByNameContainingIgnoreCase(@RequestParam(required = true) String name) {
        return userService.findByNameContainingIgnoreCase(name);
    }

        @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody @Valid UserDTOPut userDtoPatch) {
        return userService.update(id, userDtoPatch);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}

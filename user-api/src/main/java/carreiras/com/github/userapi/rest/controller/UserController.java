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

import carreiras.com.github.userapi.domain.entity.User;
import carreiras.com.github.userapi.rest.dto.UserDtoPost;
import carreiras.com.github.userapi.rest.dto.UserDtoPut;
import carreiras.com.github.userapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/cpf/{cpf}")
    public User findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/search")
    public List<User> findByNameContainingIgnoreCase(@RequestParam(required = true) String name) {
        return userService.findByNameContainingIgnoreCase(name);
    }

    @PostMapping
    public User include(@RequestBody @Valid UserDtoPost userDtoPost) {
        return userService.include(userDtoPost);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody @Valid UserDtoPut userDtoPatch) {
        return userService.update(id, userDtoPatch);
    }
}

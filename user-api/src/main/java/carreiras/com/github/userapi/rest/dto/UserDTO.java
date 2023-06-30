package carreiras.com.github.userapi.rest.dto;

import java.util.Date;

import carreiras.com.github.userapi.domain.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {

    private Long id;

    @NotBlank(message = "O Nome deve ser informado")
    private String name;

    @NotBlank(message = "O CPF deve ser informado")
    private String cpf;

    @NotBlank(message = "O Endereço deve ser informado")
    private String address;

    @NotBlank(message = "O E-mail deve ser informado")
    private String email;

    @NotBlank(message = "O Telefone deve ser informado")
    private String phoneNumber;

    @NotNull(message = "A Data de Registro deve ser informada")
    private Date registrationDate;

    public static UserDTO convert(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .cpf(user.getCpf())
                .address(user.getAddress())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .registrationDate(user.getRegistrationDate())
                .build();
    }
}

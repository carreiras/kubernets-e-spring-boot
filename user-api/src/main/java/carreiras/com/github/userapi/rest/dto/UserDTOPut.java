package carreiras.com.github.userapi.rest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTOPut {
    
    @NotBlank(message = "O Nome deve ser informado")
    private String name;

    @NotBlank(message = "O Endereço deve ser informado")
    private String address;

    @NotBlank(message = "O E-mail deve ser informado")
    private String email;

    @NotBlank(message = "O Telefone deve ser informado")
    private String phoneNumber;
}

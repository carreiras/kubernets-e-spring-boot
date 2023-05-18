package carreiras.com.github.userapi.dto;

import carreiras.com.github.userapi.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@AllArgsConstructor
public class UserDTO {

    @Getter
    private String name;

    @Getter
    private String cpf;

    @Getter
    private String address;

    @Getter
    private String email;

    @Getter
    private String phoneNumber;

    @Getter
    private Date registrationDate;

    public static UserDTO convert(User user) {
        return UserDTO.builder()
                .name(user.getName())
                .address(user.getAddress())
                .cpf(user.getCpf())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .registrationDate(user.getRegistrationDate())
                .build();
    }
}

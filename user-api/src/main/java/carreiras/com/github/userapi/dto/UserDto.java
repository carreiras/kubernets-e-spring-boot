package carreiras.com.github.userapi.dto;

import carreiras.com.github.userapi.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class UserDto {

    private String name;
    private String cpf;
    private String address;
    private String email;
    private String phoneNumber;
    private Date registrationDate;

    public static UserDto convert(User user) {
        return UserDto.builder()
                .name(user.getName())
                .address(user.getAddress())
                .cpf(user.getCpf())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .registrationDate(user.getRegistrationDate())
                .build();
    }
}

package carreiras.com.github.userapi.Entity;

import java.util.Date;

import carreiras.com.github.userapi.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf;
    private String address;
    private String email;
    private String phoneNumber;
    private Date registrationDate;

    public static User convert(UserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .address(userDto.getAddress())
                .cpf(userDto.getCpf())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .registrationDate(userDto.getRegistrationDate())
                .build();
    }
}

package carreiras.com.github.userapi.Entity;

import carreiras.com.github.userapi.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public static User convert(UserDTO userDTO) {
        return User.builder()
                .name(userDTO.getName())
                .address(userDTO.getAddress())
                .cpf(userDTO.getCpf())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .registrationDate(userDTO.getRegistrationDate())
                .build();
    }
}

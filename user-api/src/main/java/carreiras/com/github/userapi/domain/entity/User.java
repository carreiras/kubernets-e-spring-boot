package carreiras.com.github.userapi.domain.entity;

import java.util.Date;

import carreiras.com.github.userapi.rest.dto.UserDTO;
import carreiras.com.github.userapi.rest.dto.UserDTOPut;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(unique = true)
    private String cpf;

    private String name;
    private String address;
    private String email;
    private String phoneNumber;

    @Setter
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

    public static User convert(UserDTOPut userDTOPut) {
        return User.builder()
                .name(userDTOPut.getName())
                .address(userDTOPut.getAddress())
                .email(userDTOPut.getEmail())
                .phoneNumber(userDTOPut.getPhoneNumber())
                .build();
    }
}
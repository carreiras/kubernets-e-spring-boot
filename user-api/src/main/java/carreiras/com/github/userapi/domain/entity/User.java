package carreiras.com.github.userapi.domain.entity;

import java.util.Date;

import carreiras.com.github.userapi.rest.dto.UserDtoPost;
import carreiras.com.github.userapi.rest.dto.UserDtoPut;
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

    private String address;

    @Setter
    @Column(unique = true)
    private String cpf;

    private String email;
    private String name;
    private String phoneNumber;

    @Setter
    private Date registrationDate;

    public static User convert(UserDtoPost userDtoPost) {
        return User.builder()
                .name(userDtoPost.getName())
                .address(userDtoPost.getAddress())
                .cpf(userDtoPost.getCpf())
                .email(userDtoPost.getEmail())
                .phoneNumber(userDtoPost.getPhoneNumber())
                .registrationDate(userDtoPost.getRegistrationDate())
                .build();
    }

    public static User convert(UserDtoPut userDtoPut) {
        return User.builder()
                .name(userDtoPut.getName())
                .address(userDtoPut.getAddress())
                .email(userDtoPut.getEmail())
                .phoneNumber(userDtoPut.getPhoneNumber())
                .build();
    }
}
package hello.world.request;

import hello.world.model.UserRegistration;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String email;

    @NotNull
    private String password;

    public RegisterRequest(UserRegistration userRegistration) {
        this.name = userRegistration.getName();
        this.surname = userRegistration.getSurname();
        this.email = userRegistration.getEmail();
        this.password = userRegistration.getPassword();
    }


}

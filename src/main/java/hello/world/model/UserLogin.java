package hello.world.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class UserLogin {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}

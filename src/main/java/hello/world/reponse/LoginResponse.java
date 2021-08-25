package hello.world.reponse;

import hello.world.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResponse {

    private String accessToken;

    private User user;
}

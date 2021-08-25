package hello.world.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    private String email;

    @ToString.Exclude
    private String password;
}

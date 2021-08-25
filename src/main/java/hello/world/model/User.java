package hello.world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class User{

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private List<Book> borrowedBooks;

    private Set<Role> roles;

}

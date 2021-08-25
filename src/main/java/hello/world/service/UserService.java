package hello.world.service;

import hello.world.dao.ApiDAO;
import hello.world.model.User;
import hello.world.model.UserRegistration;
import hello.world.reponse.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class UserService {

    private final ApiDAO apiDAO;

    public UserService(ApiDAO apiDAO) {
        this.apiDAO = apiDAO;
    }

    public LoginResponse login(String username, String password) {
        return apiDAO.login(username, password);
    }

    public User register(UserRegistration userRegistration) {
            return apiDAO.register(userRegistration);
    }
}

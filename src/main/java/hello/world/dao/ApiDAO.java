package hello.world.dao;

import hello.world.model.Book;
import hello.world.model.User;
import hello.world.model.UserRegistration;
import hello.world.reponse.LoginResponse;
import hello.world.request.LoginRequest;
import hello.world.request.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class ApiDAO {

    private final RestTemplate restTemplate;

    private final HttpSession session;

    @Value("${url.api}")
    private String url;

    public ApiDAO(RestTemplate restTemplate, HttpSession session) {
        this.restTemplate = restTemplate;
        this.session = session;
    }

    public List<Book> getBooks() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth((String) session.getAttribute("accessToken"));

        HttpEntity<?> entity = new HttpEntity<>(headers);
        String url = this.url + "/books/search?available=false";

        log.debug("GET {}", url);

        return Arrays.asList(restTemplate.exchange(url, HttpMethod.GET, entity, Book[].class).getBody());
    }

    public User register(UserRegistration userRegistration) {
        RegisterRequest registerRequest = new RegisterRequest(userRegistration);

        log.debug("POST {}/register, body = {}", url, registerRequest);

        return restTemplate.postForObject(url + "/register", registerRequest, User.class);
    }

    public LoginResponse login(String email, String password) {
        LoginRequest loginRequest = new LoginRequest(email, password);

        log.debug("POST {}/login, body = {}", url, loginRequest);

        return restTemplate.postForObject(url + "/login", loginRequest, LoginResponse.class);
    }

    public void deleteBook(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth((String) session.getAttribute("accessToken"));

        HttpEntity<?> entity = new HttpEntity<>(headers);

        log.debug("DELETE {}/books/{}", url, id);

        restTemplate.exchange(url + "/books/{id}", HttpMethod.DELETE, entity, Void.class, id);
    }

}

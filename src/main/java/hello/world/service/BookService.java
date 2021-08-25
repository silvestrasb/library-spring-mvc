package hello.world.service;

import hello.world.dao.ApiDAO;
import hello.world.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class BookService {

    private final ApiDAO apiDAO;

    public BookService(ApiDAO apiDAO) {
        this.apiDAO = apiDAO;
    }

    @GetMapping("/{id}/delete")
    public void deleteBook(@PathVariable("id") Long id){
        apiDAO.deleteBook(id);
    }

    public List<Book> findAllBooks() {
        return apiDAO.getBooks();
    }
}

package hello.world.controller;

import hello.world.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.findAllBooks());
        return "books/book-list";
    }

    @GetMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") Long id, RedirectAttributes attributes) {
        bookService.deleteBook(id);
        return "redirect:/";
    }

}


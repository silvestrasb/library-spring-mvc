package hello.world.controller;

import hello.world.model.User;
import hello.world.model.UserLogin;
import hello.world.model.UserRegistration;
import hello.world.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String home(@AuthenticationPrincipal User user) {
        if (user == null) {
            return "redirect:/login";
        }

        return "redirect:/books";
    }


    @GetMapping("/login")
    public String login(Model model, @AuthenticationPrincipal User user) {
        if (user == null) {
            model.addAttribute("userLogin", new UserLogin());
            return "login";
        }

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model, @AuthenticationPrincipal User user) {
        if (user == null) {
            model.addAttribute("userRegistration", new UserRegistration());
            return "register";
        }

        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistration userRegistration, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "register";
        }

        attributes.addFlashAttribute("registerSuccess", "{register.success}");

        return "redirect:/login";
    }


}

package ru.kireev.FSB_Database_SpringBoot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kireev.FSB_Database_SpringBoot.entities.User;
import ru.kireev.FSB_Database_SpringBoot.service.UserService;
import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class AuthorizationController {

    private final UserService userService;

    @GetMapping("/")
    public String hello() {
        return "helloPage";
    }

    @GetMapping("/authorization/login")
    public String login() {
        return "login";
    }

    @GetMapping("/authorization/newUser")
    public String newUser(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @PostMapping("/authorization/newUser")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "newUser";

        userService.addNewUser(user);
        return "redirect:/authorization/login";
    }
}

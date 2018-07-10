package org.gvp.boookmanager.controller;

import org.gvp.boookmanager.model.User;
import org.gvp.boookmanager.service.UserService;
import org.gvp.boookmanager.support.security.AuthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;


@Controller
public class RootController {

    private final UserService userService;

    @Autowired
    public RootController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String root() {
        return "redirect:books";
    }

    @GetMapping("/books")
    public String books() {
        return "books";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal AuthorizedUser authorizedUser) {
        model.addAttribute("user", authorizedUser.getUser());
        return "profile";
    }

    @RequestMapping(name = "/profile", method = RequestMethod.POST)
    public String updateProfile(@Valid User user, BindingResult result, SessionStatus status, @AuthenticationPrincipal AuthorizedUser authorizedUser) {
        if (result.hasErrors()) {
            return "profile";
        }
        userService.update(user);
        authorizedUser.setUser(user);
        status.setComplete();
        return "redirect:books";
    }
}

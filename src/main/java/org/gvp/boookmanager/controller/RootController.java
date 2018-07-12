package org.gvp.boookmanager.controller;

import org.gvp.boookmanager.service.UserService;
import org.gvp.boookmanager.support.security.AuthorizedUser;
import org.gvp.boookmanager.to.UserTo;
import org.gvp.boookmanager.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
        model.addAttribute("userTo", authorizedUser.getUserTo());
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@Valid UserTo userTo, BindingResult result, SessionStatus status, @AuthenticationPrincipal AuthorizedUser authorizedUser) {
        if (result.hasErrors()) {
            return "profile";
        }
        try {
            userService.update(userTo);
            authorizedUser.setUserTo(userTo);
            status.setComplete();
            return "redirect:books";
        } catch (DataIntegrityViolationException ex) {
            result.rejectValue("email", "email already exist");
            return "profile";
        }

    }

    @GetMapping("/register")
    public String register(ModelMap model) {
        model.addAttribute("userTo", new UserTo());
        model.addAttribute("register", true);
        return "profile";
    }

    @PostMapping("/register")
    public String saveRegister(@Valid UserTo userTo, BindingResult result, SessionStatus status, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("register", true);
            return "profile";
        }
        try {
            userService.create(UserUtil.createNewFromTo(userTo));
            status.setComplete();
            return "redirect:login?success=true";
        } catch (DataIntegrityViolationException ex) {
            result.rejectValue("email", "email already exist");
            model.addAttribute("register", true);
            return "profile";
        }
    }


}

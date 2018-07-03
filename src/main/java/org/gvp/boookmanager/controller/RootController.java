package org.gvp.boookmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        return "redirect:books";
    }

    @GetMapping("/books")
    public String meals() {
        return "books";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
}

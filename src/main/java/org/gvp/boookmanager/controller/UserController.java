package org.gvp.boookmanager.controller;

import org.gvp.boookmanager.model.User;
import org.gvp.boookmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return userService.getAll();
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") int id) {
        return userService.get(id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
       userService.delete(id);
    }

    @PostMapping
    public void createOrUpdate(@Valid @ModelAttribute User user) {
        if (user.getId() == null) {
            userService.create(user);
        } else {
            userService.update(user);
        }
    }

    @PostMapping(value = "/{id}")
    public void enable(@PathVariable("id") int id, @RequestParam("enabled") boolean enabled) {
        userService.enable(id, enabled);
    }
}

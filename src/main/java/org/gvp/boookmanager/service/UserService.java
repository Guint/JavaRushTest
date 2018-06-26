package org.gvp.boookmanager.service;

import org.gvp.boookmanager.model.User;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(int id);

    User get(int id);

    User getByEmail(String email);

    void update(User user);

    List<User> getAll();

    void enable(int id, boolean enable);

    User getWithMeals(int id);
}

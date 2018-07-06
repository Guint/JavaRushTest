package org.gvp.boookmanager.service;

import org.gvp.boookmanager.model.User;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(long id);

    User get(long id);

    void update(User user);

    List<User> getAll();

    void enable(long id, boolean enabled);

}

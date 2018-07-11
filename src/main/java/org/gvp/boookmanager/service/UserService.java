package org.gvp.boookmanager.service;

import org.gvp.boookmanager.model.User;
import org.gvp.boookmanager.to.UserTo;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(long id);

    User get(long id);

    void update(User user);

    void update(UserTo userTo);

    List<User> getAll();

    void enable(long id, boolean enabled);

}

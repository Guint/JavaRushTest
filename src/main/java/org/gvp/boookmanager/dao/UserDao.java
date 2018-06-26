package org.gvp.boookmanager.dao;

import org.gvp.boookmanager.model.User;

import java.util.List;

public interface UserDao {

    User save(User user);

    boolean delete(int id);

    User get(int id);

    User getByEmail(String email);

    List<User> getAll();
}

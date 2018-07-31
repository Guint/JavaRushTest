package org.gvp.boookmanager.service;

import org.gvp.boookmanager.dao.UserDao;
import org.gvp.boookmanager.model.User;
import org.gvp.boookmanager.support.security.AuthorizedUser;
import org.gvp.boookmanager.to.UserTo;
import org.gvp.boookmanager.util.UserUtil;
import org.gvp.boookmanager.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static org.gvp.boookmanager.util.ValidationUtil.*;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public User create(User user) {
        return userDao.save(UserUtil.prepareToSave(user, passwordEncoder));
    }

    @Transactional
    @Override
    public void delete(long id) {
        checkNotFoundWithId(userDao.delete(id), id);
    }

    @Override
    public User get(long id) {
        return checkNotFoundWithId(userDao.get(id), id);
    }


    @Transactional
    @Override
    public void update(User user) {
        userDao.save(user);
    }


    @Transactional
    @Override
    public void update(UserTo userTo) {
        User user = UserUtil.updateFromTo(get(userTo.getId()), userTo);
        userDao.save(UserUtil.prepareToSave(user, passwordEncoder));
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Transactional
    @Override
    public void enable(long id, boolean enabled) {
        User user = get(id);
        user.setEnabled(enabled);
        userDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.getByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }
}

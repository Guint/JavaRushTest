package org.gvp.boookmanager.support.security;


import org.gvp.boookmanager.model.User;
import org.gvp.boookmanager.to.UserTo;
import org.gvp.boookmanager.util.UserUtil;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {

    private UserTo userTo;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.getRoles());
        this.userTo = UserUtil.asTo(user);
    }

    public long getId() {
        return userTo.getId();
    }

    public UserTo getUserTo() {
        return userTo;
    }

    public void setUserTo(UserTo userTo) {
        this.userTo = userTo;
    }
}

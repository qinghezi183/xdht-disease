package com.xdht.disease.common.core;

import com.xdht.disease.common.model.User;
import org.springframework.stereotype.Service;

/**
 * @author lzf
 */
@Service
public class UserService {

    private ThreadLocal<User> loginUser = new ThreadLocal<User>();

    public void setUser(User user) {

        loginUser.set(user);
    }

    public User getUser() {
        return loginUser.get();
    }
}

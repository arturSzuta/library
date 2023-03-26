package com.sda.service;

import com.sda.api.UserLoginData;
import com.sda.model.User;
import com.sda.provider.UserFileProvider;
import com.sda.provider.UserProvider;

import java.util.Optional;

public class UserService implements UserLoginChecker {

    private UserProvider userProvider;

    public UserService() {
        userProvider = new UserFileProvider();
    }

    public UserService(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @Override
    public Optional<User> loginAndGet(UserLoginData userLoginData) {
        return userProvider.getAllUsers().stream()
                .filter(user -> checkIfUserExist(userLoginData, user))
                .filter(user -> checkPassword(userLoginData, user))
                .findFirst();
    }

    private boolean checkIfUserExist(UserLoginData userLoginData, User user) {
        return user.getLogin().equals(userLoginData.getLogin());
    }

    private boolean checkPassword(UserLoginData userLoginData, User user) {
        return user.getPassword().equals(userLoginData.getPassword());
    }

}

package com.sda.controller;

import com.sda.api.UserLoginData;
import com.sda.model.User;
import com.sda.service.UserLoginChecker;
import com.sda.service.UserService;
import com.sda.view.LoginView;
import com.sda.view.MainMenuView;
import com.sda.view.View;

import java.util.Optional;

public class UserLoginControllerImpl implements UserLoginController {

    private UserLoginChecker userLoginChecker;

    public UserLoginControllerImpl() {
        this.userLoginChecker = new UserService();
    }

    public UserLoginControllerImpl(UserLoginChecker userLoginChecker) {
        this.userLoginChecker = userLoginChecker;
    }

    @Override
    public View login(UserLoginData userLoginData) {
        Optional<User> user = userLoginChecker.loginAndGet(userLoginData);
        if (user.isPresent()) {
            return new MainMenuView();
        }
        return new LoginView(Optional.of("Podano błędne dane logowania"));
    }

}

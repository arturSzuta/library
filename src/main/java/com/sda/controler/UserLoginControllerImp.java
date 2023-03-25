package com.sda.controler;

import com.sda.api.UserLoginData;
import com.sda.view.LoginView;
import com.sda.view.MainMenuView;
import com.sda.view.View;

public class UserLoginControllerImp implements UserLoginController{
    @Override
    public View login(UserLoginData userLoginData) {
        if (true) {
            return new MainMenuView();
        }
        return new LoginView();
    }
}

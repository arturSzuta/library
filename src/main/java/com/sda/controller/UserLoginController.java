package com.sda.controller;

import com.sda.api.UserLoginData;
import com.sda.view.View;

public interface UserLoginController {

    View login(UserLoginData userLoginData);

}

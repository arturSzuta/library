package com.sda.controler;

import com.sda.api.UserLoginData;
import com.sda.view.View;

public interface UserLoginController {
    View login(UserLoginData userLoginData);
}

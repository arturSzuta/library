package com.sda.view;

import com.sda.api.UserLoginData;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

class LoginViewTest {

    private final static UserLoginData USER_LOGIN_DATA = new UserLoginData(
            "testLogin",
            "testPassword"
    );

    @Test
    void shouldProvideUserLoginDataBasedOnScannerInput() throws FileNotFoundException {
        LoginView loginView = new LoginView(
                new File("src/test/resources/loginInputData"),
                null // irrelevant to the test case
        );

        assertThat(loginView.getData()).isEqualTo(USER_LOGIN_DATA);
    }

}
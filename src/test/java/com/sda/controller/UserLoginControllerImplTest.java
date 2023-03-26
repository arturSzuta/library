package com.sda.controller;

import com.sda.api.UserLoginData;
import com.sda.model.User;
import com.sda.service.UserLoginChecker;
import com.sda.view.LoginView;
import com.sda.view.MainMenuView;
import com.sda.view.View;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.sda.UserDataFactory.getExampleSingleUser;
import static org.assertj.core.api.Assertions.assertThat;

class UserLoginControllerImplTest {

    private static final UserLoginData CORRECT_USER_LOGIN_DATA = new UserLoginData("correctLogin", "correctPassword");
    private static final UserLoginData INCORRECT_USER_LOGIN_DATA = new UserLoginData("incorrectLogin", "incorrectPassword");

    private UserLoginControllerImpl userLoginController = new UserLoginControllerImpl(
        new MockUserLoginChecker()
    );

    @Test
    void whenUserLoginDataIsCorrectThenShouldReturnMainMenuView() {
        //when
        View result = userLoginController.login(CORRECT_USER_LOGIN_DATA);

        //then
        assertThat(result).isInstanceOf(MainMenuView.class);
    }

    @Test
    void whenUserLoginDataIsIncorrectThenShouldReturnLoginView() {
        //when
        View result = userLoginController.login(INCORRECT_USER_LOGIN_DATA);

        //then
        assertThat(result).isInstanceOf(LoginView.class);
    }


    private class MockUserLoginChecker implements UserLoginChecker {
        @Override
        public Optional<User> loginAndGet(UserLoginData userLoginData) {
            if (userLoginData.equals(CORRECT_USER_LOGIN_DATA)) {
                return Optional.of(getExampleSingleUser());
            } else {
                return Optional.empty();
            }
        }
    }

}
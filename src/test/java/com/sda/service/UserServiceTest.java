package com.sda.service;

import com.sda.UserDataFactory;
import com.sda.api.UserLoginData;
import com.sda.model.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {

    public static final String TEST_CORRECT_LOGIN = "test";
    public static final String TEST_CORRECT_PASSWORD = "test789";
    public static final String TEST_NON_EXISTING_LOGIN = "nonExistingLogin";
    public static final String TEST_INCORRECT_PASSWORD = "incorrectPassword";

    private final UserLoginChecker userLoginChecker = new UserService(
            UserDataFactory::getExampleUserData
    );

    @Test
    void shouldReturnLoggedUserForCorrectLoginData() {
        //when
        Optional<User> result = userLoginChecker.loginAndGet(new UserLoginData(TEST_CORRECT_LOGIN, TEST_CORRECT_PASSWORD));

        //then
        assertThat(result).isPresent();
        assertThat(result.get().getLogin()).isEqualTo(TEST_CORRECT_LOGIN);
        assertThat(result.get().getPassword()).isEqualTo(TEST_CORRECT_PASSWORD);
    }

    @Test
    void shouldBeEmptyIfUserLoginDoNotExist() {
        //when
        Optional<User> result = userLoginChecker.loginAndGet(new UserLoginData(TEST_NON_EXISTING_LOGIN, ""));

        //then
        assertThat(result).isEmpty();
    }

    @Test
    void shouldBeEmptyIfUserPasswordIsIncorrect() {
        //when
        Optional<User> result = userLoginChecker.loginAndGet(new UserLoginData(TEST_CORRECT_LOGIN, TEST_INCORRECT_PASSWORD));

        //then
        assertThat(result).isEmpty();
    }

}
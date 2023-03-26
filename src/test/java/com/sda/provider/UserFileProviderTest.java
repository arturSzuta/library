package com.sda.provider;

import com.sda.model.User;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.sda.UserDataFactory.getExampleUserData;
import static org.assertj.core.api.Assertions.assertThat;

class UserFileProviderTest {

    @Test
    void shouldProvideAllUsersFromFile() {
        //given
        Set<User> expectedResult = getExampleUserData();
        UserProvider userProvider = new UserFileProvider("src/test/resources/test_users");
        //when
        Set<User> result = userProvider.getAllUsers();
        //then
        assertThat(result).containsAll(expectedResult);
    }

}
package com.sda.provider;

import com.sda.model.Address;
import com.sda.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static com.sda.model.Role.ADMIN;
import static com.sda.model.Role.USER;

import static org.assertj.core.api.Assertions.assertThat;

class UserFileProviderTest {

    Set<User> expectedResult = Set.of(
            new User(
                    "Jan",
                    "Nowak",
                    "jano",
                    "jano@gmail.com",
                    "password123",
                    new Address(
                            "Wiejska",
                            "16",
                            "",
                            "01-256"
                    ),
                    List.of(USER, ADMIN)),
            new User(
                    "Test",
                    "Test",
                    "test",
                    "test@gmail.com",
                    "test789",
                    new Address(
                            "Testowa",
                            "10",
                            "2",
                            "01-000"
                    ),
                    List.of(USER))
    );

    @Test
    void shouldProvideAllUsersFromFile() {
        //given
        UserProvider userProvider = new UserFileProvider("src/test/resources/test_users");
        //when
        Set<User> result = userProvider.getAllUsers();
        //then
        assertThat(result).containsAll(expectedResult);
    }

}
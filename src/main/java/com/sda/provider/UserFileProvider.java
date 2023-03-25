package com.sda.provider;

import com.sda.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class UserFileProvider implements UserProvider {

    private String filePath = "src/main/resources/users";

    public UserFileProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Set<User> getAllUsers() {
        Set<User> users = new HashSet<>();
        addAllUsersFromFileToList(users);
        return users;
    }

    private void addAllUsersFromFileToList(Set<User> users) {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                users.add(mapToUser(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private User mapToUser(String userLine) {
        return null;
    }

}

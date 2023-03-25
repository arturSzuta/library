package com.sda.provider;

import com.sda.model.Address;
import com.sda.model.Role;
import com.sda.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        String[] lineResult = userLine.split(";");
        User.builder()
                .name(lineResult[0])
                .lastName(lineResult[1])
                .login(lineResult[2])
                .password(lineResult[3])
                .address(mapToAddress(lineResult))
                .roles(mapToRoles(lineResult))
                .build();

        return null;
    }

    private List<Role> mapToRoles(String[] lineResult) {
        return Arrays.stream(lineResult[8].split("/"))
                .map(Role::valueOf)
                .collect(Collectors.toList());
    }

    private Address mapToAddress(String[] lineResult) {
        return Address.builder()
                .street(lineResult[4])
                .buildingNo(lineResult[5])
                .apartmentNo(lineResult[6])
                .postalCode(lineResult[7])
                .build();
    }

}

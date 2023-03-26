package com.sda.provider;

import com.sda.model.Address;
import com.sda.model.Role;
import com.sda.model.User;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class UserFileProvider implements UserProvider {

    private String filePath = "src/main/resources/users";

    public UserFileProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Set<User> getAllUsers() {
        Set<User> users = new HashSet<>();
        addAllUsersFromFileToSet(users);
        return users;
    }

    private void addAllUsersFromFileToSet(Set<User> users) {
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
        return User.builder()
                .name(lineResult[0])
                .lastName(lineResult[1])
                .login(lineResult[2])
                .email(lineResult[3])
                .password(lineResult[4])
                .address(mapToAddress(lineResult))
                .roles(mapToRoles(lineResult))
                .build();
    }

    private Address mapToAddress(String[] lineResult) {
        return Address.builder()
                .street(lineResult[5])
                .buildingNo(lineResult[6])
                .apartmentNo(lineResult[7])
                .postalCode(lineResult[8])
                .build();
    }

    private List<Role> mapToRoles(String[] lineResult) {
        return Arrays.stream(lineResult[9].split("/"))
                .map(Role::valueOf)
                .collect(Collectors.toList());
    }

}

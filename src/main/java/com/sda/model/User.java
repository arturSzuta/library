package com.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String name;
    private String lastName;
    private String login;
    private String email;
    private String password;
    private Address address;
    private List<Role> roles;

}

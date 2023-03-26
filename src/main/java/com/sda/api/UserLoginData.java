package com.sda.api;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class UserLoginData {

    private final String login;
    private final String password;

}

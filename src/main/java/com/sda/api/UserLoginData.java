package com.sda.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor
public class UserLoginData {
    private final String login;
    private final String password;
}

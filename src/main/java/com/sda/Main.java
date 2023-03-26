package com.sda;

import com.sda.view.LoginView;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        LoginView loginView = new LoginView(Optional.empty());
        loginView.display();
    }
}

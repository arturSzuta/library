package com.sda.view;

import com.sda.api.UserLoginData;
import com.sda.controller.UserLoginController;
import com.sda.controller.UserLoginControllerImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class LoginView implements View {

    private Scanner scanner;
    private UserLoginController userLoginController;
    private Optional<String> message;

    public LoginView(Optional<String> message) {
        this.scanner = new Scanner(System.in);
        this.userLoginController = new UserLoginControllerImpl();
        this.message = message;
    }

    public LoginView(File file, UserLoginController userLoginController) throws FileNotFoundException {
        this.scanner = new Scanner(file);
        this.userLoginController = userLoginController;
        this.message = Optional.empty();
    }

    @Override
    public void display() {
        userLoginController.login(getData()).display();
    }

    UserLoginData getData() {
        message.ifPresent(System.out::println);
        System.out.println("Podaj login");
        String login = scanner.nextLine();
        System.out.println("Podaj hasło");
        String password = scanner.nextLine();
        return new UserLoginData(login, password);
    }

}

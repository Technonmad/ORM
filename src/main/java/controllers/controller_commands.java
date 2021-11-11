package controllers;

import model.User;
import services.UserService;

import java.util.List;
import java.util.Scanner;

public class controller_commands {

    private UserService userService = new UserService();
    private User user;
    String login, password;
    Scanner in = new Scanner(System.in);

    public void waitingOperations(String operation){
        if(operation.equals("logout")){
            System.out.println("\tBye bye bye my darling");
            user = null;
        }
        if(operation.equals("login")){
            System.out.print("\tLogin: ");
            login = in.nextLine();
            System.out.print("\tPassword: ");
            password = in.nextLine();

            //попробовать сделать поиск в бд, не скачивая бд в проект

            List<User> users = userService.findAllUsers();

            for (User currentUser: users) {
                if(currentUser.getLogin().equals(login)){
                    if(currentUser.getPassword().equals(password)){
                        user = currentUser;
                        System.out.println("Добро пожаловать, " + login);
                        return;
                    }

                }
                System.out.println("\tПользователя с такими данными не существует");
            }
        }
        if(operation.equals("help")){
            System.out.println("\tAvailable commands: login, logout, register, getUsers, changePassword, changeLogin, deleteUser");
            user = null;
        }
    }
}

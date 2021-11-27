package controllers;

import model.User;
import services.UserService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.Scanner;

public class controller_commands {

    private UserService userService = new UserService();
    private User user;
    String login, password, comment;
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
        if(operation.equals("register")){
            int usersCount = userService.countUsers();

            System.out.print("\tYour login: ");
            login = in.nextLine();
            System.out.print("\tYour password: ");
            password = in.nextLine();
            System.out.print("\tAny comments?: ");
            comment = in.nextLine();

            if (userService.getUser(login) == 0){
                user = new User();
                user.setId(usersCount + 1);
                user.setLogin(login);
                user.setPassword(password);
                user.setComments(comment);
                userService.saveUser(user);
                System.out.println("\tДобро пожаловать на борт, " + login + " !");
            }
            else System.out.println("\tПользователь с такими данными уже существует! ");
        }

        if(operation.equals("getUsers")){
            if(user != null)
                userService.showUsers();
            else System.out.println("\tДружок-пирожок, это операция для авторизованных пользователей! ");



        }
    }
}

import model.User;
import services.UserService;

import java.util.Scanner;
import controllers.controller_commands;

public class Main {

    /*
        Реализуйте регистрацию пользователей. Данные сохранить в БД.
        Реализуйте просмотр списка пользователей.
        Реализуйте удаление пользователей.
        Реализуйте редактирование информации о пользователе.
     +   Реализуйте авторизацию пользователя.
    */


    public static void main(final String[] args) throws Exception {

        controller_commands controller = new controller_commands();
        String command;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Command: ");
        command = in.nextLine();


        do {
            controller.waitingOperations(command);
            System.out.print("Enter Command: ");
            command = in.nextLine();

        } while (!command.equals("quit"));

    }
}
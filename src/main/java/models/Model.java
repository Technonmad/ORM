package models;

import model.User;
import services.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private UserService userService ;
    private User authorizedUser;
    private static Model instance = new Model();


    private Model(){
        userService = new UserService();
    }

    public static Model getInstance() {
        return instance;
    }

    public void addUser(User user){
            userService.saveUser(user);
    }

    public List<String> getList(){
        return userService.findAllUsers().stream().map(User::getLogin).collect(Collectors.toList());
    }
}

import model.User;
import services.UserService;

public class Main {


    public static void main(final String[] args) throws Exception {
        UserService userService = new UserService();
        User user = new User();
        user.setId(1);
        user.setLogin("Anton");
        user.setPassword("123");
        user.setСomments("ASU");
        userService.saveUser(user);
    }
}
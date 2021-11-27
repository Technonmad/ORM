package services;

//import app.dao.UserDao;
//import app.entities.User;

import dao.UserDao;
import model.User;

import java.util.List;

public class UserService {

    private UserDao usersDao = new UserDao();

    public UserService() {
    }

    public User findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    public int getUser(String login) {
        List<User> users = findAllUsers();
        int flag = 0;
        for (User currUser : users) {
            if (currUser.getLogin().equals(login)){
                flag = 1;
                break;
            }
        }
        return flag;
    }


    public int countUsers() { return usersDao.CountUsers(); }

    public void showUsers(){
        List<User> users = usersDao.findAll();
        System.out.println("\tUsers:");
        for (User user: users) {
            System.out.println("\t" + Integer.toString(user.getId())+"\t"+user.getLogin());
        }
    }

}

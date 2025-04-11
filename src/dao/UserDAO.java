package dao;
import model.User;

import java.util.*;

public interface UserDAO {
    boolean addUser(User user);
    boolean hasUsers();
    boolean userExist(String username,String password);
    boolean userIdExist(int userId);
    int getUserId(String username);
    User getUser(int userId);
    List<User> getAllUsers();
    boolean removeUser(int userId);
    void changeEmail(int userId,String email);
    void changeContact(int userId,String contact);
    void changeAge(int userId,int age);
}

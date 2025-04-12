package controller;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

import java.util.*;

public class UserController {
    private UserDAO userDAO=new UserDAOImpl();
    User user;

    public void registerUser(String username,String password,String name,String email,String phone,int age){
        user=new User(username,password,name,email,phone,age);
        if(userDAO.addUser(user))
          System.out.println("Registration Successful!");
    }

    public boolean validUser(String username,String password){
        return userDAO.userExist(username,password);
    }

    public boolean validUserId(int userId){
        return userDAO.userIdExist(userId);
    }

    public int getUserId(String username) {
        return userDAO.getUserId(username);
    }

    public void viewUser(int userId){
        user=userDAO.getUser(userId);
        System.out.println(user);
    }

    public void viewAllUsers(){
        List<User> users=userDAO.getAllUsers();
        if(users.isEmpty()){
            System.out.println("No User exits.");
        }
        else {
            for(User user:users)
                System.out.println(user);
        }
    }

    public boolean hasUsers(){
        return userDAO.hasUsers();
    }

    public void deleteUser(int userId){
        if(userDAO.removeUser(userId))
            System.out.println("User Deleted Successfully");
    }

    public void updateEmail(int userId,String email){
        userDAO.changeEmail(userId,email);
        System.out.println("Your email is updated to "+email);
    }

    public void updateContact(int userId,String contact){
        userDAO.changeContact(userId,contact);
        System.out.println("Your contact is updated to "+contact);
    }

    public void updateAge(int userId,int age){
        userDAO.changeAge(userId,age);
        System.out.println("Your age is updated to "+age);
    }

    public void updatePassword(int userId,String password){
        userDAO.changePassword(userId,password);
        System.out.println("Your password is updated successfully");
    }
}

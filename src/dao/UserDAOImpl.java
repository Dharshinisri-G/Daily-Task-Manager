package dao;

import model.User;

import java.util.*;

public class UserDAOImpl implements UserDAO{
    private final Map<Integer,User> userMap=new HashMap<>();

    @Override
    public boolean addUser(User user) {
        userMap.put(user.getUserId(),user);
        return true;
    }

    @Override
    public boolean hasUsers() {
        return !userMap.isEmpty();
    }

    @Override
    public boolean userExist(String username, String password) {
        for(Map.Entry<Integer, User> e:userMap.entrySet()){
            User user=e.getValue();
            if(user.getUserName().equals(username) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }

    @Override
    public boolean userIdExist(int userId) {
        return userMap.containsKey(userId);
    }

    @Override
    public int getUserId(String username) {
        for(Map.Entry<Integer,User> e:userMap.entrySet()){
            User user=e.getValue();
            if(user.getUserName().equals(username))
                return user.getUserId();
        }
        return 0;
    }

    @Override
    public User getUser(int userId) {
        return userMap.get(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public boolean removeUser(int userId) {
       userMap.remove(userId);
       return true;
    }

    @Override
    public void changeEmail(int userId, String email) {
        userMap.get(userId).setEmail(email);
    }

    @Override
    public void changeContact(int userId, String contact) {
        userMap.get(userId).setPhone(contact);
    }

    @Override
    public void changeAge(int userId, int age) {
        userMap.get(userId).setAge(age);
    }

    @Override
    public void changePassword(int userId, String password) {
        userMap.get(userId).setPassword(password);
    }
}

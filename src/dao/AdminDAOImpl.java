package dao;

import model.Admin;

import java.util.*;

public class AdminDAOImpl implements AdminDAO{
   private final Map<Integer,Admin> adminMap=new HashMap<>();

    @Override
    public boolean addAdmin(Admin admin) {
        adminMap.put(admin.getAdminId(),admin);
        return true;
    }

    @Override
    public boolean adminExist(String username, String password) {
        for(Map.Entry<Integer,Admin> e:adminMap.entrySet()){
            Admin admin=e.getValue();
            if(admin.getUserName().equals(username) && admin.getPassword().equals(password))
                return true;
        }
        return false;
    }

    @Override
    public int getAdminId(String username) {
        for(Map.Entry<Integer,Admin> e:adminMap.entrySet()){
            Admin admin=e.getValue();
            if(admin.getUserName().equals(username))
                return admin.getAdminId();
        }
        return 0;
    }

    @Override
    public Admin getAdmin(int adminId) {
        return adminMap.get(adminId);
    }

    @Override
    public void changeEmail(int adminId, String email) {
        adminMap.get(adminId).setEmail(email);
    }

    @Override
    public void changeContact(int adminId, String contact) {
        adminMap.get(adminId).setPhone(contact);
    }

    @Override
    public void changeAge(int adminId, int age) {
        adminMap.get(adminId).setAge(age);
    }

    @Override
    public void changePassword(int adminId, String password) {
        adminMap.get(adminId).setPassword(password);
    }
}

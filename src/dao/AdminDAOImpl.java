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
        Admin admin=adminMap.get(adminId);
        if(admin!=null){
            admin.setEmail(email);
        }
        else{
            System.out.println("Admin doesn't exist");
        }
    }

    @Override
    public void changeContact(int adminId, String contact) {
        Admin admin=adminMap.get(adminId);
        if(admin!=null){
            admin.setPhone(contact);
        }
        else{
            System.out.println("Admin does't Exist");
        }
    }

    @Override
    public void changeAge(int adminId, int age) {
        Admin admin=adminMap.get(adminId);
        if(admin!=null){
            admin.setAge(age);
        }
        else{
            System.out.println("Admin doesn't exist");
        }
    }
}

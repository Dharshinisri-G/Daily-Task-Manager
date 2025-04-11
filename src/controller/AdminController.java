package controller;

import dao.AdminDAO;
import dao.AdminDAOImpl;
import model.Admin;

public class AdminController {
    private AdminDAO adminDAO=new AdminDAOImpl();
    Admin admin;

    public void registerAdmin(String username,String password,String name,String email,String phone,int age){
        admin=new Admin(username,password,name,email,phone,age);
        if(adminDAO.addAdmin(admin))
          System.out.println("Registration Successful!");
    }

    public boolean validAdmin(String username,String password){
        return adminDAO.adminExist(username,password);
    }

    public int getAdminId(String username) {
        return adminDAO.getAdminId(username);
    }

    public void viewAdmin(int adminId){
        admin=adminDAO.getAdmin(adminId);
        System.out.println(admin);
    }

//    public void deleteuser(int userId){
//        adminDAO.removeUser(userId)
//    }

    public void updateEmail(int userId,String email){
        adminDAO.changeEmail(userId,email);
    }

    public void updateContact(int userId,String contact){
        adminDAO.changeContact(userId,contact);
    }

    public void updateAge(int userId,int age){
        adminDAO.changeAge(userId,age);
    }

}

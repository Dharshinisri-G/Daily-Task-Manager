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

    public void updateEmail(int adminId,String email){
        adminDAO.changeEmail(adminId,email);
        System.out.println("Your email is updated to "+email);
    }

    public void updateContact(int adminId,String contact){
        adminDAO.changeContact(adminId,contact);
        System.out.println("Your contact is updated to "+contact);
    }

    public void updateAge(int adminId,int age){
        adminDAO.changeAge(adminId,age);
        System.out.println("Your age is updated to "+age);
    }

    public void updatePassword(int adminId,String password){
        adminDAO.changePassword(adminId,password);
        System.out.println("Your password is updated successfully");
    }
}
